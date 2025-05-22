package com.rabelo.dslist.dto;

import com.rabelo.dslist.entities.GameList;

public record GameListDto(
        Long id,
        String name
) {

    public GameListDto(GameList entity) {
        this(entity.getId(), entity.getName());
    }
}
