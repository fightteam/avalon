define [
  'jquery'
  'underscore'
  'backbone'
  'templates'
  'collections/operation'
  'moment'
  'views/operation-edit'
  'models/operation'
  ], ($, _, Backbone, JST, operations, moment, OperationEdit, OperationModel) ->

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

      
      editTemplate: JST['app/scripts/templates/operation-edit.ejs']

      tagName: 'div'

      id: 'operations'

      className: 'row'

      events: 
        'click #addOperation': 'addOperation'

      initialize: () ->
        @listenTo operations, 'add', @addOne
        operations.fetch
          # add: true
          success: (collection, resp)->
            console.log operations
        # @listenTo @model, 'change', @render
        
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
