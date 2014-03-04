exports.index = function(req, res) {
  return res.render('user/index', require('../models/user'));
};
