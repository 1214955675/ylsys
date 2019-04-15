package com.bs.sys.common.response;

import com.bs.sys.entity.Post;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * @author wwj
 * 2019/4/15 10:23
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostResponse extends BaseResponse {
    private Post post;
    private List<Post> postlist;

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<Post> getPostlist() {
        return postlist;
    }

    public void setPostlist(List<Post> postlist) {
        this.postlist = postlist;
    }
}
