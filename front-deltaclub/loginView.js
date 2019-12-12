
$(document).ready(function () {


});


function show(){
    $(".registerform").show();
}

function register(){
  $("#loginform").hide();
  $("#registerform").show();
}

function updateInfo(){

  var id = $('#id').val();
  console.log(id);

  $.ajax({
      url: 'http://localhost:8080/login',
      type:'POST',
      data: JSON.stringify({
          username:  $('#username').val(),
          password: $('#password').val()
          }),
      async: true,
      contentType:'application/json',
      success: window.location.reload(),
      error: errorCallback
  });
}