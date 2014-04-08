define [
  'jquery'
  'underscore'
  'backbone'
  'templates'
  'collections/permission'
  'common'
], ($, _, Backbone, JST, Permissions, config) ->

	class PermissionView extends Backbone.View
		template: JST['app/scripts/templates/permission.ejs']

		paginationTemplate: JST['app/scripts/templates/pagination.ejs']

		tagName: 'div'

		id: 'permission'

		# className: ''

		events: 
			'click #addOperation': 'addOperation'

		initialize: () ->
			permissions = new Permissions()
			@listenTo permissions, 'sync', @renderPagination
			@listenTo permissions, 'add', @addOne
			@listenTo permissions, 'remove', @removeOne
			# 默认 初始化获取数据
			permissions.fetch()
		render: ()->
			@$el.html @template {}

		addOne: (model)->
			console.log 'addOne'
		removeOne: (model)->
			console.log model
			console.log 'removeOne'
		renderPagination: (collections, response)->
			@$el.append @paginationTemplate response
