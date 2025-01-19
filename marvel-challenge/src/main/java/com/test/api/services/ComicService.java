package com.test.api.services;

import com.test.api.persistance.integration.marvel.dto.ComicDto;
import com.test.api.dto.MyPageable;

import java.util.List;

public interface ComicService {

    List<ComicDto> findAll(MyPageable pageable, Long characterId);

    ComicDto findById(Long comicId);
}