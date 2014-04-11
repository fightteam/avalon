define [
  'jquery'
  'underscore'
  'backbone'
  'templates'
  'collections/permission'
  'common'
  'moment'
  'helpers/formHelper'
  'models/table'
], ($, _, Backbone, JST, Permissions, config, moment, FormHelper, TableModel) ->

	permissions = new Permissions()

	class RowView extends Backbone.View

		template: JST['app/scripts/templates/permission-row.ejs']

		tagName: 'tr'

		id: ''

		className: ''

		events: 
			'click #delete': 'delete'
			'click #update': 'update'

		initialize: () ->
			@listenTo @model, 'change', @render

		render: () ->
			@$el.html @template @model.toJSON()

		delete: (e)->
			permissions.remove @model
			@remove()
		update: (e)->
			# 提供修页面
			
			# 获取修改数据
	        console.log @model


#=================================================================================== 


	class PermissionView extends Backbone.View
		template: JST['app/scripts/templates/permission.ejs']

		paginationTemplate: JST['app/scripts/templates/pagination.ejs']

		tagName: 'div'

		id: 'permission'

		# className: ''

		events: 
			'click #add': 'add'

		initialize: () ->
			
			@listenTo permissions, 'sync', @renderPagination
			@listenTo permissions, 'add', @addOne
			@listenTo permissions, 'remove', @removeOne
			# 默认 初始化获取数据
			permissions.fetch()
			$.ajax
				url:"http://localhost:8080/avalon-service/permissions"
				username: 'faith'
				password: '123456'
			.done (data)->
				console.log data
			.always ()->
				console.log 'aa'

		render: ()->
			@$el.html @template {}
			@tbody = @$ 'tbody'
			@tableResponsive = @$ '.table-responsive'
			@model = @$ '#editModel'
			@el

		addOne: (model)->
			moment.lang 'zh-CN'
			model.set 
			  'createDate': (moment model.get 'createDate').format('YYYY-MM-DD HH:mm:ss')
			rowView = new RowView
			  model: model
			@tbody.append rowView.render()

		# 钩子操作  提示需要等等
		removeOne: (model)->
			
			console.log 'removeOne'

		renderPagination: (collections, response)->
			@tableResponsive.append @paginationTemplate response

		add: (e)->
			@model.model 'show'

