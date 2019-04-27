$(function () {
  var userId = window.sessionStorage.getItem("userId");
  var userName = window.sessionStorage.getItem("userName");

  if(userName){
    $(".topName").html(userName);
    $(".loginRegister").hide();
  }

  //获取圈子
  var alltopicData = new FormData();
  alltopicData.append("page", 1);
  alltopicData.append("limit", 10);
  $.ajax({
    type: "post",
    url: "../../topic/getalltopic",
    // contentType: "application/json;charset=utf-8",
    contentType: false,//这里
    processData: false,//这两个一定设置为false
    dataType: "json",
    data: alltopicData,
    success: function (data) {
      if(data && data.resultCode == 200){
        data.topicList.forEach(function (item, index) {
          $(".topicUl").append('<li><a href="page/front/newsList.html?id=' + item.id + '">' + item.id + '-' + item.topicName + '</a></li>');
        });
      }
    }
  });

  //获取圈子里所有新闻
  var getPostByTopicIdData = new FormData();
  getPostByTopicIdData.append("topicId", 1);
  $.ajax({
    type: "post",
    url: "../../post/getPostByTopicId",
    // contentType: "application/json;charset=utf-8",
    contentType: false,//这里
    processData: false,//这两个一定设置为false
    dataType: "json",
    data: getPostByTopicIdData,
    success: function (data) {
      if(data && data.resultCode == 200){

      }
    }
  });

  //删除新闻（管理员）
  // var deletePostByIdData = new FormData();
  // deletePostByIdData.append("postId", 1);
  // $.ajax({
  //   type: "post",
  //   url: "../../post/deletePostById",
  //   // contentType: "application/json;charset=utf-8",
  //   contentType: false,//这里
  //   processData: false,//这两个一定设置为false
  //   dataType: "json",
  //   data: deletePostByIdData,
  //   success: function (data) {
  //     if(data && data.resultCode == 200){
  //
  //     }
  //   }
  // });

  //更新新闻（管理员）
  // var updatePostData = new FormData();
  // updatePostData.append("id", 2);
  // updatePostData.append("postName", "test");
  // updatePostData.append("content", 22222);
  // updatePostData.append("topicId", 1);
  // $.ajax({
  //   type: "post",
  //   url: "../../post/updatePost",
  //   // contentType: "application/json;charset=utf-8",
  //   contentType: false,//这里
  //   processData: false,//这两个一定设置为false
  //   dataType: "json",
  //   data: updatePostData,
  //   success: function (data) {
  //     if(data && data.resultCode == 200){
  //
  //     }
  //   }
  // });

  //反馈
  // var adviceData = new FormData();
  // adviceData.append("content", 44444);
  // adviceData.append("contactWay", '13199998888');
  // $.ajax({
  //   type: "post",
  //   url: "../../advice/issueAdvice",
  //   // contentType: "application/json;charset=utf-8",
  //   contentType: false,//这里
  //   processData: false,//这两个一定设置为false
  //   dataType: "json",
  //   data: adviceData,
  //   success: function (data) {
  //     if(data && data.resultCode == 200){
  //
  //     }
  //   }
  // });

  //获取反馈
  // var getAllAdviceData = new FormData();
  // getAllAdviceData.append("page", 1);
  // getAllAdviceData.append("limit", 10);
  // $.ajax({
  //   type: "post",
  //   url: "../../advice/getAllAdvice",
  //   // contentType: "application/json;charset=utf-8",
  //   contentType: false,//这里
  //   processData: false,//这两个一定设置为false
  //   dataType: "json",
  //   data: getAllAdviceData,
  //   success: function (data) {
  //     if(data && data.resultCode == 200){
  //
  //     }
  //   }
  // });

  //处理反馈
  // var dealData = new FormData();
  // dealData.append("id", 8);
  // $.ajax({
  //   type: "post",
  //   url: "../../advice/deal",
  //   // contentType: "application/json;charset=utf-8",
  //   contentType: false,//这里
  //   processData: false,//这两个一定设置为false
  //   dataType: "json",
  //   data: dealData,
  //   success: function (data) {
  //     if(data && data.resultCode == 200){
  //
  //     }
  //   }
  // });

});