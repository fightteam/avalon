exports.index = (req, res)->
	res.render 'home/index', 
		title: 'Express1'
		lang: 'zh_CN'
		stylesheets: [
			{
				url:'bootstrap.min.css'
			}
			{
				url:'bootstrap-theme-metro.min.css'
			}
			{
				url:'index.min.css'
			}
		]
		javascripts:[
			{
				head: true
				absolute: true
				url:'http://localhost:35729/livereload.js'
			}
			{
				url:'jquery.min.js'
			}
			{
				url:'bootstrap.min.js'
			}
		]