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
require(['app', 'jquery', 'bootstrap','hello'], function (app, $) {
    'use strict';
    // use app here
    console.log(app);
     // Tabs
    $('.demoTabs a').click(function (e) {
        e.preventDefault();
        $(this).tab('show');
    })
    console.log('Running jQuery %s', $().jquery);
});