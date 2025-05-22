package com.rabelo.dslist.services;

import com.rabelo.dslist.dto.GameListDto;
import com.rabelo.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameListService {

     @Autowired
     private GameListRepository gameListRepository;

     @Transactional(readOnly = true)
     public List<GameListDto> findAll() {
         var lists = gameListRepository.findAll();
         return lists.stream().map(GameListDto::new).collect(Collectors.toList());
     }
}
