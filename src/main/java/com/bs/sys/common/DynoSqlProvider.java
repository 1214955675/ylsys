package com.bs.sys.common;

import com.bs.sys.entity.Post;
import com.bs.sys.entity.Topic;
import com.bs.sys.entity.User;
import org.apache.ibatis.jdbc.SQL;

public class DynoSqlProvider {
    //方法中的关键字是区分大小写的  SQL SELECT WHERE
    //该方法会根据传递过来的map中的参数内容  动态构建sql语句
    public String insertEmployeeSql(final User user) {
        return new SQL() {
            {
                INSERT_INTO("user");
                if(user.getId()!=null) {
                    VALUES("id","#{id}");
                }
                if(user.getUserName()!=null){
                    VALUES("userName","userName");
                }
                if(user.getNickName()!=null) {
                    VALUES("nickName", "#{nickName}");
                }
                if(user.getPassWord()!=null) {
                    VALUES("passWord", "#{passWord}");
                }
                if(user.getPhone()!=null) {
                    VALUES("phone", "#{phone}");
                }
            }
        }.toString();

    }
    public String updateUserSql(final User user) {
        return new SQL() {
            {
                UPDATE("user");
                if(user.getId()!=null) {
                    SET("id=#{id}");
                }
                if(user.getUserName()!=null) {
                    SET("userName=#{userName}");
                }
                if(user.getNickName()!=null) {
                    SET("nickName=#{nickName}");
                }
                if(user.getPassWord()!=null) {
                    SET("passWord=#{passWord}");
                }
                if(user.getPhone()!=null) {
                    SET("phone=#{phone}");
                }
                if(user.getUserImg()!=null) {
                    SET("userImg=#{userImg}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }
    public String updateTopicSql(final Topic topic) {
        return new SQL() {
            {
                UPDATE("topic");
                if(topic.getId()!=null) {
                    SET("id=#{id}");
                }
                if(topic.getTopicName()!=null) {
                    SET("topicName=#{topicName}");
                }
                if(topic.getPostNum()!=null) {
                    SET("postNum=#{postNum}");
                }
                if(topic.getClickNum()!=0) {
                    SET("clickNum=#{clickNum}");
                }
                if(topic.getImgUrl()!=null) {
                    SET("imgUrl=#{imgUrl}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }
    public String updatePostSql(final Post post) {
        return new SQL() {
            {
                UPDATE("post");

                if(post.getPostName()!=null) {
                    SET("postName=#{postName}");
                }
                if(post.getTopicId()!=null) {
                    SET("topicId=#{topicId}");
                }
                if(post.getCreateTime()!=null) {
                    SET("createTime=#{createTime}");
                }
                if(post.getClickNum()!=null) {
                    SET("clickNum=#{clickNum}");
                }
                if(post.getContent()!=null){
                    SET("content=#{content}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }
}
