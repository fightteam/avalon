###*
 * 针对页面菜单等等的控制
###
define [
  'jquery'
  'underscore'
  'backbone'
  'templates'
], ($, _, Backbone, JST) ->
  class OperationView extends Backbone.View
    template: JST['app/scripts/templates/app.ejs']

    el: '#page-wrapper'

    events: {}

    initialize: () ->
      # @listenTo @model, 'change', @render
      @render()

    render: () ->
      @$el.html @template({})
