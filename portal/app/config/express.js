/*
    express框架配置
*/

var express;

express = require('express');

module.exports = function(app, config) {
  return app.configure(function() {
    app.use(express.compress());
    app.use(express["static"](config.root + '/public'));
    app.set('port', config.port);
    app.set('views', config.root + '/views');
    app.set('view engine', 'jade');
    app.use(express.favicon(config.root + '/public/img/favicon.ico'));
    app.use(express.logger('dev'));
    app.use(express.bodyParser());
    app.use(express.methodOverride());
    app.use(app.router);
    return app.use(function(req, res) {
      return res.status(404).render('404', {
        title: '404'
      });
    });
  });
};
