package com.nketu.journal.controller;

import com.nketu.journal.entity.JournalEntry;
import com.nketu.journal.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerv2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
        return null;
    }

    @GetMapping("/id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId){
        return null;
    }

    @DeleteMapping ("/id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId){
        return null;
    }

    @PostMapping
    public boolean CreateEntry(@RequestBody JournalEntry myEntry){
        journalEntryService.saveEntry(myEntry);
        return true;
    }

    @PutMapping ("/id/{Id}")
    public JournalEntry updateJournalEntryById(@PathVariable Long Id,@RequestBody JournalEntry myEntry){
        return null;
    }

}
