package com.rabelo.dslist.controllers;

import com.rabelo.dslist.dto.GameDto;
import com.rabelo.dslist.dto.GameMinDto;
import com.rabelo.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<List<GameMinDto>> findAll() {
        var games = gameService.findAll();
        return ResponseEntity.ok(games);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GameDto> findById(@PathVariable Long id) {
        var game = gameService.findById(id);
        return ResponseEntity.ok(game);
    }
}
