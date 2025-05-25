package com.rabelo.dslist.controllers;

import com.rabelo.dslist.dto.GameListDto;
import com.rabelo.dslist.dto.GameMinDto;
import com.rabelo.dslist.dto.ReplacementDto;
import com.rabelo.dslist.services.GameListService;
import com.rabelo.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameListDto>> findAll() {
        var lists = gameListService.findAll();
        return ResponseEntity.ok(lists);
    }

    @GetMapping(value = "/{id}/games")
    public ResponseEntity<List<GameMinDto>> findByList(@PathVariable Long id) {
        var games = gameService.findByList(id);
        return ResponseEntity.ok(games);
    }

    @PostMapping(value = "/{listId}/replacement")
    public ResponseEntity<Void> move(@PathVariable Long listId, @RequestBody ReplacementDto body) {
        gameListService.move(listId, body.fromIndex(), body.toIndex());
        return ResponseEntity.noContent().build();
    }
}
