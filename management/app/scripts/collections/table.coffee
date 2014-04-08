define [
  'underscore'
  'backbone'
  'models/table'
], (_, Backbone, TableModel) ->

	class TableCollection extends Backbone.Collection
		model: TableModel
		# 分页信息
		# page: {}

		parse: (response)->
			@page = response
			# 预留 外部设置
			if @options.parse
				@options.parse.apply response, arguments
			else
				response
		initialize: (options)->
			if options.url
				@url = options.url
			@options = options
			



		
			
			