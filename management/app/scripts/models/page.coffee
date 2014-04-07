define [
  'underscore'
  'backbone'
], (_, Backbone) ->
  'use strict';

  class PageModel extends Backbone.Model

    initialize: () ->

    defaults: {
      title: '11'
      view: null
    }

    validate: (attrs, options) ->

