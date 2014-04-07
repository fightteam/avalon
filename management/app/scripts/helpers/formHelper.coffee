define [
  'jquery'
], ($) ->
	'use strict'

	FormHelper =
		toJson: (form)->
			obj = {}
			arr = $(form).serializeArray()
			for o in arr
				obj[o.name] = o.value

			obj
	
