package com.test.api.web.controller;

import com.test.api.persistance.integration.marvel.dto.CharacterDto;
import com.test.api.dto.MyPageable;
import com.test.api.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @PreAuthorize("hasAuthority('character:read-all')")
    @GetMapping
    public ResponseEntity<List<CharacterDto>> findAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) int[] comics,
            @RequestParam(required = false) int[] series,
            @RequestParam(defaultValue = "0" ) long offset,
            @RequestParam(defaultValue = "10" ) long limit
    )
    {
        MyPageable pageable = new MyPageable(offset, limit);
        return ResponseEntity.ok(characterService.findAll(pageable, name, comics, series));
    }

    @PreAuthorize("hasAuthority('character:read-detail')")
    @GetMapping("/{characterId}")
    public ResponseEntity<CharacterDto.CharacterInfoDto> findInfoById(@PathVariable Long characterId){
        return ResponseEntity.ok(characterService.findInfoById(characterId));
    }
}
