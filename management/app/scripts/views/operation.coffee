define [
  'jquery'
  'underscore'
  'backbone'
  'templates'
  'collections/operation'
  'moment'
  'views/operation-edit'
  'models/operation'
  'models/pagination'
  'views/pagination'
  ], ($, _, Backbone, JST, operations, moment, OperationEdit, OperationModel, PaginationModel, PaginationView) ->

	class RowView extends Backbone.View

		template: JST['app/scripts/templates/operation-row.ejs']

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
			operations.remove @model
			@model.destroy
				contentType: 'application/json'
				success: (model, response)->
					console.log model
					@remove()
		update: (e)->
	        console.log @model.links


#=================================================================================== 

	class OperationView extends Backbone.View
		template: JST['app/scripts/templates/operation.ejs']

		tagName: 'div'

		id: 'operations'

		className: 'row'

		events: 
			'click #addOperation': 'addOperation'

		initialize: () ->
			@listenTo operations, 'add', @addOne
			@listenTo operations, 'sync', @pagination
			
			operations.fetch()
		  

		render: () ->
			@$el.html @template({})

		addOne: (model)->
			console.log model
			moment.lang 'zh-CN'
			model.set 
			  'createDate': (moment model.get 'createDate').format('YYYY-MM-DD HH:mm:ss')
			# @$("tbody").append @rowTemplate model.toJSON()
			rowView = new RowView
			  model: model
			@$("tbody").append rowView.render()

		addOperation: (e)->
			operationEdit = new OperationEdit
			  model: new OperationModel()
			@operationEdit = operationEdit
			@$el.append operationEdit.render()
			@operationEdit.show()
			console.log '555'

		pagination: ()->
			console.log 'pagination'
			# @listenTo operations.pagination, 'update', @pagination1

			pagination = new PaginationView
				model: operations.pagination
			console.log pagination
			@$(".panel-body").append pagination.render()
		pagination1: ()->
			console.log 'aaaaa'
