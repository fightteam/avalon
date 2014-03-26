model = require '../models/model'
clone = require '../helper/clone'
model = clone model
model.stylesheets.push 
	url:'register.min.css'
model.stylesheets.push 
	url: 'animate.min.css'
model.stylesheets.push 
	url: 'font-awesome.min.css'
model.stylesheets.push 
	url: 'responsive-over-767.min.css'
	media: 'screen and (min-width: 767px)'
model.javascripts.push
	url:'register.min.js'
model.title = 'avalon书城——注册'

exports.index = (req, res)->
	res.render 'register', model