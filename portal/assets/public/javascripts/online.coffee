path = null
lastPoint = null
strokeEnds = 6

$(document).ready ()->


		

	paper.install window 
	paper.setup "blackboard-body"
	brush = new Tool()
	pencil = new Tool()
	arrows = new Tool()
	eraser = new Tool()
	tachometer = new Tool()
	picture = new Tool()
	
	$('#painter').delegate ".btn", "click", ()->
		# 移除別的按钮选择
		btns = $("#painter .btn");
		for btn in btns
			if btn isnt this
				$(btn).removeClass 'active'
		$(@).addClass 'active'
		switch this.id
			when "brush"
				$this = $(@)
				if $this.hasClass 'active'
					
					brush.activate()
				else
					console.log 1
			when "pencil"
				$this = $(@)
				if $this.hasClass 'active'
					pencil.activate()
				else
					console.log 1
			when "arrows"
				$this = $(@)
				if $this.hasClass 'active'
					arrows.activate()
				else
					console.log 1
					
			when "eraser"
				$this = $(@)
				if $this.hasClass 'active'
					arrows.activate()
				else
					console.log 1
			when "tachometer"
				$this = $(@)
				if $this.hasClass 'active'
					arrows.activate()
				else
					console.log 1
			when "picture"
				$this = $(@)
				if $this.hasClass 'active'
					arrows.activate()
				else
					console.log 1
		
		return

	pencil.onMouseDown = (event)->
		# 忽略中间建和右键
		if event.button is 1 or event.button is 2
			return
		path = new Path()
		path.strokeColor = "black"
		path.strokeWidth = 2
		path.add event.point


	pencil.onMouseDrag = (event)->
		path.add event.point
		
	pencil.onMouseUp = (event)->
		# 忽略中间建和右键
		if event.button is 1 or event.button is 2
			return

	# brush.onMouseDown = (event)->
	# 	console.log("down")
	# 	# 忽略中间建和右键
	# 	if event.button is 1 or event.button is 2
	# 		return
	# 	path = new Path()
	# 	path.fillColor = 
	# 		hue: Math.random() * 360
	# 		saturation: 1
	# 		brightness: 1
		


	# brush.onMouseDrag = (event)->
	# 	console.log("move")
	# 	if event.count is 1
	# 		console.log event.delta.rotate(90)
	# 		addStrokes event.middlePoint, event.delta
	# 	else
	# 		step = event.delta / 2
	# 		step.angle += 90
	# 		top = event.middlePoint + step
	# 		bottom = event.middlePoint - step

	# 		path.add top
	# 		path.insert 0, bottom
	# 	path.smooth()
	# 	lastPoint = event.middlePoint
		
	# brush.onMouseUp = (event)->
	# 	console.log("up")
	# 	# 忽略中间建和右键
	# 	if event.button is 1 or event.button is 2
	# 		return
	
	# 	delta = event.point - lastPoint
	# 	delta.length = brush.maxDistance
	# 	addStrokes event.point, delta
	# 	path.closed = true
	# 	path.smooth()


	brush.onMouseDown = (event)->
		console.log 11111
		# 忽略中间建和右键
		if event.button is 1 or event.button is 2
			return
		path = null
		path = new Path()
		path.fillColor = "black"
		path.add event.point


	brush.onMouseDrag = (event)->
		step = event.delta / 2
		step.angle += 90
		top = event.middlePoint + step
		bottom = event.middlePoint - step

		path.add top
		path.insert 0, bottom
		path.smooth()
		
	brush.onMouseUp = (event)->
		# 忽略中间建和右键
		if event.button is 1 or event.button is 2
			return
		path.add event.point
		path.closed = true
		path.smooth()

# 重新渲染canvas大小
resizeCanvas = ()->

	blackboard[0].width = window.innerWidth - 32
	blackboard[0].height = window.innerHeight - 55


addStrokes = (point, delta)->
	console.log delta.rotate(90)
	step = delta.rotate 90
	strokePoints = strokeEnds * 2 + 1
	point -= step / 2
	step /= strokePoints - 1
	for i in [0..strokePoints-1] by 1
		strokePoint = point + step * i
		offset = delta * (Math.random() * 0.3 + 0.1)
		if i % 2
			offset *= -1
		strokePoint += offset
		path.insert 0, strokePoint
		

	
