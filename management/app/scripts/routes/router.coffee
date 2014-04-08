###*
 * url控制 针对类似与服务请求的控制
###
define [
  'backbone'
  'bootstrap'
], (Backbone) ->
	class Workspace extends Backbone.Router
		routes: 
			'':'dashboard'
			'operations': 'operations'
			'resources': 'resources'
			'permissions': 'permissions'
			'roles': 'roles'
			'users': 'users'
		dashboard: ()->
			require ['views/page', 'models/page'], (pageView, pageModel)->
				view = new pageView
					model: new pageModel
						title: '控制面板'
				$('#page-wrapper').html view.render()

		operations: ()->
			require ['views/page', 'models/page', 'views/operation'], (pageView, pageModel, operationView)->
				view = new pageView
					model: new pageModel
						title: '操作管理'
						view: new operationView()
				$('#page-wrapper').html view.render()

		resources: ()->
			require ['views/page', 'models/page', 'views/resource'], (pageView, pageModel, ResourceView)->
				view = new pageView
					model: new pageModel
						title: '资源管理'
					view: new ResourceView()
				$('#page-wrapper').html view.render()

		permissions: ()->
			require ['views/permission', 'models/page'], (PermissionView)->
				view = new PermissionView()
				$('#page-wrapper').html view.render()

		roles: ()->
			require ['views/page', 'models/page'], (pageView, pageModel)->
				view = new pageView
					model: new pageModel
						title: '角色管理'
				$('#page-wrapper').html view.render()

		users: ()->
			require ['views/page', 'models/page'], (pageView, pageModel)->
				view = new pageView
					model: new pageModel
						title: '用户管理'
				$('#page-wrapper').html view.render()

