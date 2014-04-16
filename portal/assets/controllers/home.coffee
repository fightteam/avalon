model = require '../models/model'
clone = require '../helper/clone'
config = require '../config/config'
request = require 'request'

model = clone model
model.stylesheets.push 
	url:'index.min.css'
model.stylesheets.push 
	url: 'animate.min.css'
model.stylesheets.push 
	url: 'responsive-over-767.min.css'
	media: 'screen and (min-width: 767px)'
model.javascripts.push
	url:'home.min.js'
exports.index = (req, res)->

	if not req.cookies.access_token
		return res.render 'index', model

	username = req.cookies.username
	request.get config.rest.findByUsername + "?username=" + username
	, (error, response, body)->
		model.user = JSON.parse(body).content[0]


		res.render 'index', model
	