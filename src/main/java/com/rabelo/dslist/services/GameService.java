package com.rabelo.dslist.services;

import com.rabelo.dslist.dto.GameDto;
import com.rabelo.dslist.dto.GameMinDto;
import com.rabelo.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

     @Autowired
     private GameRepository gameRepository;

     @Transactional(readOnly = true)
     public List<GameMinDto> findAll() {
         var games = gameRepository.findAll();
         return games.stream().map(GameMinDto::new).collect(Collectors.toList());
     }

     @Transactional(readOnly = true)
     public GameDto findById(Long id) {
         var game = gameRepository.findById(id);
         return game.map(GameDto::new).orElse(null);
     }

     @Transactional(readOnly = true)
    public List<GameMinDto> findByList(Long listId) {
        var games = gameRepository.searchByList(listId);
        return games.stream().map(GameMinDto::new).collect(Collectors.toList());
    }
}
