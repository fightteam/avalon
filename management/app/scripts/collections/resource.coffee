define [
  'underscore'
  'backbone'
  'models/resource'
], (_, Backbone, ResourceModel) ->

	class ResourceCollection extends Backbone.Collection
		model: ResourceModel
		parse: (response)->
			response._embedded.operations
		initialize: ()->

	re