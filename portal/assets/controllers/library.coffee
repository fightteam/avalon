model = require '../models/model'
clone = require '../helper/clone'
config = require '../config/config'
request = require 'request'

model = clone model

model.stylesheets.push 
	url: 'animate.min.css'
model.stylesheets.push 
	url: 'responsive-over-767.min.css'
	media: 'screen and (min-width: 767px)'

exports.index = (req, res)->
	model = clone model
	model.stylesheets.push 
		url:'library.min.css'

	model.javascripts.push
		url:'library.min.js'

	username = req.cookies.username
	request.get config.rest.findByUsername + "?username=" + username
	, (error, response, body)->

		model.user = JSON.parse(body).content[0]
		res.render 'library/index', model
	return

exports.book = (req, res)->
	id = req.params.id
	model = clone model
	model.stylesheets.push 
		url:'book.min.css'

	model.javascripts.push
		url:'book.min.js'

	res.render 'library/book', model