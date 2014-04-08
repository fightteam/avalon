###*
 * 分页封装
###
define [
  'jquery'
  'underscore'
  'backbone'
  'templates'
], ($, _, Backbone, JST) ->
	class PaginationView extends Backbone.View
		template: JST['app/scripts/templates/pagination.ejs']

		tagName: 'ul'

		id: ''

		className: 'pager'

		initialize: () ->
			@listenTo @model, 'change', @render
			
		render: () ->
			@$el.html @template @model.toJSON()