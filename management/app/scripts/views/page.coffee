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

    view: null

    initialize: (options) ->
      @view = options.view
      @listenTo @model, 'change', @render

    render: () ->
      
      # 为了dom性能 最后渲染
      @$el.append @template @model.toJSON()
      @$el.append @view.render()

    renderView: (view)->
      @$el.append view.render()
