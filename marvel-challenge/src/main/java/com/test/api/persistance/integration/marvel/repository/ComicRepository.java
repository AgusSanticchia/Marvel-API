package com.test.api.persistance.integration.marvel.repository;

import com.test.api.dto.MyPageable;
import com.test.api.persistance.integration.marvel.dto.ComicDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComicRepository {
    public List<ComicDto> findAll(MyPageable pageable, Long characterId) {
        return null;
    }

    public ComicDto findById(Long comicId) {
        return null;
    }
}
