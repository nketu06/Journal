package com.nketu.journal.repository;


import com.nketu.journal.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface  JournalEntryRepository extends MongoRepository<JournalEntry,String> {
}
