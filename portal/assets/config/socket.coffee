###
	socket.io
###
module.exports = (app)->

	server = require('http').createServer app
	io = require('socket.io').listen server

	io.sockets.on 'connection', (socket)->
		console.log "connection"
		socket.on 'message', (data)->
			console.log "message"
			socket.broadcast.emit 'message', data
	
