require.config({
    baseUrl: document.getElementsByTagName('meta')[2].content + '/assets',
    paths: {
        jquery: 'plugins/jquery/jquery-2.1.0.min',
        underscore: 'plugins/underscore/underscore-min',
        backbone: 'plugins/backbone/backbone-min',
        bootstrap: 'plugins/bootstrap/bootstrap.min',
        metisMenu: 'plugins/metis-menu/jquery.metisMenu'
    },
    shim: {
        backbone: {
            deps: ['underscore','jquery'],
            exports: "Backbone"
        },
        bootstrap: ['jquery'],
        metisMenu: ['jquery']
    }
});

require([
    'jquery',
    'backbone',
    'metisMenu',
    'bootstrap'
],function($, Backbone){
    $('#side-menu').metisMenu();
    // 适应手机
    $(window).bind("load resize", function() {
        if ($(this).width() < 768) {
            $('div.sidebar-collapse').addClass('collapse')
        } else {
            $('div.sidebar-collapse').removeClass('collapse')
        }
    });

});