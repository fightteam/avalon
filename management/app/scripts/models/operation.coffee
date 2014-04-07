define [
  'underscore'
  'backbone'
  'common'
], (_, Backbone, config) ->
  'use strict';

  class OperationModel extends Backbone.Model
    url: ()->
      config.rest.operations + if @has("id") then "/" + @get("id") else ""

    idAttribute: 'id'

    initialize: (data) ->
      # 没有id 重新获取
      if data and data._links
        self = data._links.self.href
        @set 'id': self.substring self.lastIndexOf('/') + 1
        @cid = @get 'id'

      
    defaults: {}

    validate: (attrs, options) ->

    parse: (response, options) ->
      self = response._links.self.href
      @set 'id': self.substring self.lastIndexOf('/') + 1
      @cid = @get 'id'
      response


