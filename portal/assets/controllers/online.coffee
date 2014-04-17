model = require '../models/model'
clone = require '../helper/clone'
model = clone model
model.stylesheets.push 
	url: 'animate.min.css'
model.stylesheets.push 
	url: 'font-awesome.min.css'
model.stylesheets.push 
	url: 'typicons.min.css'
model.stylesheets.push 
	url: 'responsive-over-767.min.css'
	media: 'screen and (min-width: 767px)'
model.stylesheets.push 
	url:'online.min.css'

model.javascripts.push
	url:'paper-full.min.js'
model.javascripts.push
	url:'socket.io/socket.io.js'
	absolute: true
# model.javascripts.push
# 	url:'RTCMultiConnection.min.js'
# model.javascripts.push
# 	url:'getMediaElement.min.js'
# model.javascripts.push
# 	url:'online.min.js'
# model.javascripts.push
# 	url:'online-media.min.js'
exports.index = (req, res)->
	res.render 'online/index', model