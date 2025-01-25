package com.test.api.persistance.integration.marvel.mapper;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.test.api.persistance.integration.marvel.dto.ComicDto;
import com.test.api.persistance.integration.marvel.dto.ThumbnailDto;

public class ComicMapper {

    public static List<ComicDto> toDtoList(JsonNode rootNode){
        ArrayNode resultsNode = getResultsNode(rootNode);

        List<ComicDto> comics = new ArrayList<>();
        resultsNode.elements().forEachRemaining(each -> {
            comics.add(ComicMapper.toDto(each));
        });

        return comics;
    }

    private static ComicDto toDto(JsonNode comicNode) {
        if(comicNode == null){
            throw new IllegalArgumentException("El nodo json no puede ser null");
        }

        ThumbnailDto thumbnailDto = ThumbnailMapper.toDto(comicNode.get("thumbnail"));

        ComicDto dto = new ComicDto(
                comicNode.get("id").asLong(),
                comicNode.get("title").asText(),
                comicNode.get("description").asText(),
                comicNode.get("modified").asText(),
                comicNode.get("resourceURI").asText(),
                thumbnailDto
        );

        return dto;
    }

    private static ArrayNode getResultsNode(JsonNode rootNode){
        if(rootNode == null){
            throw new IllegalArgumentException("El nodo json no puede ser null");
        }

        JsonNode dataNode = rootNode.get("data");
        return (ArrayNode) dataNode.get("results");
    }
}
