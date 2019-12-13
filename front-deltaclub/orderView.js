$(document).ready(function () {

    $("#loginbutton1").click(function(){

        console.log(JSON.stringify({
            username:  $('#username').val(),
            password: $('#password').val()
            }));

        $.ajax({
            url: 'http://192.168.1.108:8080/login/a',
            type:'POST',
            data: JSON.stringify({
                username:$('#username').val(),
                password:$('#password').val()
                }),
            async: true,
            contentType:'application/json',
            success: successCallback,
            error: errorCallback
        });

        function successCallback(){
            getMainView();
        };

        function errorCallback(){
            alert("Invalid credentials!")
        };
      });
});

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
    username:  $('#username').val(),
    password: $('#password').val()
    }));

    $.ajax({
      url: 'http://localhost:8080/login',
      type:'POST',
      data: JSON.stringify({
          username:  $('#username').val(),
          password: $('#password').val()
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