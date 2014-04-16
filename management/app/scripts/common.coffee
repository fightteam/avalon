"use strict"
define [], ()->
	app: 
		token: localStorage.token
		workspace: null
	rest: 
		login: 'http://localhost:8080/avalon-service/login'
		operations: 'http://localhost:8080/avalon-service/operations'
		resources: 'http://localhost:8080/avalon-service/resources'
		permissions: 'http://localhost:8080/avalon-service/permissions'
		permissionGroups: 'http://localhost:8080/avalon-service/permissionGroups'
		roles: 'http://localhost:8080/avalon-service/roles'
		roleGroups: 'http://localhost:8080/avalon-service/roleGroups'
		users: 'http://localhost:8080/avalon-service/users'