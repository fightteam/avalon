define [
  'underscore'
  'backbone'
  'models/operation'
  'common'
], (_, Backbone, Operation, config) ->

	class OperationCollection extends Backbone.Collection
		model: Operation
		url: config.rest.operations
		parse: (response)->
			response.content
		initialize: ()->
			# $.ajax 
			# 	url: config.rest.operations
			# .done (data)->
			# 	console.log data.content[0]
			# 	add data.content[0]