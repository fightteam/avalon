model = require '../models/model'
clone = require '../helper/clone'
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
	res.render 'library/index', model

exports.book = (req, res)->
	id = req.params.id
	model = clone model
	model.stylesheets.push 
		url:'book.min.css'

	model.javascripts.push
		url:'book.min.js'

	res.render 'library/book', model