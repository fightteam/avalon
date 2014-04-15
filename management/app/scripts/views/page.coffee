###*
 * nav 切换页面
###
define [
  'jquery'
  'underscore'
  'backbone'
  'templates'
  'metisMenu'
  'bootstrap'
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
      @$('#side-menu').metisMenu()
      # 适应手机
      $(window).bind "load resize",()->
        if $(@).width() < 768
          @$('div.sidebar-collapse').addClass 'collapse'
        else
          @$('div.sidebar-collapse').removeClass 'collapse'  
      @el

    renderView: (view)->
     
