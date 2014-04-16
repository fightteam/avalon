###
    express框架配置
###
express = require('express')

module.exports = (app, config)->
    app.configure ()->
        app.use express.compress()
        app.use express.static(config.root + '/public')
        app.set 'port', config.port
        app.set 'views', config.root + '/views'
        app.set 'view engine', 'jade'
        app.use express.favicon(config.root + '/public/img/favicon.ico')
        app.use express.logger('dev')
        app.use express.bodyParser()
        app.use express.methodOverride()
        app.use express.cookieParser()
        app.use express.session 
            secret: 'avlaon-portal'
            store: new express.session.MemoryStore()
        app.use (req, res, next)->
            if req.path in ["/", "/login", "/register"]
                next()
            else
                if not req.cookies.access_token
                    res.redirect '/login'
                next()
        app.use app.router
        app.use (req, res)->
            
            res.status(404).render '404',
                title: '404'