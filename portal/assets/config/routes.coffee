###
	路由配置
###
module.exports = (app)->

	

	# home route
	home = require('../controllers/home')
	app.get '/', home.index

	# register route
	register = require '../controllers/register'
	app.get '/register', register.index
	app.post '/register', register.post

	# login route
	login = require '../controllers/login'
	app.get '/login', login.index
	app.post '/login', login.post

	# online route
	online = require '../controllers/online'
	app.get '/online', online.index

	# books route
	library = require '../controllers/library'
	app.get '/library', library.index
	app.get '/library/books/:id', library.book
