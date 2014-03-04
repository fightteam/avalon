/*
	路由配置
*/

module.exports = function(app) {
  var home, user;
  home = require('../controllers/home');
  app.get('/', home.index);
  user = require('../controllers/user');
  return app.get('/user', user.index);
};
