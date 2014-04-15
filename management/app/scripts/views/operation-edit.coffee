define [
  'jquery'
  'underscore'
  'backbone'
  'templates'
  'helpers/formHelper'
  'messenger'
  'messengerTheme'
], ($, _, Backbone, JST, FormHelper, Messenger) ->
  class OperationEditView extends Backbone.View
    template: JST['app/scripts/templates/operation-edit.ejs']

    tagName: 'div'

    id: ''

    className: ''

    events: 
      'click #submit': 'submit'

    initialize: () ->
      @listenTo @model, 'change', @render

    render: () ->
      @$el.html @template @model.toJSON()

    submit: (e)->

      e.preventDefault()

      @model.set FormHelper.toJson @$('form')
     
     
      @model.save null, 
        success: (data)->
          Messenger().post
            message: "提交成功"
            showCloseButton: true
            hideAfter: 3
        error: (data)->
          Messenger().post
          message: "提交失败"
          type: 'error'
          showCloseButton: true
          hideAfter: 3
      .always (res)->
        if res && res.status == 201
          Messenger().post
            message: "提交成功"
            showCloseButton: true
            hideAfter: 3
        else if res
          Messenger().post
            message: "提交失败"
            type: 'error'
            showCloseButton: true
            hideAfter: 3
      # # 保存之后删除 注 传输需要时间
      # @$('#operationAdd').modal('hide')

 

