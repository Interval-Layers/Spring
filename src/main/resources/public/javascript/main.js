$(document).ready(function(){
    $('.card').css("display","none");

    $('.name_link').click(function(){
        $('.input_name').val($(this).attr("data-name"));
    })
})
