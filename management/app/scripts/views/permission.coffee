define [
  'jquery'
  'underscore'
  'backbone'
  'templates'
  'collections/table'
  'moment'
  'models/pagination'
  'views/pagination'
  'common'
  'messenger'
  'messengerTheme'
  ], ($, _, Backbone, JST, Tables, moment, PaginationModel, PaginationView, config, Messenger) ->

	
			
#=================================================================================== 

	class PermissionView extends Backbone.View
		template: JST['app/scripts/templates/permission.ejs']

		dataTemplate: JST['app/scripts/templates/permission-data.ejs']

		tagName: 'div'

		id: 'permissions'

		className: ''

		events: 
			# 'click #addData': 'addData'
			'click tbody #deleteData': 'deleteData'
			'click tbody #updateData': 'updateData'

		initialize: (options) ->

			@listenTo @model, 'add', @addOne
			@listenTo @model, 'sync', @pagination
			@listenTo @model, 'reset', @restRow


			
			@model.fetch
				data:
					page: options.page.page || 0
					size: options.page.size || 20
		  

		render: () ->
			@$el.html @template {}

		addOne: (model)->
			moment.lang 'zh-CN'
			model.set 
			  'createDate': (moment model.get 'createDate').format('YYYY-MM-DD HH:mm:ss')

			@$("tbody").append @dataTemplate model.toJSON()
			# rowView = new RowView
			#   model: model
			# @$("tbody").append rowView.render()


		# 分页显示渲染
		pagination: (data, response)->
			if @pager
				@pager.remove()
			@pager = new PaginationView
				tables: data
				model: new PaginationModel response
			@$(".panel-body").append @pager.render()
			
		restRow: ()->
			@$("tbody").empty()

		deleteData: (e)->
			id = $(e.target).data 'id'
			if not id
				return
			$.ajax
				url: config.rest.permissions + "/" + id
				headers:
					'Access-Token': config.app.token
				type: "DELETE"
			.done (data, textStatus, jqXHR)->
				$(e.target).parents('tr').remove()
				Messenger().post
					message: "删除成功"
					showCloseButton: true
					hideAfter: 3
			.fail ()->
				Messenger().post
					message: "删除失败"
					type: 'error'
					showCloseButton: true
					hideAfter: 3
			
		updateData: (e)->
			id = $(e.target).data 'id'
			if not id
				return
