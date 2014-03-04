exports.index = function(req, res) {
  return res.render('home/index', {
    title: 'Express1'
  });
};
