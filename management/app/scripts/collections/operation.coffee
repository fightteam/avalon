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
			response._embedded.operations
		initialize: ()->

			# $.ajax 
			# 	url: config.rest.operations
			# .done (data)->
			# 	console.log data.content[0]
			# 	add data.content[0]
			
		fetchNew: (options)->
			options = options || {}
			collection = @
			success = options.success
			options.success = (resp, status, xhr)->
				_.each collection.parse(resp, xhr), (item)->
					self = item._links.self.href
					id = self.substring self.lastIndexOf('/') + 1
					console.log id
					if not collection.get(id)
						console.log 33
						collection.add item,
							silent: false
				if not options.silent
					collection.trigger 'rest', collection, options
				if success
					success collection, resp

			(@sync || Backbone.sync).call @, 'read', @, options
				
				
					

	new OperationCollection()