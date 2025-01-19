package com.test.api.services;

import com.test.api.dto.MyPageable;
import com.test.api.persistance.integration.marvel.dto.CharacterDto;

import java.util.List;

public interface CharacterService {
    List<CharacterDto> findAll(MyPageable pageable, String name, int[] comics, int[] series);
    CharacterDto.CharacterInfoDto findInfoById(Long characterId);
}
