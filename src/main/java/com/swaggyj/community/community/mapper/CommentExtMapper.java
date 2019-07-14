package com.swaggyj.community.community.mapper;


import com.swaggyj.community.community.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}