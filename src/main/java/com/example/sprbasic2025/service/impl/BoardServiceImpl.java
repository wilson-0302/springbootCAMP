package com.example.sprbasic2025.service.impl;

import com.example.sprbasic2025.domain.Board;
import com.example.sprbasic2025.dto.BoardDto;
import com.example.sprbasic2025.repository.BoardRepository;
import com.example.sprbasic2025.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    final BoardRepository boardRepository;

    @Override
    public BoardDto.CreateResDto create(BoardDto.CreateReqDto param) {
        String title = param.getTitle();
        String content = param.getContent();
        String author = param.getAuthor();

        Board board = Board.of(title, content, author);
        boardRepository.save(board);

        //BoardDto.CreateResDto resDto = new BoardDto.CreateResDto();
        //resDto.setId(board.getId());

        return BoardDto.CreateResDto.builder().id(board.getId()).build();
    }

    @Override
    public void update(BoardDto.UpdateReqDto param) {
        int code = 200;
        long id = param.getId();
        Board board = boardRepository.findById(param.getId()).orElseThrow(() -> new RuntimeException("no data"));
        if(param.getTitle() != null){ board.setTitle((String) param.getTitle()); }
        if(param.getContent() != null){ board.setContent((String) param.getContent()); }
        if(param.getAuthor() != null){ board.setAuthor((String) param.getAuthor()); }
        boardRepository.save(board);
    }

    @Override
    public void delete(long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("no data"));
        boardRepository.delete(board);
    }

    public BoardDto.DetailResDto get(long id) {
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("no data"));
        return BoardDto.DetailResDto.builder().
                id(board.getId()).
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