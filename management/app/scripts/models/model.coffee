define [
  'underscore'
  'backbone'
  'common'
], (_, Backbone, config) ->
	'use strict';

	class OperationModel extends Backbone.Model

		url: null
		
		defaults: {}
			

		initialize: (options) ->
			@url = options.url
			# 如果是新对象 获取数据
			if options.id isnt "new"
				@url = @url + "/" + options.id
				@fetch()
			else
				@set 'id', undefined
				if options.defaults
					 _.extend @defaults, options.defaults
				
				
			
		validate: (attrs, options) ->

		parse: (response, options) ->
			response