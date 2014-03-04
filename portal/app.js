/*
	开发载入服务配置
 */
"use strict";
var app, config, express, fs;

express = require('express');

fs = require('fs');

config = require('./app/config/config');

console.log(config);

app = express();

require('./app/config/express')(app, config);

require('./app/config/routes')(app);

app.listen(config.port);