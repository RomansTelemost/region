package com.dictionary.region.service;

import com.dictionary.region.entity.Region;
import com.dictionary.region.exception.RegionNotFoundException;
import com.dictionary.region.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService {

    private final RegionRepository regionRepository;

    @Override
    public void createRegion(Region region) {
        regionRepository.save(region);
    }

    @Override
    public Region findById(Long id) {
        Region region = regionRepository.findById(id);
        if (region == null) {
            throw new RegionNotFoundException();
        }
        return regionRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        regionRepository.deleteById(id);
    }

    @Override
    public List<Region> findAll() {
        return regionRepository.findAll();
    }
}
