
$(function(){
    $('.addToCart').click(function(){
        console.log($(this).attr('href'));
        $.post($(this).attr('href')).done(function(data){
            console.log(data);
            $("#num-of-items").text(data);
            toastr["success"]("Your flower is added! Please check the cart for details.");
        });
        return false;
    })
})