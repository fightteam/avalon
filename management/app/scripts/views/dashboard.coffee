define [
  'jquery'
  'underscore'
  'backbone'
  'templates'
], ($, _, Backbone, JST) ->
  class DashboardView extends Backbone.View
    template: JST['app/scripts/templates/dashboard.ejs']

    tagName: 'div'

    id: 'dashboard'

    className: ''

    events: {}

    initialize: () ->
        # @listenTo @model, 'change', @render

    render: () ->
        @$el.html @template({})
