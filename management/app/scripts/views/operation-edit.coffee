define [
  'jquery'
  'underscore'
  'backbone'
  'templates'
  'helpers/formHelper'
  'models/operation'
  'collections/operation'
], ($, _, Backbone, JST, FormHelper, OperationModel, operations) ->
  class OperationEditView extends Backbone.View
    template: JST['app/scripts/templates/operation-edit.ejs']

    tagName: 'div'

    id: ''

    className: ''

    events: 
      'click #operationSubmit': 'operationSubmit'

    initialize: () ->
        @listenTo @model, 'change', @render

    render: () ->
        @$el.html @template(@model.toJSON())

    operationSubmit: (e)->
      e.preventDefault()
      model = new OperationModel FormHelper.toJson @$('form')
      model.save()

      # 保存之后删除 注 传输需要时间
      @$('#operationAdd').modal('hide')

      view = @     
      setTimeout ()->
        operations.fetchNew()
        view.remove()
      ,500
      
          
            

      
      
     

    show: ()->
      @$('#operationAdd').modal {}
