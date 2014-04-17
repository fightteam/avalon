define [
  'jquery'
  'underscore'
  'backbone'
  'templates'
  'common'
], ($, _, Backbone, JST, config) ->
	class LoginView extends Backbone.View
		template: JST['app/scripts/templates/login.ejs']

		tagName: 'div'

		events: 
			"click #login": "login"

		initialize: ()->


		render: ()->
			@$el.html @template {}

			@el
			
		# 登陆
		login: (e)->
			username = @$('#username').val()
			password = @$('#password').val()
			$.ajax
				url: config.rest.login
				crossDomain: true
				type: "POST"
				data:
					username: username
					password: password
				context: @
			.done (data, textStatus, jqXHR)->
				config.app.token = data.token
				localStorage.token = data.token
				@remove()
				config.app.workspace.navigate '', true

				
