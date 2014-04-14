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

    id: 'wrapper'

    events: {}

    view: null

    initialize: (options) ->
      

    render: () ->
      
      # 为了dom性能 最后渲染
      @$el.html @template {}

      @el

    renderView: (view)->
     
