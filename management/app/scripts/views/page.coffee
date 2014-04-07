###*
 * nav 切换页面
###
define [
  'jquery'
  'underscore'
  'backbone'
  'templates'
], ($, _, Backbone, JST) ->
  class PageView extends Backbone.View
    template: JST['app/scripts/templates/page.ejs']

    tagName: 'div'

    id: ''

    className: 'row'

    events: {}

    initialize: () ->
        @listenTo @model, 'change', @render
        
    render: () ->
        @$el.html @template @model.toJSON()
        @renderView @model.toJSON().view
    renderView: (view)->
        @$el.append view.render()
