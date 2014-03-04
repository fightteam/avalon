/*
	开发载入服务配置
*/

"use strict";
var app, config, express, fs;

express = require('express');

fs = require('fs');

config = require('./config/config');

app = express();

require('./config/express')(app, config);

require('./config/routes')(app);

app.listen(config.port);
