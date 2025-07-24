package com.example.sprbasic2025.mapper;

import com.example.sprbasic2025.dto.DefaultDto;
import com.example.sprbasic2025.dto.PostDto;

import java.util.List;

public interface PostMapper {
    /**/
    PostDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<PostDto.DetailResDto> list(PostDto.ListReqDto param);
    List<PostDto.DetailResDto> pagedList(PostDto.PagedListReqDto param);
    int pagedListCount(PostDto.PagedListReqDto param);
    List<PostDto.DetailResDto> scrollList(PostDto.ScrollListReqDto param);
}
