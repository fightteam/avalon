###
	路由配置
###
module.exports = (app)->

	# home route
	home = require('../controllers/home')
	app.get '/', home.index

	# user route
	user = require '../controllers/user'
	app.get '/user', user.index
