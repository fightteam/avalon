blackboard = null
path = null


$(document).ready ()->
	blackboard = $('#blackboard-body');
	# window.addEventListener 'resize', resizeCanvas, false
	paper.install window 
	paper.setup "blackboard-body"

	view.onMouseDown = (event)->
		console.log("down")
		# 忽略中间建和右键
		if event.button is 1 or event.button is 2
			return
		console.log event
		path = new Path()
		start = new Point event.offsetX, event.offsetY
		path.strokeColor = "black"
		path.strokeWidth = 2
		path.add start
		# blackboard.bind 
		# 	mousemove:onMouseMove
		return
	view.onMouseDrag = (event)->
		console.log("move")
		path.add new paper.Point event.offsetX, event.offsetY
		paper.view.draw()
	view.onMouseUp = (event)->
		console.log("up")
		# 忽略中间建和右键
		if event.button is 1 or event.button is 2
			return
		blackboard.unbind 
			mousemove:onMouseMove
	view.onResize = (event)-> 
		console.log '111'
# 重新渲染canvas大小
resizeCanvas = ()->

	blackboard[0].width = window.innerWidth - 32
	blackboard[0].height = window.innerHeight - 55



	
