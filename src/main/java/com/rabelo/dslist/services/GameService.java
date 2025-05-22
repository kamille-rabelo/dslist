package com.rabelo.dslist.services;

import com.rabelo.dslist.dto.GameMinDto;
import com.rabelo.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

     @Autowired
     private GameRepository gameRepository;

     public List<GameMinDto> findAll() {
         var result = gameRepository.findAll();
         return result.stream().map(GameMinDto::new).collect(Collectors.toList());
     }
}
