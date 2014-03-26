model = require '../models/model'
clone = require '../helper/clone'
model = clone model
model.stylesheets.push 
	url:'login.min.css'
model.stylesheets.push 
	url: 'animate.min.css'
model.stylesheets.push 
	url: 'font-awesome.min.css'
model.stylesheets.push 
	url: 'responsive-over-767.min.css'
	media: 'screen and (min-width: 767px)'
model.javascripts.push
	url:'login.min.js'
model.title = 'avalon书城——登陆'
exports.index = (req, res)->

	res.render 'login', model