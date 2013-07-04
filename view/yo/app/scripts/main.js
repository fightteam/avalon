/**
* requirejs 全局配置
*/
require.config({
    paths: {
        jquery: '../bower_components/jquery/jquery',
        bootstrap: 'vendor/bootstrap'
    },
    shim: {
        bootstrap: {
            deps: ['jquery'],
            exports: 'jquery'
        }
    }
});
/**
* 程序入口
*/
require(['app', 'jquery', 'bootstrap','hello'], function (app, $,hello) {
    'use strict';
    // use app here
    console.log(app);
    console.log('Running jQuery %s', $().jquery);
});