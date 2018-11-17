$(function(){
    $('#search').click(loadContaint);

    function loadContaint() {
        let item = {fromValue: $('#fromvalue').val(), toValue: $('#tovalue').val()};

        $.post("search", {
            searchItem: JSON.stringify(item)
        }).done(function () { $(location).attr("href", "/flower-list"); })
            .fail(function () { alert("error occured!!!"); });
    }
});