package com.example.sprbasic2025.service.impl;

import com.example.sprbasic2025.domain.Board;
import com.example.sprbasic2025.dto.BoardDto;
import com.example.sprbasic2025.dto.DefaultDto;
import com.example.sprbasic2025.repository.BoardRepository;
import com.example.sprbasic2025.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class        BoardServiceImpl implements BoardService {

    final BoardRepository boardRepository;

    @Override
//    public DefaultDto.CreateResDto create(BoardDto.CreateReqDto param) {
//        String title = param.getTitle();
//        String content = param.getContent();
//        String author = param.getAuthor();
//
//        Board board = Board.of(title, content, author);
//        boardRepository.save(board);
//
//        //BoardDto.CreateResDto resDto = new BoardDto.CreateResDto();
//        //resDto.setId(board.getId());
//
//        return DefaultDto.CreateResDto.builder().id(board.getId()).build();
//    }
    public DefaultDto.CreateResDto create(BoardDto.CreateReqDto param) {
        return boardRepository.save(param.toEntity()).toCreateResDto();
    }

    @Override
    public void update(BoardDto.UpdateReqDto param) {
        Board board = boardRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        if(param.getDeleted() != null){ board.setDeleted(param.getDeleted()); }
        if(param.getTitle() != null){ board.setTitle(param.getTitle()); }
        if(param.getContent() != null){ board.setContent(param.getContent()); }
        if(param.getAuthor() != null){ board.setAuthor(param.getAuthor()); }
        boardRepository.save(board);
    }

    @Override
    public void delete(long id) {
        //삭제 방법 0
        //boardRepository.delete(board); //완전 삭제
        //삭제 방법 1
        //Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("no data"));
        //board.setDeleted(true);
        //boardRepository.save(board); //소프트 삭제
        //삭제 방법 2
        update(BoardDto.UpdateReqDto.builder().id(id).deleted(true).build());
    }

    public BoardDto.DetailResDto get(long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("no data"));
        return BoardDto.DetailResDto.builder().
                id(board.getId()).
                deleted(board.getDeleted()).
                createdAt(board.getCreatedAt()).
                modifiedAt(board.getModifiedAt()).
                title(board.getTitle()).
                content(board.getContent()).
                author(board.getAuthor()).
                build();
    }

    @Override
    public BoardDto.DetailResDto detail(long id) {
        return get(id);
    }

    @Override
    public List<BoardDto.DetailResDto> list() {
        List<BoardDto.DetailResDto> resultList = new ArrayList<>();
        List<Board> list = boardRepository.findAll();
        for(Board board : list){
            resultList.add(get(board.getId()));
        }
        return resultList;
    }
}