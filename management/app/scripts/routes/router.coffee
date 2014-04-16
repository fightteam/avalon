###*
 * url控制 针对类似与服务请求的控制
###
define [
  'backbone'
  'jquery'
  'common'
  'views/page'
  'collections/table'
], (Backbone, $, config, PageView, Table) ->
	class Workspace extends Backbone.Router
		routes: 
			'login': 'login'
			'logout': 'logout'
			'':'dashboard'
			'operations': 'operationsView'
			'operations/:id': 'editOperation'
			'resources': 'resourcesView'
			'resources/:id': 'editResource'
			'permissions': 'permissionsView'
			'permissions/:id': 'editPermission'
			'permissionGroups': 'permissionGroupsView'
			'permissionGroups/:id': 'editPermissionGroup'
			'roles': 'rolesView'
			'roles/:id': 'editRole'
			'roleGroups': 'roleGroupsView'
			'roleGroups/:id': 'editRoleGroup'
			'users': 'usersView'
			'users/:id': 'editUser'
			

		login: ()->
			if $("#themeCss").attr('href') isnt 'styles/login.css'
				$("#themeCss").attr('href', 'styles/login.css')
			require ['views/login'], (LoginView)->
				view = new LoginView()
				$('body').html view.render()
				
		logout: ()->
			localStorage.removeItem 'token'
			@navigate 'login', true

		setUp: ()->

			if not config.app.token
				@navigate 'login', true
				return
			else
				oloSync = Backbone.sync
				Backbone.sync = (method, model, options)->
					options.headers = options.headers or {}
					_.extend options.headers, { 'Access-Token': config.app.token }
					oloSync.call method, method, model, options
			# if @view
			# 	@view.remove()
			if $("#themeCss").attr('href') isnt 'styles/avalon-admin.css'
				$("#themeCss").attr('href', 'styles/avalon-admin.css')

			if not @pageView 
				@pageView = new PageView()
				$('body').html @pageView.render()

				

		dashboard: ()->
			@setUp()
		operationsView: (queryStr)->
			
			if queryStr
				params = queryStr.split "&"
				pageParam = params[0].split "="
				sizeParam = params[1].split "="
			else 
				pageParam = ["page", 0]
				sizeParam = ["size", 20]
			@setUp()
			# 按道理有数据了就不应该在获取或者创建
			# 为了简便没有实现
			# if not config.app.operations
			config.app.operations = new Table
				url: config.rest.operations
				parse: (response)->
					if response.status and response.status is 403
						Messenger().post
							message: response.message
							type: 'error'
							showCloseButton: true
							hideAfter: 3
					else if response.status and response.status is 401
						config.app.workspace.navigate 'login', true
			
			
			require ['views/operation'], (OperationView)->
				view = new OperationView
					model: config.app.operations
					page: 
						page: pageParam[1]
						size: sizeParam[1]
				$("#page-wrapper").html view.render()

		editOperation:(id)->
			@setUp()
			
			require ['views/operation-edit', 'models/model'], (OperationEditView, Model)->
				model = new Model
					id: id
					url: config.rest.operations
				view = new OperationEditView
						model:model
				$("#page-wrapper").html view.render()
			return

		resourcesView: (queryStr)->
			
			if queryStr
				params = queryStr.split "&"
				pageParam = params[0].split "="
				sizeParam = params[1].split "="
			else 
				pageParam = ["page", 0]
				sizeParam = ["size", 20]
			@setUp()
			# 按道理有数据了就不应该在获取或者创建
			# 为了简便没有实现
			# if not config.app.operations
			config.app.resources = new Table
				url: config.rest.resources
				parse: (response)->
					if response.status and response.status is 403
						Messenger().post
							message: response.message
							type: 'error'
							showCloseButton: true
							hideAfter: 3
					else if response.status and response.status is 401
						config.app.workspace.navigate 'login', true
			
			
			require ['views/resource'], (ResourceView)->
				view = new ResourceView
					model: config.app.resources
					page: 
						page: pageParam[1]
						size: sizeParam[1]
				$("#page-wrapper").html view.render()

		editResource:(id)->
			@setUp()
			
			require ['views/resource-edit', 'models/model'], (ResourceEditView, Model)->
				model = new Model
					id: id
					url: config.rest.resources
				view = new ResourceEditView
						model:model
				$("#page-wrapper").html view.render()
			return
		
		permissionsView: (queryStr)->
			
			if queryStr
				params = queryStr.split "&"
				pageParam = params[0].split "="
				sizeParam = params[1].split "="
			else 
				pageParam = ["page", 0]
				sizeParam = ["size", 20]
			@setUp()
			# 按道理有数据了就不应该在获取或者创建
			# 为了简便没有实现
			# if not config.app.operations
			config.app.permissions = new Table
				url: config.rest.permissions
				parse: (response)->
					if response.status and response.status is 403
						Messenger().post
							message: response.message
							type: 'error'
							showCloseButton: true
							hideAfter: 3
					else if response.status and response.status is 401
						config.app.workspace.navigate 'login', true
			
			
			require ['views/permission'], (PermissionView)->
				view = new PermissionView
					model: config.app.permissions
					page: 
						page: pageParam[1]
						size: sizeParam[1]
				$("#page-wrapper").html view.render()

		editPermission:(id)->
			@setUp()
			
			require ['views/permission-edit', 'models/model'], (PermissionEditView, Model)->
				model = new Model
					id: id
					url: config.rest.permissions
				view = new PermissionEditView
						model:model
				$("#page-wrapper").html view.render()
			return

		permissionGroupsView: (queryStr)->
			
			if queryStr
				params = queryStr.split "&"
				pageParam = params[0].split "="
				sizeParam = params[1].split "="
			else 
				pageParam = ["page", 0]
				sizeParam = ["size", 20]
			@setUp()
			# 按道理有数据了就不应该在获取或者创建
			# 为了简便没有实现
			# if not config.app.operations
			config.app.permissionGroups = new Table
				url: config.rest.permissionGroups
				parse: (response)->
					if response.status and response.status is 403
						Messenger().post
							message: response.message
							type: 'error'
							showCloseButton: true
							hideAfter: 3
					else if response.status and response.status is 401
						config.app.workspace.navigate 'login', true
			
			
			require ['views/permissionGroup'], (PermissionGroupView)->
				view = new PermissionGroupView
					model: config.app.permissionGroups
					page: 
						page: pageParam[1]
						size: sizeParam[1]
				$("#page-wrapper").html view.render()

		editPermissionGroup:(id)->
			@setUp()
			
			require ['views/permissionGroup-edit', 'models/model'], (PermissionGroupEditView, Model)->
				model = new Model
					id: id
					url: config.rest.permissionGroups
				view = new PermissionGroupEditView
						model:model
				$("#page-wrapper").html view.render()
			return

		rolesView: (queryStr)->
			
			if queryStr
				params = queryStr.split "&"
				pageParam = params[0].split "="
				sizeParam = params[1].split "="
			else 
				pageParam = ["page", 0]
				sizeParam = ["size", 20]
			@setUp()
			# 按道理有数据了就不应该在获取或者创建
			# 为了简便没有实现
			# if not config.app.operations
			config.app.roles = new Table
				url: config.rest.roles
				parse: (response)->
					if response.status and response.status is 403
						Messenger().post
							message: response.message
							type: 'error'
							showCloseButton: true
							hideAfter: 3
					else if response.status and response.status is 401
						config.app.workspace.navigate 'login', true
			
			
			require ['views/role'], (RoleView)->
				view = new RoleView
					model: config.app.roles
					page: 
						page: pageParam[1]
						size: sizeParam[1]
				$("#page-wrapper").html view.render()

		editRole:(id)->
			@setUp()
			
			require ['views/role-edit', 'models/model'], (RoleEditView, Model)->
				model = new Model
					id: id
					url: config.rest.role
				view = new RoleEditView
						model:model
				$("#page-wrapper").html view.render()
			return

		roleGroupsView: (queryStr)->

			if queryStr
				params = queryStr.split "&"
				pageParam = params[0].split "="
				sizeParam = params[1].split "="
			else 
				pageParam = ["page", 0]
				sizeParam = ["size", 20]
			@setUp()
			# 按道理有数据了就不应该在获取或者创建
			# 为了简便没有实现
			# if not config.app.operations
			config.app.roleGroups = new Table
				url: config.rest.roleGroups
				parse: (response)->
					if response.status and response.status is 403
						Messenger().post
							message: response.message
							type: 'error'
							showCloseButton: true
							hideAfter: 3
					else if response.status and response.status is 401
						config.app.workspace.navigate 'login', true
			
			
			require ['views/roleGroup'], (RoleGroupView)->
				view = new RoleGroupView
					model: config.app.roleGroups
					page: 
						page: pageParam[1]
						size: sizeParam[1]
				$("#page-wrapper").html view.render()

		editRoleGroup:(id)->
			@setUp()
			
			require ['views/roleGroup-edit', 'models/model'], (RoleGroupEditView, Model)->
				model = new Model
					id: id
					url: config.rest.roleGroups
				view = new RoleGroupEditView
						model:model
				$("#page-wrapper").html view.render()
			return

		usersView: (queryStr)->
			
			if queryStr
				params = queryStr.split "&"
				pageParam = params[0].split "="
				sizeParam = params[1].split "="
			else 
				pageParam = ["page", 0]
				sizeParam = ["size", 20]
			@setUp()
			# 按道理有数据了就不应该在获取或者创建
			# 为了简便没有实现
			# if not config.app.operations
			config.app.users = new Table
				url: config.rest.users
				parse: (response)->
					if response.status and response.status is 403
						Messenger().post
							message: response.message
							type: 'error'
							showCloseButton: true
							hideAfter: 3
					else if response.status and response.status is 401
						config.app.workspace.navigate 'login', true
			
			
			require ['views/user'], (UserView)->
				view = new UserView
					model: config.app.users
					page: 
						page: pageParam[1]
						size: sizeParam[1]
				$("#page-wrapper").html view.render()

		editUser:(id)->
			@setUp()
			
			require ['views/user-edit', 'models/model'], (UserEditView, Model)->
				model = new Model
					id: id
					url: config.rest.users


				view = new UserEditView
						model:model
				$("#page-wrapper").html view.render()
			return
		
