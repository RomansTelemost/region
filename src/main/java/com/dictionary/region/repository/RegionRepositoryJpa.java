package com.dictionary.region.repository;

import com.dictionary.region.entity.Region;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@ConditionalOnProperty(name = "repoImpl", havingValue = "jpa")
public class RegionRepositoryJpa implements RegionRepository{

    private final EntityManager entityManager;

    @Override
    @Transactional
    public void save(Region region) {
        entityManager.persist(region);
    }

    @Override
    public Optional<Region> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Region.class, id));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        entityManager.remove(entityManager.find(Region.class, id));
    }

    @Override
    public List<Region> findAll() {
        return entityManager.createQuery("Select region from Region region", Region.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void deleteAll() {
        entityManager.createQuery("Delete from Region").executeUpdate();
    }
}
