
$(function () {
  var userId = window.sessionStorage.getItem("userId");
  var userName = window.sessionStorage.getItem("userName");
  // $("#msgID").attr("href", 'page/front/msg.html?id='+userId+'&name='+userName)
  $("#msgID").click(function () {
    window.open('page/front/msg.html?id='+userId+'&name='+userName)
    return false
  })
  if(userName){
    $(".topName").html(userName);
    $(".loginRegister").hide();
    $(".logoutBtn").show();
  }

  // 退出
  $(".logoutBtn").click(function () {
    window.sessionStorage.removeItem("userId");
    window.sessionStorage.removeItem("userName");
    window.location.href = 'index.html'
  });

  //获取圈子
  // var alltopicData = new FormData();
  // alltopicData.append("page", 1);
  // alltopicData.append("limit", 10);
  // if (userId) {
  //   alltopicData.append("userId", userId);
  // }
  // $.ajax({
  //   type: "post",
  //   url: "../../topic/getalltopic",
  //   // contentType: "application/json;charset=utf-8",
  //   contentType: false,//这里
  //   processData: false,//这两个一定设置为false
  //   dataType: "json",
  //   data: alltopicData,
  //   success: function (data) {
  //     if(data && data.resultCode == 200){
  //       data.topicList.forEach(function (item, index) {
  //         $(".topicUl").append('<li><a href="page/front/newsList.html?id=' + item.id + '">' + item.id + '-' + item.topicName + '</a></li>');
  //       });
  //
  //       //获取圈子里所有新闻1
  //       if(data.topicList[0] && data.topicList[0].id){
  //         var getPostByTopicIdData1 = new FormData();
  //         getPostByTopicIdData1.append("topicId", data.topicList[0].id);
  //         $.ajax({
  //           type: "post",
  //           url: "../../post/getPostByTopicId",
  //           // contentType: "application/json;charset=utf-8",
  //           contentType: false,//这里
  //           processData: false,//这两个一定设置为false
  //           dataType: "json",
  //           data: getPostByTopicIdData1,
  //           success: function (data) {
  //             if(data && data.resultCode == 200){
  //               data.postlist.forEach(function (item, index) {
  //                 $(".list1").append('<div class="news-list b-30 clearfix">' +
  //                     '<div class="spanm3 pull-left" style="padding-top:7px;">' +
  //                     '<a href="javascript:;" rel="bookmark" style="display: block;" target="_blank">' +
  //                     '<img style="width: 200px;height: 120px;" src="'+item.postImg+'"/>' +
  //                     '</a>' +
  //                     '</div>' +
  //                     '<div class="offsetindex3 intro">' +
  //                     '<h1><a href="page/front/news.html?id='+item.id+'&topicid='+item.topicId+'" rel="bookmark">'+item.postName+'</a></h1>' +
  //                     // '<p class="t-5 fc666" style=" margin-bottom:0;">标题标题标标题标。</p>' +
  //                     // '<div class="myxm"><span><a href="">北京</a></span>  <span class="two"><a href="">项目分类</a></span>   2013/03/02</div>' +
  //                     '<div class="clearfix">' +
  //                     // '<a class="follow-btn pr-10 ie6png news-follow-btn" href="javascript:void(0);" title="1人关注	2人分享	3人评论" data-id="104423" data-type="news">6人</a>' +
  //                     '<a class="read-btn ie6png" href="javascript:void(0);">'+(item.clickNum || 0)+'</a>' +
  //                     '</div>' +
  //                     '</div>' +
  //                     '</div>');
  //               })
  //             }
  //           }
  //         });
  //       }
  //
  //       //获取圈子里所有新闻2
  //       if(data.topicList[1] && data.topicList[1].id){
  //         var getPostByTopicIdData2 = new FormData();
  //         getPostByTopicIdData2.append("topicId", data.topicList[1].id);
  //         $.ajax({
  //           type: "post",
  //           url: "../../post/getPostByTopicId",
  //           // contentType: "application/json;charset=utf-8",
  //           contentType: false,//这里
  //           processData: false,//这两个一定设置为false
  //           dataType: "json",
  //           data: getPostByTopicIdData2,
  //           success: function (data) {
  //             if(data && data.resultCode == 200){
  //               data.postlist.forEach(function (item, index) {
  //                 $(".list2").append('<div class="topic-list b-45">' +
  //                     '<div class="clearfix">' +
  //                     '<div class="span1 pull-left">' +
  //                     '<a href="javascript:;" rel="bookmark" target="_blank">' +
  //                     '<img style="width: 60px;height: 60px;" class="lazyloadimg" alt="标题标题" src="'+item.postImg+'"/>' +
  //                     '</a>' +
  //                     '</div>' +
  //                     '<div class="offset1 intro">' +
  //                     '<h1><a href="page/front/news.html?id='+item.id+'&topicid='+item.topicId+'" title="标题" rel="bookmark" >'+item.postName+'</a></h1>' +
  //                     '</div>' +
  //                     '</div>' +
  //                     '<div class="intro l-20">' +
  //                     // '<p class="t-15 fc666 mmbuttom">标题标题标题标题。</p>' +
  //                     '<div class="clearfix">' +
  //                     // '<a class="follow-btn pr-10 ie6png" href="javascript:void(0);" title="1人关注">1人</a>' +
  //                     '<a class="read-btn ie6png" href="javascript:void(0);">'+(item.clickNum || 0)+'</a>' +
  //                     '</div>' +
  //                     '</div>' +
  //                     '</div>');
  //               })
  //             }
  //           }
  //         });
  //       }
  //
  //       //获取圈子里所有新闻3
  //       if(data.topicList[2] && data.topicList[2].id){
  //         var getPostByTopicIdData3 = new FormData();
  //         getPostByTopicIdData3.append("topicId", data.topicList[2].id);
  //         $.ajax({
  //           type: "post",
  //           url: "../../post/getPostByTopicId",
  //           // contentType: "application/json;charset=utf-8",
  //           contentType: false,//这里
  //           processData: false,//这两个一定设置为false
  //           dataType: "json",
  //           data: getPostByTopicIdData3,
  //           success: function (data) {
  //             if(data && data.resultCode == 200){
  //               data.postlist.forEach(function (item, index) {
  //                 $(".list3").append('<li><a href="page/front/news.html?id='+item.id+'&topicid='+item.topicId+'">'+item.postName+'</a></li>');
  //               })
  //             }
  //           }
  //         });
  //       }
  //
  //     }
  //   }
  // });

  // 获取热门圈子
  var alltopicData = new FormData();
  alltopicData.append("page", 1);
  alltopicData.append("limit", 20);
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

          $(".list1").append('<div class="news-list b-30 clearfix">' +
              '<div class="spanm3 pull-left" style="padding-top:7px;">' +
              '<a href="javascript:;" rel="bookmark" style="display: block;" target="_blank">' +
              '<img style="width: 200px;height: 120px;" src="'+item.imgUrl+'"/>' +
              '</a>' +
              '</div>' +
              '<div class="offsetindex3 intro">' +
              '<h1><a href="page/front/newsList.html?id='+item.id+'" rel="bookmark">'+item.topicName+'</a></h1>' +
              // '<p class="t-5 fc666" style=" margin-bottom:0;">标题题。</p>' +
              // '<div class="myxm"><span><a href="">北京</a></span>  <span class="two"><a href="">项目分类</a></span>   2013/03/02</div>' +
              '<div class="clearfix">' +
              // '<a class="follow-btn pr-10 ie6png news-follow-btn" href="javascript:void(0);" title="1人关注	2人分享	3人评论" data-id="104423" data-type="news">6人</a>' +
              '<a class="read-btn ie6png" href="javascript:void(0);">'+(item.clickNum || 0)+'</a>' +
              '</div>' +
              '</div>' +
              '</div>');
        });
      }
    }
  });

  // 获取热门新闻
  var updatePostData = new FormData();
  updatePostData.append("page", '1');
  updatePostData.append("limit", '20');
  $.ajax({
    type: "post",
    url: "../../post/getHotPost",
    // contentType: "application/json;charset=utf-8",
    contentType: false,//这里
    processData: false,//这两个一定设置为false
    dataType: "json",
    data: updatePostData,
    success: function (data) {
      if(data && data.resultCode == 200){
        data.postlist.forEach(function (item, index) {

          $(".list2").append('<div class="topic-list b-45">' +
              '<div class="clearfix">' +
              '<div class="span1 pull-left">' +
              '<a href="javascript:;" rel="bookmark" target="_blank">' +
              '<img style="width: 60px;height: 60px;" class="lazyloadimg" src="'+item.postImg+'"/>' +
              '</a>' +
              '</div>' +
              '<div class="offset1 intro">' +
              '<h1><a href="page/front/news.html?id='+item.id+'&topicid='+item.topicId+'" rel="bookmark" >'+item.postName+'</a></h1>' +
              '</div>' +
              '</div>' +
              '<div class="intro l-20">' +
              // '<p class="t-15 fc666 mmbuttom">标题题标题。</p>' +
              '<div class="clearfix">' +
              // '<a class="follow-btn pr-10 ie6png" href="javascript:void(0);" title="1人关注">1人</a>' +
              '<a class="read-btn ie6png" href="javascript:void(0);">'+(item.clickNum || 0)+'</a>' +
              '</div>' +
              '</div>' +
              '</div>');
        })
      }
    }
  });

  // 获取用户喜欢的圈子
  var userTopicData = new FormData();
  userTopicData.append("page", 1);
  userTopicData.append("limit", 20);
  if (userId) {
    userTopicData.append("userId", userId);
  }
  $.ajax({
    type: "post",
    url: "../../topic/getalltopic",
    // contentType: "application/json;charset=utf-8",
    contentType: false,//这里
    processData: false,//这两个一定设置为false
    dataType: "json",
    data: userTopicData,
    success: function (data) {
      if(data && data.resultCode == 200){
        data.topicList.forEach(function (item, index) {
          $(".topicUl").append('<li><a href="page/front/newsList.html?id=' + item.id + '">' + item.topicName + '</a></li>');
        });
      }
    }
  });

  // 获取用户喜欢的新闻
  var userNewsData = new FormData();
  userNewsData.append("page", '1');
  userNewsData.append("limit", '20');
  if (userId) {
    userNewsData.append("userId", userId);
  }
  $.ajax({
    type: "post",
    url: "../../post/getHotPost",
    // contentType: "application/json;charset=utf-8",
    contentType: false,//这里
    processData: false,//这两个一定设置为false
    dataType: "json",
    data: userNewsData,
    success: function (data) {
      if(data && data.resultCode == 200){
        data.postlist.forEach(function (item, index) {
          $(".list3").append('<li><a href="page/front/news.html?id='+item.id+'&topicid='+item.topicId+'">'+item.postName+'</a></li>');
        })
      }
    }
  });

});