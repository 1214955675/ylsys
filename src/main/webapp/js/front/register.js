$(function () {
  $('input').keydown(function(event){
    if(event.keyCode == 13){
      $("#register").click();
    }
  });

  //注册
  $("#register").click(function () {
    var formData = new FormData();
    formData.append("userName", $("input[name=rname]").val());
    formData.append("passWord", $("input[name=pwd]").val());
    formData.append("nickName", $("input[name=nickname]").val());
    formData.append("file", document.getElementById("headImg").files[0]);
    $.ajax({
      type: "post",
      url: "../../user/register",
      contentType: false,//这里
      processData: false,//这两个一定设置为false
      dataType: "json",
      data: formData,
      success: function (data) {
        if(data && data.resultCode == 200){
          window.location.href = "login.html";
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