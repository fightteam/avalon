/**
* requirejs 全局配置
*/
require.config({
    // use baseUrl to update bower paths ,but use remove it(bower bug)
    //baseUrl: 'app/script',
    paths: {
        bootstrap: '..\\bower_components\\bootstrap\\docs\\assets\\js\\bootstrap',
        'bootstrap-datepicker': '..\\bower_components\\bootstrap-datepicker\\js\\bootstrap-datepicker',
        'bootstrap-wysihtml5': '..\\bower_components\\bootstrap-wysihtml5\\src\\bootstrap-wysihtml5',
        'google-code-prettify': '..\\bower_components\\google-code-prettify\\src\\prettify',
        jquery: '..\\bower_components\\jquery\\jquery',
        'jquery.tagsinput': '..\\bower_components\\jquery.tagsinput\\jquery.tagsinput',
        jwysiwyg: '..\\bower_components\\jwysiwyg\\jquery.wysiwyg',
        'pines-notify': '..\\bower_components\\pines-notify\\jquery.pnotify',
        tinymce: '..\\bower_components\\tinymce\\Jakefile',
        'bootstrap-colorpicker': '..\\bower_components\\bootstrap-colorpicker\\js\\bootstrap-colorpicker',
        colorpicker: '..\\bower_components\\bootstrap-colorpicker\\css\\colorpicker'
    },
    shim: {
        bootstrap: {
            deps: [
                'jquery'
            ],
            exports: 'jquery'
        },
        'bootstrap-datepicker': {
            deps: [
                'bootstrap'
            ]
        },
        colorpicker: {
            deps: [
                'bootstrap'
            ]
        },
        'jquery.tagsinput': {
            deps: [
                'jquery'
            ],
            exports: '$.tagsInput'
        },
        'bootstrap-wysihtml5': {
            deps: [
                'jquery'
            ]
        },
        jwysiwyg: {
            deps: [
                'jquery'
            ]
        }
    }
});
