package com.test.api.services.impl;

import com.test.api.dto.MyPageable;
import com.test.api.persistance.integration.marvel.dto.CharacterDto;
import com.test.api.persistance.integration.marvel.repository.CharacterRepository;
import com.test.api.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterRepository characterRepository;


    @Override
    public List<CharacterDto> findAll(MyPageable pageable, String name, int[] comics, int[] series) {
        return characterRepository.findAll(pageable, name, comics, series);
    }

    @Override
    public CharacterDto.CharacterInfoDto findInfoById(Long characterId) {
        return characterRepository.findInfoById(characterId);
    }

}
