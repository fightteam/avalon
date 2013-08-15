/**
* requirejs 全局配置
*/
require.config({
    paths: {
        jquery: '../bower_components/jquery/jquery',
        bootstrap: 'vendor/bootstrap',
        css: '../bower_components/require-css/css',
        datepicker:'../bower_components/bootstrap-datepicker/js/bootstrap-datepicker',
        colorpicker:'../bower_components/bootstrap-colorpicker/js/bootstrap-colorpicker',
        fileupload:'../bower_components/bootstrap/js/bootstrap-fileupload',
        tags:'../bower_components/jquery.tagsinput/jquery.tagsinput',
        bwysihtml5:'../bower_components/bootstrap-wysihtml5/src/bootstrap-wysihtml5',
        wysihtml5:'../bower_components/bootstrap-wysihtml5/lib/js/wysihtml5-0.3.0',
        jwysiwyg:'../bower_components/jwysiwyg/jquery.wysiwyg'
    },
    shim: {
        bootstrap: {
            deps: ['jquery'],
            exports: 'jquery'
        },
        datepicker:{
            deps: ['bootstrap']
        },
        colorpicker:{
            deps: ['bootstrap']
        },
        fileupload:{
            deps: ['bootstrap']
        },
        tags:{
            deps: ['jquery'],
            exports: '$.tagsInput'
        },
        bwysihtml5:{
            deps: ['jquery','wysihtml5']
        }, 
        jwysiwyg:{
            deps: ['jquery']
        }
    }
});
/**
* 程序入口
*/
require(['app', 'jquery', 'bootstrap','datepicker','colorpicker','fileupload','tags','bwysihtml5','jwysiwyg'], function (app, $) {
    'use strict';
    // use app here
    console.log("main2-----test");
    
    console.log('Running jQuery %s', $().jquery);
});