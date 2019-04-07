$(function () {

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
          $(".topicUl").append('<li>' + item.id + '-' + item.topicName + '</li>');
        });
      }
    }
  });

});