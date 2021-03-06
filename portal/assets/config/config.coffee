###
    程序全局环境
###
path = require('path')
rootPath = path.normalize(__dirname + '/..')
env = process.env.NODE_ENV || 'development'

config = 
  development: 
    root: rootPath
    livereload:true
    app: 
      name: 'n'
    rest:
      register: "http://localhost:8080/avalon-service/register"
      login: "http://localhost:8080/avalon-service/login"
      findByUsername: "http://localhost:8080/avalon-service/users/search/findByUsername"
    port: 3000
    db: 'mongodb://localhost/n-development'

  test: 
    root: rootPath
    app: 
      name: 'n'
    port: 3000
    db: 'mongodb://localhost/n-test'

  production: 
    root: rootPath,
    app: 
      name: 'n'
    port: 3000
    db: 'mongodb://localhost/n-production'

module.exports = config[env]
