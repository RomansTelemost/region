package com.dictionary.region.repository;

import com.dictionary.region.entity.Region;
import com.dictionary.region.exception.SqlProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RegionRepositoryImpl implements RegionRepository {

    private final static String INSERT_REGION = "INSERT INTO region(name, code) VALUES (?, ?)";
    private final static String GET_REGION = "SELECT * FROM region WHERE code = ?";
    private final static String DELETE_BY_ID = "DELETE FROM region where code = ?";
    private final static String GET_ALL_REGION = "SELECT * FROM region";
    private final static String DELETE_ALL = "DELETE FROM region";

    private final DataSource dataSource;

    @Override
    public void save(Region region) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_REGION)) {

            statement.setString(1, region.getName());
            statement.setLong(2, region.getCode());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SqlProcessingException(e);
        }
    }

    @Override
    public Optional<Region> findById(Long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_REGION)) {
            statement.setLong(1, id);

            ResultSet results = statement.executeQuery();
            if (!results.next()) {
                return Optional.empty();
            }

            Region region = new Region();
            region.setName(results.getString(1));
            region.setCode(results.getLong(2));
            return Optional.of(region);
        } catch (SQLException e) {
            throw new SqlProcessingException(e);
        }
    }

    @Override
    public void deleteById(Long id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new SqlProcessingException(e);
        }
    }

    @Override
    public List<Region> findAll() {
        List<Region> regions = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_REGION)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Region region = new Region();
                region.setName(resultSet.getString(1));
                region.setCode(resultSet.getLong(2));
                regions.add(region);
            }
        } catch (SQLException e) {
            throw new SqlProcessingException(e);
        }
        return regions;
    }

    @Override
    public void deleteAll() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ALL)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new SqlProcessingException(e);
        }
    }
}
