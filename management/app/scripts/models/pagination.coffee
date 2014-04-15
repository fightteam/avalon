define [
  'underscore'
  'backbone'
], (_, Backbone) ->
	'use strict'

	class PaginationModel extends Backbone.Model

		defaults: 
			page: null
			link: null 
			attr: null

		validate: (attrs, options) ->

		idAttribute: 'id'

		initialize: (options) ->
			# 获取分页信息
			href = options.links[0].href
			if href.indexOf('{') > -1 then tmp = href.indexOf('{') else tmp = href.indexOf('?')
			link = href.substring 0, tmp
			@set 'link', link
			@set 'page', options.page

			@set 'attr', link.substring(link.lastIndexOf('/') + 1)

				

		validate: (attrs, options) ->

		