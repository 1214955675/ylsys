$(function () {
  $('input').keydown(function(event){
    if(event.keyCode == 13){
      $("#login").click();
    }
  });

  //登录
  $("#login").click(function () {
    var formData = new FormData();
    formData.append("userName", $("#username").val());
    formData.append("passWord", $("#password").val());
    $.ajax({
      type: "post",
      url: "../../user/login",
      // contentType: "application/json;charset=utf-8",
      contentType: false,//这里
      processData: false,//这两个一定设置为false
      dataType: "json",
      data: formData,
      success: function (data) {
        if(data && data.resultCode == 200){
          document.cookie = "userId=" + data.object;
          document.cookie = "userName=" + $("#username").val();
          // window.location.href = "../../index.html";
        } else {
          layer.msg(data.resultMessage, {time: 2000, icon: 2});
        }
      },
      error: function (err) {
        layer.msg("异常", {time: 2000, icon: 2});
      }
    })
  });

});