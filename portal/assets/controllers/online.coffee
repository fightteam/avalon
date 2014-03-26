model = require '../models/model'
clone = require '../helper/clone'
model = clone model
model.stylesheets.push 
	url: 'animate.min.css'
model.stylesheets.push 
	url: 'responsive-over-767.min.css'
	media: 'screen and (min-width: 767px)'
model.stylesheets.push 
	url:'online.min.css'

model.javascripts.push
	url:'online.min.js'
exports.index = (req, res)->
	res.render 'online/index', model