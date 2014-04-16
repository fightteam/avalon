model = require '../models/model'
clone = require '../helper/clone'
config = require '../config/config'
request = require 'request'

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

exports.post = (req, res)->

	request.post config.rest.register
	,
		form: req.body
	, (error, response, body)->

		if not error and response.statusCode is 200
			res.redirect '/login'
		else
			res.render 'register', model
	