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
			compass:
				files:[
					'<%= config.assets %>/public/styleshees/{,*/}*.{scss,sass}'
				]
				tasks:[
					'compass:dev'
					'autoprefixer'
					'cssmin'
				]
			less:
				files:[
					'<%= config.assets %>/public/styleshees/{,*/}*.less'
				]
				tasks:['less']
		clean:
			app:['<%= config.app %>']
			dist:['<%= concat.bootstrap.dest %>']
				
		modernizr:{}
		# 无损图片压缩
		imagemin:
			dist:
				options:
					optimizationLevel: 3
				files: [
					{
						expand: true
						cwd: '<%= config.assets %>/public/images'
						src: ['**/*.{png,jpg,gif}']
						dest: '<%= config.app %>/public/images'
					}
				]
		svgmin:{}
		cssmin:
			dist:
				files:[{
					expand: true
					cwd: '.tmp/styles/'
					src: '{,*/}*.css'
					dest: '<%= config.app %>/public/styleshees'
					ext: '.min.css'
					}]
		# css自动前缀
		autoprefixer:
			options:
				browsers:['last 1 version']
			dist:
				files:[{
					expand: true
					cwd: '.tmp/styles/'
					src: '{,*/}*.css'
					dest: '.tmp/styles/'
					}]
		# 采用ruby支持的 sass编译插件
		compass:
			options: 
		            sassDir: '<%= config.assets %>/public/styleshees'
		            cssDir: '.tmp/styles'
		            generatedImagesDir: '.tmp/images/generated'
		            imagesDir: '<%= config.assets %>/public/images'
		            javascriptsDir: '<%= config.assets %>/public/javascripts'
		            fontsDir: '<%= config.assets %>/public/fonts'
		            importPath: '<%= config.assets %>/bower_components'
		            # httpImagesPath: '/images'
		            # httpGeneratedImagesPath: '/images/generated'
		            # httpFontsPath: '/styles/fonts'
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

		# less 编译
		less:
			dist:
				options:
					cleancss: true
					report: 'min'
					paths:['<%= config.assets %>/bower_components']
				files:[{
					expand: true
					cwd: '<%= config.assets %>/public/styleshees'
					src: '*.less'
					dest: '<%= config.app %>/public/styleshees'
					ext: '.min.css'
					}]
		concat:
			bootstrap:
				src: [
					'<%= config.assets %>/bower_components/bootstrap/js/transition.js'
					'<%= config.assets %>/bower_components/bootstrap/js/alert.js'
					'<%= config.assets %>/bower_components/bootstrap/js/button.js'
					'<%= config.assets %>/bower_components/bootstrap/js/carousel.js'
					'<%= config.assets %>/bower_components/bootstrap/js/collapse.js'
					'<%= config.assets %>/bower_components/bootstrap/js/dropdown.js'
					'<%= config.assets %>/bower_components/bootstrap/js/modal.js'
					'<%= config.assets %>/bower_components/bootstrap/js/tooltip.js'
					'<%= config.assets %>/bower_components/bootstrap/js/popover.js'
					'<%= config.assets %>/bower_components/bootstrap/js/scrollspy.js'
					'<%= config.assets %>/bower_components/bootstrap/js/tab.js'
					'<%= config.assets %>/bower_components/bootstrap/js/affix.js'
				]
				dest: '<%= config.app %>/public/javascripts/bootstrap.js'
		# js压缩
		uglify:
			bootstrap:
				src: '<%= concat.bootstrap.dest %>',
				dest: '<%= config.app %>/public/javascripts/bootstrap.min.js'
			jquery:
				src: '<%= config.assets %>/bower_components/jquery/dist/jquery.js',
				dest: '<%= config.app %>/public/javascripts/jquery.min.js'
		develop: 
		  server: 
		    file: '<%= config.app %>/app.js'
		    # cmd: 'coffee'


		open: 
	        server: 
	            path: 'http://localhost:3000'
		        
		copy:
			dist:
		        expand: true
		        cwd: '<%= config.assets %>/views/'
		        src: '**/*.jade'
		        dest: '<%= config.app %>/views/'
			json:
				expand: true
				cwd: '<%= config.assets %>/'
				src: '*.json'
				dest: '<%= config.app %>/'
			bootstrap:
				expand: true
				cwd: '<%= config.assets %>/bower_components/bootstrap/fonts'
				src: '**'
				dest: '<%= config.app %>/public/fonts'

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


	grunt.registerTask 'complie', [
		'clean:app'
		'coffee:dist'
		'less'
		'copy'
		'concat'
		'uglify'
		'clean:dist'
		'compass:dist'
		'autoprefixer'
		'cssmin'
		'imagemin'
	]
	grunt.registerTask 'default', [
		'complie'
		'develop'
		'open:server'
		'watch'
	]