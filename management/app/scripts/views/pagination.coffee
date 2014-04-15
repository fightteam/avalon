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

		events: {
			# "click .pager": "pager"
		}

		initialize: (options) ->
			@listenTo @model, 'change', @render
			@tables = options.tables
			# _.bindAll @, "pager"
		render: () ->

			@$el.html @template @model.toJSON()

		pager: (e)->
			page = @model.get 'page'

			number = $(e.target).data 'page'
			if number isnt undefined
				@tables.reset()
				@tables.fetch
					data: 
						page: number
						size: 20

			
			else if $(e.target).hasClass 'previous-btn'
				@tables.reset()
				@tables.fetch
					data: 
						page: page.number - 1
						size: 20
			else if $(e.target).hasClass 'next-btn'
				@tables.reset()
				@tables.fetch
					data: 
						page: page.number + 1
						size: 20