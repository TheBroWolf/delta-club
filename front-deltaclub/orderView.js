$(document).ready(function () {

    $("#loginbutton1").click(function () {

        var name = $('#username').val();

        $.ajax({
            url: 'http://192.168.1.108:8080/login/a',
            type: 'POST',
            data: JSON.stringify({
                username: $('#username').val(),
                password: $('#password').val()
            }),
            async: true,
            contentType: 'application/json',
            success: successCallback(name),
            error: errorCallback
        });

        function successCallback(element) {
            getuser(element);
        };

        function errorCallback() {
            alert("Invalid credentials!")
            register();
        };
    });


});

function backMain(){
    $("#QRCard").hide(400);
    $("#mainCard").show(400);
}
function purchaseDrink(){
    $("#OrdersCard").hide(400);
    $("#QRCard").show(400);
}
function buy(){
    notshowParties(400);
    alert("Purchase Successfull!")
}

function showOrders(){
    $("#mainCard").hide(400);
    $("#OrdersCard").show(400);
}

function backmain(){
    $("#OrdersCard").hide(400);
    $("#mainCard").show(400);
}

function showMVP(){
    $("#mainCard").hide(400);
    $("#vipcard").show(400);
}

function getuser(element) {
    $.ajax({
        url: 'http://192.168.1.108:8080/user/this/' + element,
        type: "GET",
        async: true,
        success: successCallback,
        error: errorCallback
    });

    function successCallback(response) {
        console.log(response);
        $('#nameofuser').text(response.username);
        $('#balance').text(response.balance);
        getMainView();
    }

    function errorCallback() {
        alert("something went wrong");
    }
}

function showParties() {
    $("#mainCard").hide(400);
    $("#partiesCard").show(400);
}

function notshowParties() {
    $("#partiesCard").hide(400);
    $("#mainCard").show(400);
}

function showmyparties() {

        $.ajax({
            url: 'http://192.168.1.108:8080/parties',
            type: 'GET',
            async: true,
            success: successCallback,
            error: errorCallback
        });

        function errorCallback() {
            alert("error!")
        };

    function successCallback(obj) {
        for (var i = 0; i < obj.length; i++) {
            row2 =
                '<td>' + obj[i].description + '</td>' +
                '<td>' + obj[i].entryPrice + '</td>';

            $(row2).appendTo('#users-table');
        }
    };
}


function logout() {
    $("#mainCard").hide(400);
    $("#loginCard").show(400);
}
function loginshow() {
    $("#registerform").hide(400);
    $("#loginform").show(400);
}

function register() {
    $("#loginform").hide(400);
    $("#registerform").show(400);
}

function submitregist() {

    console.log(JSON.stringify({
        username: $('#registusername').val(),
        password: $('#registpassword').val()
    }));

    $.ajax({
        url: 'http://192.168.1.108:8080/login',
        type: 'POST',
        data: JSON.stringify({
            username: $('#registusername').val(),
            password: $('#registpassword').val()
        }),
        async: true,
        contentType: 'application/json',
        success: successCallback,
        error: errorCallback
    });

    function successCallback() {
        loginshow();
    }

    function errorCallback() {
        alert("error");
    }
}

function getMainView() {
    $("#loginCard").hide(400);
    $("#mainCard").show(400);
}