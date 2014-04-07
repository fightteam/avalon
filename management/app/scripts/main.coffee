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
require [
  'backbone'
  'routes/router'
], (Backbone, Workspace) ->

  new Workspace()

  Backbone.history.start()

