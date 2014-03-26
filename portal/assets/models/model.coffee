# for development
config = require '../config/config'

model = {
	title:'avalon书城'
	lang:'zh_CN'
	stylesheets:[
		{
			url:'bootstrap.min.css'
		}
	]
	javascripts:[
		{
			url:'jquery.min.js'
		}
		{
			url:'bootstrap.min.js'
		}
	]
}

if config.livereload
	model.javascripts.push
		head: true
		absolute: true
		url:'http://localhost:35729/livereload.js'


module.exports = model
	
	