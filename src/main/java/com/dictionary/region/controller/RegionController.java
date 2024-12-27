package com.dictionary.region.controller;

import com.dictionary.region.customExceptionAdviceHandler.CustomExceptionHandler;
import com.dictionary.region.entity.Region;
import com.dictionary.region.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@CustomExceptionHandler
public class RegionController {

    private final RegionService regionService;

    @PostMapping("/region")
    public ResponseEntity<Void> createRegion(@RequestBody Region region) {
        regionService.createRegion(region);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/region/{id}")
    public ResponseEntity<Region> getRegionById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(regionService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/region/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable(name = "id") Long id) {
        regionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/regions")
    public ResponseEntity<List<Region>> getAllRegions() {
        return new ResponseEntity<>(regionService.findAll(), HttpStatus.OK);
    }
}
