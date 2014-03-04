###
	开发载入服务配置
###
"use strict"

express = require('express')
fs = require('fs')
config = require('./config/config')

# modelsPath = __dirname + '/app/models'
# fs.readdirSync(modelsPath).forEach (file)->
# 	if file.indexOf('.js') >= 0
# 		require(modelsPath + '/' + file)


app = express()

require('./config/express')(app, config)
require('./config/routes')(app)

app.listen(config.port)