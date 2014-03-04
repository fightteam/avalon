exports.index = (req, res)->
	res.render 'user/index', 
		require '../models/user'