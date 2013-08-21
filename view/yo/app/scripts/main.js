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
            deps: [
                'jquery'
            ],
            exports: 'jquery'
        },
        datepicker: {
            deps: [
                'bootstrap'
            ]
        },
        colorpicker: {
            deps: [
                'bootstrap'
            ]
        },
        fileupload: {
            deps: [
                'bootstrap'
            ]
        },
        tags: {
            deps: [
                'jquery'
            ],
            exports: '$.tagsInput'
        },
        bwysihtml5: {
            deps: [
                'jquery',
                'wysihtml5'
            ]
        },
        jwysiwyg: {
            deps: [
                'jquery'
            ]
        }
    }
});
/**
* 程序入口
*/
require(['app', 'jquery', 'bootstrap','datepicker','colorpicker','fileupload','tags','bwysihtml5','jwysiwyg'], function (app, $) {
    'use strict';
    // use app here
    console.log(app);
     // Tabs
//     $('.demoTabs a').click(function (e) {
//         e.preventDefault();
//         $(this).tab('show');
//     });
//     $(".datepicker").datepicker({
//         autoclose:true
//     });
//     var preview = $('.colorpicker-preview')[0].style;
           
//                 $('.colorpicker').colorpicker().on('changeColor', function(ev){
                  
//                     preview.backgroundColor = ev.color.toHex();
//                 });

//     $('.tagsinput').tagsInput();


//                 $('.wysiwyg').wysiwyg({
//                     controls: {
//                         bold          : { visible : true },
//                         italic        : { visible : true },
//                         underline     : { visible : true },
//                         strikeThrough : { visible : true },
                        
//                         justifyLeft   : { visible : true },
//                         justifyCenter : { visible : true },
//                         justifyRight  : { visible : true },
//                         justifyFull   : { visible : true },
            
//                         indent  : { visible : true },
//                         outdent : { visible : true },
            
//                         subscript   : { visible : true },
//                         superscript : { visible : true },
                        
//                         undo : { visible : true },
//                         redo : { visible : true },
                        
//                         insertOrderedList    : { visible : true },
//                         insertUnorderedList  : { visible : true },
//                         insertHorizontalRule : { visible : true },
                        
//                         cut   : { visible : true },
//                         copy  : { visible : true },
//                         paste : { visible : true }
//                     },
//                     events: {
//                         click: function(event) {
//                             if ($("#click-inform:checked").length > 0) {
//                                 console.log(this);
//                                 //event.preventDefault();
//                                 alert("You have clicked jWysiwyg content!");
//                             }
//                         }
//                     }
//                 });
// $('.wysihtml5').wysihtml5();
// Tooltips
                $('.user-profile a, .dashboard .badge').tooltip({
                    placement: 'top'
                });
                $('.brand, .navbar-search input').tooltip({
                    placement: 'bottom'
                });
                $('.main-navigation .badge').tooltip({
                    placement: 'right'
                });
                $('.content-block [title]').tooltip({
                    placement: 'top'
                });
    console.log('Running jQuery %s', $().jquery);
});