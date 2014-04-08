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
			if response._embedded then response._embedded.permissions else null

			
		initialize: ()->
			