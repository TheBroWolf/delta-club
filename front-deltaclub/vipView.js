$(document).ready(function () {

    function reserveRoom(){

    }

    function showRooms(){
        $.ajax({
            url: 'http://localhost:8080/reserveRoom',
            type:'GET',
            data: JSON.stringify({
                roomId:  $('#id').val(),
                }),
            async: true,
            contentType:'application/json',
            success: successCallback,
            error: errorCallback
        });
    }

    $("#goBack").click(function(e){
        e.preventDefault();
        window.history.back();
    });





    
});