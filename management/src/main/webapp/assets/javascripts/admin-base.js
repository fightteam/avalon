var config ={
    operations:"http://localhost:8080/avalon-service/operations"
}


$(function() {

    $('#side-menu').metisMenu();
    // 适应手机
    $(window).bind("load resize", function() {
        if ($(this).width() < 768) {
            $('div.sidebar-collapse').addClass('collapse')
        } else {
            $('div.sidebar-collapse').removeClass('collapse')
        }
    })
});
