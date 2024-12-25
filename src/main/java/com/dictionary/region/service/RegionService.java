package com.dictionary.region.service;

import com.dictionary.region.dto.RegionDto;
import com.dictionary.region.entity.Region;

import java.util.List;

public interface RegionService {

    void createRegion(Region region);

    Region findById(Long id);

    void deleteById(Long id);

    List<Region> findAll();
}
