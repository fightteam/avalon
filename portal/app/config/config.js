/*
    程序全局环境
*/

var config, env, path, rootPath;

path = require('path');

rootPath = path.normalize(__dirname + '/..');

env = process.env.NODE_ENV || 'development';

config = {
  development: {
    root: rootPath,
    app: {
      name: 'n'
    },
    port: 3000,
    db: 'mongodb://localhost/n-development'
  },
  test: {
    root: rootPath,
    app: {
      name: 'n'
    },
    port: 3000,
    db: 'mongodb://localhost/n-test'
  },
  production: {
    root: rootPath,
    app: {
      name: 'n'
    },
    port: 3000,
    db: 'mongodb://localhost/n-production'
  }
};

module.exports = config[env];
