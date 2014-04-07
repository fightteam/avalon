define [
  'jquery'
  'underscore'
  'backbone'
  'templates'
  'collections/operation'
  ], ($, _, Backbone, JST, Operations) ->
    class OperationView extends Backbone.View
      template: JST['app/scripts/templates/operation.ejs']

      rowTemplate: JST['app/scripts/templates/operation-row.ejs']

      tagName: 'div'

      id: 'operations'

      className: 'row'

      events: {}

      initialize: () ->
        operations = new Operations()
        @listenTo operations, 'add', @addOne
        operations.fetch
          add: true
          success: (collection, resp)->
            console.log collection
        # @listenTo @model, 'change', @render

      render: () ->
        console.log 'aaa'
        @$el.html @template({})
      addOne: (model)->
        console.log model.toJSON()
        @$("tbody").append @rowTemplate model.toJSON()
        
