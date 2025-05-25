package com.rabelo.dslist.services;

import com.rabelo.dslist.dto.GameListDto;
import com.rabelo.dslist.repositories.GameListRepository;
import com.rabelo.dslist.repositories.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameListService {

     @Autowired
     private GameListRepository gameListRepository;

     @Autowired
     private GameRepository gameRepository;

     @Transactional(readOnly = true)
     public List<GameListDto> findAll() {
         var lists = gameListRepository.findAll();
         return lists.stream().map(GameListDto::new).collect(Collectors.toList());
     }

    public void move(Long listId, int fromIndex, int toIndex) {
        var gameList = gameRepository.searchByList(listId);
        var tempList = gameList.remove(fromIndex);
        gameList.add(toIndex, tempList);

        var min = Math.min(fromIndex, toIndex);
        var max = Math.max(fromIndex, toIndex);
        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, gameList.get(i).getId(), i);
        }
    }
}
