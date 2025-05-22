package com.rabelo.dslist.dto;

import com.rabelo.dslist.entities.Game;

public record GameMinDto(
        Long id,
        String title,
        String gameImgUrl,
        Integer year,
        String genre,
        String platforms
) {
    public GameMinDto(Game entity) {
        this(entity.getId(), entity.getTitle(), entity.getImgUrl(), entity.getYear(), entity.getGenre(), entity.getPlatforms());
    }
}
