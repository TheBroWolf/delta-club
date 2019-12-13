$(document).ready(function () {

    $("#loginbutton1").click(function(){

      var name = $('#username').val();

        $.ajax({
            url: 'http://192.168.1.108:8080/login/a',
            type:'POST',
            data: JSON.stringify({
                username:$('#username').val(),
                password:$('#password').val()
                }),
            async: true,
            contentType:'application/json',
            success: successCallback(name),
            error: errorCallback
        });

        function successCallback(element){
            getuser(element);
        };

        function errorCallback(){
            alert("Invalid credentials!")
        };
      });
});


function getuser(element){
    $.ajax({
        url: 'http://192.168.1.108:8080/user/this/'+ element,
        type:"GET",
        async: true,
        success: successCallback,
        error: errorCallback
    });

    function successCallback(response){
        console.log(response);
        $('#nameofuser').append(response.username);
        $('#balance').append(response.balance);
        getMainView();
    }

    function errorCallback(){
        alert("something went wrong");
    }
}

function logout(){
    $("#mainCard").hide(400);
    $("#loginCard").show(400);
}
function loginshow(){
    $("#registerform").hide(400);
    $("#loginform").show(400);
}

function register(){
  $("#loginform").hide(400);
  $("#registerform").show(400);
}

function submitregist(){

  console.log(JSON.stringify({
    username:$('#registusername').val(),
    password:$('#registpassword').val()
    }));

    $.ajax({
      url: 'http://192.168.1.108:8080/login',   
      type:'POST',
      data: JSON.stringify({
          username:$('#registusername').val(),
          password:$('#registpassword').val()
          }),
      async: true,
      contentType:'application/json',
      success: successCallback,
      error: errorCallback
  });

  function successCallback(){
      loginshow();
  }

  function errorCallback(){
      alert("error");
  }
}

function getMainView(){
    $("#loginCard").hide(400);
  $("#mainCard").show(400);
}