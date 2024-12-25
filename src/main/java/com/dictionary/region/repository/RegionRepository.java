package com.dictionary.region.repository;

import com.dictionary.region.entity.Region;

import java.util.List;

public interface RegionRepository {

    void save(Region region);

    Region findById(Long id);

    void deleteById(Long id);

    List<Region> findAll();
}
