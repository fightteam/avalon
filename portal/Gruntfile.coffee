###
  grunt构建
  update at 2013-03-04
  Copyright 2013-2014 Fight Team.
  Licensed under Apache License Version 2.0
###
"use strict"
request = require('request')
LIVERELOAD_PORT = 35729
mountFolder = (connect, dir)->
    connect.static require('path').resolve(dir)


module.exports = (grunt)->
	require("time-grunt")(grunt)
	require("load-grunt-tasks")(grunt)

	files
	appConfig = {
	    assets: 'assets'
	    dist: 'dist'
	    app: 'app'
	}

	grunt.initConfig({
		config: appConfig


		watch:
			options: 
        		nospawn: true
        		livereload: LIVERELOAD_PORT
			js:
				files:[
					'<%= config.app %>/app.js'
					'<%= config.app %>/config/**/*.js'
					'<%= config.app %>/controllers/**/*.js'
					'<%= config.app %>/models/**/*.js'
				]
				tasks: ['develop','delayed-livereload']
			coffee:
				files:[
					'<%= config.assets %>/**/*.coffee'
					'!<%= config.assets %>/bower_components/**'
				]
				tasks: ['coffee:dist','develop','delayed-livereload']

			jade:
				files:[
					'<%= config.assets %>/views/**/*.jade'
					'<%= config.app %>/views/**/*.jade'
				]
				options:
					livereload: LIVERELOAD_PORT
			copy:
				files:[
					'<%= config.assets %>/views/**/*.jade'
				]
				tasks: ['copy:dist']

		clean:
			dev:{}



		# 采用ruby支持的 sass编译插件
		compass:
			options: 
		            sassDir: '<%= config.assets %>/styles'
		            cssDir: '.tmp/styles'
		            generatedImagesDir: '.tmp/images/generated'
		            imagesDir: '<%= config.assets %>/images'
		            javascriptsDir: '<%= config.assets %>/scripts'
		            fontsDir: '<%= config.assets %>/styles/fonts'
		            importPath: '<%= config.assets %>/bower_components'
		            httpImagesPath: '/images'
		            httpGeneratedImagesPath: '/images/generated'
		            httpFontsPath: '/styles/fonts'
		            relativeAssets: false

		        dist: {}
		        dev: 
		            options: 
		                debugInfo: true
		            
		# 编译coffeescript
		coffee: 
			options:
				bare: true
			dist: 
			    files: [{
			        expand: true,
			        cwd: '<%= config.assets %>'
			        src: '{,*/}*.coffee'
			        dest: '<%= config.app %>'
			        ext: '.js'
			    }]
			test: 
			    files: [{
			        expand: true,
			        cwd: 'test/spec',
			        src: '{,*/}*.coffee',
			        dest: '.tmp/spec',
			        ext: '.js'
			    }]
		# javascript 验证
		jshint: 
		        options: 
		            jshintrc: '.jshintrc',
		            reporter: require('jshint-stylish')
		        all: [
		            '<%= config.assets %>/scripts/{,*/}*.js'
		            '!<%= config.assets %>/scripts/vendor/*'
		            'test/spec/{,*/}*.js'
		        ]
		

		useminPrepare:
		        options: 
		            dest: '<%= config.dist %>'
		        html: '<%= config.assets %>/index.html'

		usemin: 
		        options: 
		            dirs: ['<%= config.dist %>']
		        html: ['<%= config.dist %>/{,*/}*.html']
		        css: ['<%= config.dist %>/styles/{,*/}*.css']

		develop: 
		  server: 
		    file: '<%= config.app %>/app.js'
		    # cmd: 'coffee'

		concurrent: 
		        dev: [
		            'coffee:dist'
		            'compass:dev'
		        ]
		        test: [
		            'coffee'
		            'compass'
		        ]
		        dist: [
		            'coffee'
		            'compass:dist'
		            'imagemin'
		            'svgmin'
		            'htmlmin'
		        ]

		open: 
	        server: 
	            path: 'http://localhost:<%= connect.options.port %>'
		        
        copy:
        	dist:
		        expand: true
		        cwd: '<%= config.assets %>/views/'
		        src: '**/*.jade'
		        dest: '<%= config.app %>/views/'
			    

	})

	grunt.config.requires('watch.js.files')
	files = grunt.config('watch.js.files')
	files = grunt.file.expand(files)

	grunt.registerTask 'delayed-livereload', 'Live reload after the node server has restarted.', ()->
		done = @async()
		setTimeout ()->
			request.get 'http://localhost:' + LIVERELOAD_PORT + '/changed?files=' + files.join(','), (err, res)->
				reloaded = !err and res.statusCode is 200
				if reloaded
					grunt.log.ok('Delayed live reload successful.')
				else
					grunt.log.error('Unable to make a delayed live reload.')
				done(reloaded)
		, 500

	grunt.registerTask "server",(target)->
		if target is "dist"
		  return grunt.task.run(['build', 'open', 'connect:dist:keepalive'])
		grunt.task.run([
			'clean:dev'
		    'concurrent:dev'
		    'connect:livereload'
		    'open:server'
		    'watch'
			])


	grunt.registerTask 'complie', [
		'coffee:dist'
		'copy:dist'
	]
	grunt.registerTask 'default', [
		'complie'
		'develop'
		'watch'
	]
