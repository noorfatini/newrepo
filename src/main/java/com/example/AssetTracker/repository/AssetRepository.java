package com.example.AssetTracker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.AssetTracker.model.Asset;

public interface AssetRepository extends MongoRepository<Asset, String> {
    // Custom query methods can be defined here if needed

}
