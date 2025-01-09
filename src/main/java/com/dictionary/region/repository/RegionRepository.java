package com.dictionary.region.repository;

import com.dictionary.region.entity.Region;

import java.util.List;
import java.util.Optional;

public interface RegionRepository {

    void save(Region region);

    Optional<Region> findById(Long id);

    void deleteById(Long id);

    List<Region> findAll();

    void deleteAll();
}
