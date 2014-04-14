###*
 * url控制 针对类似与服务请求的控制
###
define [
  'backbone'
  'jquery'
  'common'
  'bootstrap'
], (Backbone, $, config) ->
	class Workspace extends Backbone.Router
		routes: 
			'login': 'login'
			'':'page'
			':page':'page'
		page: (page)->
			console.log page
			if not config.app.token
				@navigate 'login', true
			if @view
				@view.remove()
			$("#themeCss").attr('href', 'styles/avalon-admin.css')
			require ['views/page'], (PageView)->
				@view = new PageView()
				$('body').html @view.render()
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
			$("#themeCss").attr('href', 'styles/login.css')
			require ['views/login'], (LoginView)->
				@view = new LoginView()
				$('body').html @view.render()
				

				
		dashboard: ()->
			

		operations: ()->
			

		resources: ()->
			

		permissions: ()->
			

		roles: ()->
			

		users: ()->
			

		
		books: ()->
			
		

