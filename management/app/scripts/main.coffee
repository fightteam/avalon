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
    metisMenu:
      deps: ['jquery']
      exports: 'jquery'
    messenger:
      deps: ['jquery']
      exports: 'Messenger'
    messengerTheme:
      deps: ['messenger']
      exports: 'jquery'
  paths:
    jquery: '../bower_components/jquery/dist/jquery'
    backbone: '../bower_components/backbone/backbone'
    underscore: '../bower_components/underscore/underscore'
    bootstrap: '../bower_components/bootstrap/dist/js/bootstrap'
    moment: '../bower_components/momentjs/min/moment-with-langs'
    base64: '../bower_components/js-base64/base64.min'
    metisMenu: '../bower_components/metisMenu/jquery.metisMenu'
    messenger: '../bower_components/messenger/build/js/messenger'
    messengerTheme: '../bower_components/messenger/build/js/messenger-theme-flat'

require [
  'backbone'
  'routes/router'
  'common'
  'messenger'
  'messengerTheme'
], (Backbone, Workspace, config, Messenger) ->

  workspace = new Workspace()
  config.app.workspace = workspace
  Backbone.history.start()


  Messenger.options = {
    extraClasses: 'messenger-fixed messenger-on-top messenger-on-right'
    theme: 'flat'
  }



  

  

