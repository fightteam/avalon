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

    initialize: (options) ->
    	# if options.url
    	# 	@url = options.url
    	
    defaults: {

    }

    validate: (attrs, options) ->


