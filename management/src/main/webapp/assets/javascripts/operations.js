$(function(){
    $.ajax({
        url:config.operations
    }).done(function(data, textStatus, jqXHR){
        console.log(data);
    });
})