define [
  'underscore'
  'backbone'
  'models/table'
  'common'
], (_, Backbone, PermissionModel, config) ->

	class PermissionCollection extends Backbone.Collection
		model: PermissionModel

		url: config.rest.permissions

		parse: (response)->
			response.content
			
		initialize: ()->
			@listenTo @, "remove", @removeOne

		removeOne: (model)->
			model.destroy()