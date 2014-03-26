model = require '../models/model'
clone = require '../helper/clone'
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
	res.render 'index', model