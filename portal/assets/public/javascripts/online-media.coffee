connection = null
roomSession = null
$(document).ready ()->
	connection = new RTCMultiConnection()
	connection.session = 
		audio: true
		video: true
		data: true

	connection.onNewSession = (session)->
		console.log("onNewSession")
		console.log session
		roomSession = session

	connection.onstream = (e)->
		console.log("onstream")
		$("#videos").append $("<li/>").append e.mediaElement


	connection.onmessage = (e)->
		console.log("onmessage")

	connection.onclose = (e)->
		console.log("onclose")

	connection.onleave = (e)->
		console.log("onleave")

	connection.onopen = (e)->
		console.log("onopen")

	connection.onFileProgress = (chunk)->
		console.log("onFileProgress")
	
	connection.onFileStart = (file)->
		console.log("onFileStart")
	
	connection.onFileEnd = (file)->
		console.log("onFileEnd")
	
	connection.connect()

	$("#media").delegate '.btn', 'click', ()->
		switch this.id
			when "volume"
				console.log "volume"
			when "video"
				createVideo()
			when "chat"
				console.log "chat" 
			
		

createVideo = ()->
	console.log "video"
	if roomSession 
		connection.join roomSession
	else
		connection.extra = 
			'session-name': 'Anonymous'
		connection.sessionid = 'Anonymous'
		connection.open()