package com.example.sprbasic2025.service.impl;

import com.example.sprbasic2025.domain.Postimg;
import com.example.sprbasic2025.dto.DefaultDto;
import com.example.sprbasic2025.dto.PostimgDto;
import com.example.sprbasic2025.mapper.PostimgMapper;
import com.example.sprbasic2025.repository.PostimgRepository;
import com.example.sprbasic2025.service.PostimgService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PostimgServiceImpl implements PostimgService {

    final PostimgRepository postimgRepository;
    final PostimgMapper postimgMapper;

    /**/

    @Override
    public DefaultDto.CreateResDto create(PostimgDto.CreateReqDto param) {
        return postimgRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(PostimgDto.UpdateReqDto param) {
        Postimg postimg = postimgRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        if(param.getDeleted() != null){ postimg.setDeleted(param.getDeleted()); }
        if(param.getImg() != null){ postimg.setImg(param.getImg()); }
        postimgRepository.save(postimg);
    }

    @Override
    public void delete(PostimgDto.UpdateReqDto param) {
        update(PostimgDto.UpdateReqDto.builder().id(param.getId()).deleted(true).build());
    }

    public PostimgDto.DetailResDto get(DefaultDto.DetailReqDto param) {
        PostimgDto.DetailResDto res = postimgMapper.detail(param);
        return res;
    }

    @Override
    public PostimgDto.DetailResDto detail(DefaultDto.DetailReqDto param) {
        return get(param);
    }
    @Override
    public List<PostimgDto.DetailResDto> list(PostimgDto.ListReqDto param) {
        return addList(postimgMapper.list(param));
    }

    public List<PostimgDto.DetailResDto> addList(List<PostimgDto.DetailResDto> list) {
        List<PostimgDto.DetailResDto> returnList = new ArrayList<>();
        for(PostimgDto.DetailResDto each : list){
            returnList.add(get(DefaultDto.DetailReqDto.builder().id(each.getId()).build()));
        }
        return returnList;
    }

    @Override
    public DefaultDto.PagedListResDto pagedList(PostimgDto.PagedListReqDto param) {
        DefaultDto.PagedListResDto res = param.init(postimgMapper.pagedListCount(param));
        res.setList(addList(postimgMapper.pagedList(param)));
        return res;
    }

    @Override
    public List<PostimgDto.DetailResDto> scrollList(PostimgDto.ScrollListReqDto param) {
        param.init();
        return addList(postimgMapper.scrollList(param));
    }
}
