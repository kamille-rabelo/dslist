package com.rabelo.dslist.controllers;

import com.rabelo.dslist.dto.GameListDto;
import com.rabelo.dslist.services.GameListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public ResponseEntity<List<GameListDto>> findAll() {
        var lists = gameListService.findAll();
        return ResponseEntity.ok(lists);
    }
}
