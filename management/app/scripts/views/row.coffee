define [
  'jquery'
  'underscore'
  'backbone'
], ($, _, Backbone) ->
  class RowView extends Backbone.View

    tagName: 'tr'

    id: ''

    className: ''

    events: {}

    initialize: () ->
        console.log 'row' 
        @listenTo @model, 'change', @render

    render: () ->
        for k, v of @model.toJSON()
          td = $("<td/>")
          td.text v
          @$el.append td


