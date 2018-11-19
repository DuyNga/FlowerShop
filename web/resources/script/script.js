
$(function(){
    $('.addToCart').click(function(){
        console.log($(this).attr('href'));
        let searchParams = new URLSearchParams($(this).attr('href'));
        let id = "#item_" + getUrlVars($(this).attr('href'))['flowerId'];
        $.post($(this).attr('href')).done(function(data){
            console.log(data);
            $("#num-of-items").text(data);
            toastr["success"](`${$(id).text()} is added successfully! Please check the cart for details.`);
        });
        return false;
    });

    function getUrlVars(url) {
        var vars = {};
        var parts = url.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
            vars[key] = value;
        });
        return vars;
    }
})