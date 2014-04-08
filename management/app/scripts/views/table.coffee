###*
 * 正对table的渲染
###
define [
  'jquery'
  'underscore'
  'backbone'
  'templates'
], ($, _, Backbone, JST) ->

  class TableView extends Backbone.View
    template: JST['app/scripts/templates/table.ejs']

    rowTemplate: JST['app/scripts/templates/table-row.ejs']

    paginationTemplate: JST['app/scripts/templates/pagination.ejs']

    # el: ""
    tagName: 'div'

    # id: ''

    className: 'table-responsive'

    # 显示行
    columns:[]

    events: {}

    pagination: {}

    initialize: (options)->
      if options.columns
        @columns = options.columns
      if options.pagination
        @pagination = options.pagination
      if options
        @options = options
      
      
      @listenTo @pagination, 'sync', @renderPagination
      @listenTo @pagination, 'add', @insertRow
      @listenTo @pagination, 'remove', @removeRow

    render: ()->
      # 渲染默认的tabel骨架
      @$el.html @template 
        columns: @columns

    # 渲染分页
    renderPagination: (tables)->
      @$el.append @paginationTemplate tables.page

    insertRow: (model)->
      # 调用代理
      if @options and @options.insertRow
        @options.insertRow.apply @, arguments
      tr = @rowTemplate 
        model: model.toJSON()
        columns: @columns
      @$('tbody').append tr
      
     
    removeRow: ()->

    updateRow: ()->

