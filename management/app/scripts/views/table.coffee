define [
  'jquery'
  'underscore'
  'backbone'
  'templates'
], ($, _, Backbone, JST) ->
  class OperationTableView extends Backbone.View
    template: JST['app/scripts/templates/table.ejs']

    tagName: 'div'

    id: 'operationTable'

    className: ''

    events: {}

    initialize: () ->
      console.log @model
      @listenTo @model, 'change', @render

    render: () ->
      @$el.html @template(@model.toJSON())
