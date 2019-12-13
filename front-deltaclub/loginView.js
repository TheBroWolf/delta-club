
$(document).ready(function () {

    $("#loginbutton1").click(function(){

        $.ajax({
            url: 'http://localhost:8080/login/a',
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
            getMainView();
        };

        function errorCallback(){
            alert("Invalid credentials!")
        };

      });
});


function loginshow(){
    $("#registerform").hide(200);
    $(".form2").show(200);
}

function register(){
  $(".form2").hide(200);
  $("#registerform").show(200);
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
    $("#loginView").hide();
  $("#mainView").show();
}

