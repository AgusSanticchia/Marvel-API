package com.test.api.web.controller;

import com.test.api.dto.MyPageable;
import com.test.api.persistance.integration.marvel.dto.ComicDto;
import com.test.api.services.ComicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comics")
public class ComicController {

    @Autowired
    private ComicService comicService;

    @PreAuthorize("hasAuthority('comic:read-all')")
    @GetMapping
    public ResponseEntity<List<ComicDto>> findAll(
            @RequestParam(required = false) Long characterId,
            @RequestParam(defaultValue = "0") long offset,
            @RequestParam(defaultValue = "10") long limit
    )
    {
        MyPageable pageable = new MyPageable(offset, limit);
        return ResponseEntity.ok(comicService.findAll(pageable, characterId));
    }

    @PreAuthorize("hasAuthority('comic:read-by-id')")
    @GetMapping("/{comicId}")
    public ResponseEntity<ComicDto> findById(@PathVariable Long comicId){
        return ResponseEntity.ok(comicService.findById(comicId));
    }
}
