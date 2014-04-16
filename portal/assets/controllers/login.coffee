model = require '../models/model'
clone = require '../helper/clone'
config = require '../config/config'
request = require 'request'

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

exports.post = (req, res)->

	request.post config.rest.login
	,
		form: req.body
	, (error, response, body)->
		if not error and response.statusCode is 200
			res.cookie "access_token", JSON.parse(body).token ,
				maxAge:1000*60*60*24*7
			res.cookie "username", req.body.username ,
				maxAge:1000*60*60*24*7
			res.redirect '/'
		else
			res.render 'login', model
