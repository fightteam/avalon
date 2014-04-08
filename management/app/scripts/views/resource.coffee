define [
  'jquery'
  'underscore'
  'backbone'
  'templates'
  'views/table'
  'collections/table'
  'common'
], ($, _, Backbone, JST, TabelView, Tables, config) ->
	class ResourceView extends Backbone.View
		template: JST['app/scripts/templates/resource.ejs']

		tagName: 'div'

		id: 'resources'

		className: 'row'

		events: 
			'click #addOperation': 'addOperation'


		initialize: () ->

			@view = new TabelView
				columns:[
					{
						name: 'name'
						label: '资源定义'
					}
					{
						name: 'title'
						label: '显示名称'
					}
					{
						name: 'resourceType'
						label: '资源类型'
					}
					{
						name: 'enable'
						label: '是否可用'
					}
					{
						name: 'createDate'
						label: '创建时间'
					}
					{
						name: 'controls'
						label: '操作'
					}
				]
				pagination: new Tables
					url: config.rest.resources
					parse: (response)->
						response._embedded.resources
				insertRow: (model)->
					model.set 
						'controls': '<button type="button" class="btn btn-danger" id="delete">删除</button><button type="button" class="btn btn-info" id="update">修改</button>'


		render: () ->
			@$el.html @template {}
			@$('.panel-body').append @view.render()
			# 最后渲染
			
			@el
		parse: ()->
