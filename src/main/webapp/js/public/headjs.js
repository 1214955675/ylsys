var userId = window.sessionStorage.getItem("userId");
var userName = window.sessionStorage.getItem("userName");

var headData = '<div class="navbar navbar-fixed-top" style="_position: relative;_z-index: 10000;">' +
    '<div class="navbar-inner">' +
    '<div class="container">' +
    '<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">' +
    '<span class="icon-bar"></span>' +
    '<span class="icon-bar"></span>' +
    '<span class="icon-bar"></span>' +
    '</a>' +
    '<div class="nav-collapse">' +
    '<ul class="nav" id="navID">' +
    '<li class=""><a href="../../index.html"><b>首页</b></a></li>' +
    // '<li name="cxzx_list" class=""><a href="cxzx_list.html"><b>医疗资讯</b></a></li>' +
    // '<li name="cxfw_list" class=""><a href="cxfw_list.html"><b>热门文章</b></a></li>' +
    '<li name="xmdata" class=""><a href="xmdata.html"><b>内容查找</b></a></li>' +
    '<li name="tzjg_list" class=""><a href="tzjg_list.html"><b>常见问题</b></a></li>' +
    // '<li name="xm_write" class=""><a href="xm_write.html"><b>xm_write</b></a></li>' +
    '</ul>' +
    '</div>' +
'<ul class="nav pull-right login-none nav-tips">' +
    '<li class="ie6png divider-vertical" style="_width: 30px;_height: 40px;_background: url(../../images/icons.png) no-repeat 10px -106px;"><a class="dropdown-toggle clearfix" href="####" style="padding: 7px 5px;"><img class="logo-before pull-left" src="../../images/avatar-icon.png" /></a></li>' +
    '</ul>' +
    '<div class="popup-div tips-div" style="position: absolute;z-index: 10000001;display: none;"></div>' +
    '<ul class="nav pull-right pl-20 myul">' +
    '<li class="loginRegister"><a href="register.html">注册</a></li>' +
    '<li class="loginRegister l10"><a href="login.html">登录</a></li>' +
    '<li><a href="####" class="topName"></a></li>' +
    '<li style="display: none;" class="logoutBtn"><a href="####">退出</a></li>' +
    '<li style="display: none;" class="logoutBtn"><a id="msgID" target="_blank" href="####">聊天测试</a></li>' +
    '<li><a href="feedback.html">问题反馈</a></li>' +
    '</ul>' +
    '</div>' +
    '</div>' +
    '</div>';

var headRender = template.compile(headData);
var headHtml = headRender({});
$("#headBox").html(headHtml);

if(userName){
    $(".topName").html(userName);
    $(".loginRegister").hide();
    $(".logoutBtn").show();
}

$("#msgID").click(function () {
  window.open('msg.html?id='+userId+'&name='+userName)
  return false
})

// 退出
$(".logoutBtn").click(function () {
  window.sessionStorage.removeItem("userId");
  window.sessionStorage.removeItem("userName");
  window.location.href = '../../index.html'
});
var pageName = window.location.pathname;
pageName = pageName.split('/')[pageName.split('/').length - 1];
pageName = pageName.split('.')[0];
$("li[name=" + pageName + "]").addClass('active');