package com.spartified.telecomApi.repository;

import com.spartified.telecomApi.entity.TelecomEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TelecomEntryRepository extends MongoRepository<TelecomEntry, ObjectId> {

    Optional<TelecomEntry> findBySimNumber(String simNumber);
}
