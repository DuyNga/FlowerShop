
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

    // $("#btnRegister").click(register);
    //
    // function register() {
    //     let user = {};
    //     user.userName = $("#username").val();
    //     user.passWord = $("#password").val();
    //     user.email = $("#email").val();
    //     user.fullName = $("#fullname").val();
    //     user.phone = $("#phone").val();
    //     user.address = $("#address").val();
    //
    //     $.ajax({
    //         "url": "register",
    //         "type": "POST",
    //         "data": {"userNew": JSON.stringify(user)},
    //         "success": function () {
    //             toastr["success"](user.username + " is created!");
    //             $(location).attr("href", "/profile");
    //         }
    //     });

    // $.post("register", {userNew: JSON.stringify(user)})
    //     .success(function () {
    //         toastr["success"](user.username + " is created!");
    //         $(location).attr("href", "/profile");
    //     })
    //     .fail(function () {
    //         toastr["error"]("Error create user " + user.username + ".");
    //         $(location).attr("href", "/WEB-INF/jsp/register.jsp");
    //     })
    //}
})