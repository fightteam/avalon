###
  grunt构建配置
  @date: 2014-03-03
###
"use strict"

module.exports = (grunt)->
  require("time-grunt")(grunt)
  require("load-grunt-tasks")(grunt)


  grunt.initConfig({
    clean:{}
  })

  grunt.registerTask "server",(target)->
    if target is "dist"
      return grunt.tasks.run([])
    grunt.tasks.run([])

