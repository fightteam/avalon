#/*global require*/
'use strict'

require.config
  shim:
    underscore:
      exports: '_'
    backbone:
      deps: [
        'underscore'
        'jquery'
      ]
      exports: 'Backbone'
    bootstrap:
      deps: ['jquery']
      exports: 'jquery'
  paths:
    jquery: '../bower_components/jquery/dist/jquery'
    backbone: '../bower_components/backbone/backbone'
    underscore: '../bower_components/underscore/underscore'
    bootstrap: '../bower_components/bootstrap/dist/js/bootstrap'
    moment: '../bower_components/momentjs/min/moment-with-langs'
    base64: '../bower_components/js-base64/base64.min'
require [
  'backbone'
  'routes/router'
  'common'
], (Backbone, Workspace, config) ->

  workspace = new Workspace()
  config.app.workspace = workspace
  Backbone.history.start()

  if config.app.token
    workspace.navigate '', true
  else
    workspace.navigate 'login', true
  

  

