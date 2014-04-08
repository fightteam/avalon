###*
 * table 对象
 * 辅助table控件生成
###
define [
  'underscore'
  'backbone'
], (_, Backbone) ->
  'use strict';

  class TableModel extends Backbone.Model

    defaults: {

    }

    validate: (attrs, options) ->

    idAttribute: 'id'

    initialize: (options) ->
      # 没有id 重新获取
      if options and options._links
        self = options._links.self.href
        @set 'id': self.substring self.lastIndexOf('/') + 1

      
    defaults: {}

    validate: (attrs, options) ->

    parse: (response, options) ->
      self = response._links.self.href
      @set 'id': self.substring self.lastIndexOf('/') + 1
      response


