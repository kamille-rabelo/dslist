package com.rabelo.dslist.dto;

import com.rabelo.dslist.entities.Game;
import com.rabelo.dslist.projections.GameMinProjection;

public record GameMinDto(
        Long id,
        String title,
        String imgUrl,
        Integer year,
        String shortDescription
) {
    public GameMinDto(Game entity) {
        this(entity.getId(), entity.getTitle(), entity.getImgUrl(), entity.getYear(), entity.getShortDescription());
    }

    public GameMinDto(GameMinProjection projection) {
        this(projection.getId(), projection.getTitle(), projection.getImgUrl(), projection.getYear(), projection.getShortDescription());
    }
}
