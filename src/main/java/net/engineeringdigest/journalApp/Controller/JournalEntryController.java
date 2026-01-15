package net.engineeringdigest.journalApp.Controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalentries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){  // localhost:8080/journal GET
        return new ArrayList<>(journalentries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){  // localhost:8080/journal POST
        journalentries.put(myEntry.getId(),myEntry);
        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId){
        return journalentries.get(myId);
    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable Long myId){
        return journalentries.remove(myId);
    }

    @PutMapping("id/{id}")
    public JournalEntry updateJournalEntryById(@PathVariable Long id, @RequestBody JournalEntry myEntry){
        return  journalentries.put(id, myEntry);
    }
}
