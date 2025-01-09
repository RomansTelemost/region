package com.dictionary.region.service;

import com.dictionary.region.entity.Region;
import com.dictionary.region.exception.RegionNotFoundException;
import com.dictionary.region.repository.RegionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles({"test"})
class RegionServiceImplTest {

    private RegionRepository regionRepository;

    private RegionService regionService;

    @Autowired
    public RegionServiceImplTest(RegionService regionService,
                                 RegionRepository regionRepository) {
        this.regionService = regionService;
        this.regionRepository = regionRepository;
    }

    @BeforeEach
    void prepareDB() {
        regionRepository.deleteAll();
    }

    @Test
    //@Sql("classpath:delete_all.sql")
    void createAndFindById() {
        Region region = new Region("Алтайский край", 22L);
        regionService.createRegion(region);
        Region findRegion = regionService.findById(region.getCode());
        assertEquals(region, findRegion);
    }

    @Test
    void deleteById() {
        Region region = new Region("Алтайский край", 22L);
        regionService.createRegion(region);
        regionService.deleteById(region.getCode());
        assertThrows(RegionNotFoundException.class, () -> regionService.findById(region.getCode()));
    }

    @Test
    void findAll() {
        Region regionAltay = new Region("Алтайский край", 22L);
        regionService.createRegion(regionAltay);
        Region regionSPB = new Region("Санкт-Петербург", 78L);
        regionService.createRegion(regionSPB);
        List<Region> regionList = regionService.findAll();
        assertEquals(2, regionList.size());
    }
}