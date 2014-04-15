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
			'':'page'
			'operations': 'operationsView'
			'operations/:id': 'editOperation'
			':page':'page'
			
		page: (page)->
			@setUp()
			switch page
				when "operations"
					@operations()
				when "resources"
					@resources()
				when "permissions"
					@permissions()
				when "roles"
					@roles
				when "users"
					@users
				when "books"
					@books
				else
					@dashboard()
			return
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
				view = new OperationEditView
						model:model
				$("#page-wrapper").html view.render()
			return
		resources: ()->
			

		permissions: ()->
			

		roles: ()->
			

		users: ()->
			

		
		books: ()->
			
		newView: (page, id)->
			@setUp()
			switch page
				when "operations"
					@editOperation()
				when "resources"
					@resources()
				when "permissions"
					@permissions()
				when "roles"
					@roles
				when "users"
					@users
				when "books"
					@books
				else
					@dashboard()
			return


		
