mediaStream
navigator.getUserMedia = navigator.mozGetUserMedia || navigator.webkitGetUserMedia;

getAndUpdateMediaElement = ()->
	if not mediaStream
		navigator.getUserMedia 
			viedo: true
		,(stream)->
			mediaStream = stream
			_getMediaElement()
		,()->
	else
		_getMediaElement()
	