package com.otakufitness.fitnessApp.controller;


import com.otakufitness.fitnessApp.domain.dailyJournal.DailyJournalDto;
import com.otakufitness.fitnessApp.repository.exceptions.DailyJournalNotFoundException;
import com.otakufitness.fitnessApp.service.facade.DailyJournalFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/dailyJournals")
@RequiredArgsConstructor
@CrossOrigin("*")
public class DailyJournalController {
    private final DailyJournalFacade dailyJournalFacade;

    @GetMapping
    public ResponseEntity<List<DailyJournalDto>> getDailyJournals() {
        return ResponseEntity.ok(dailyJournalFacade.getAllDailyJournals());
    }

    @GetMapping(value = "{dailyJournalId}")
    public ResponseEntity<DailyJournalDto> getDailyJournal(@PathVariable long dailyJournalId) throws DailyJournalNotFoundException {
        return ResponseEntity.ok(dailyJournalFacade.getDailyJournalById(dailyJournalId));
    }

    @PostMapping()
    public ResponseEntity<Void> addDailyJournal(@RequestBody DailyJournalDto dailyJournalDto) {
        dailyJournalFacade.addDailyJournal(dailyJournalDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity<DailyJournalDto> updateDailyJournal(@RequestBody DailyJournalDto dailyJournalDto) {
        return ResponseEntity.ok(dailyJournalFacade.updateDailyJournal(dailyJournalDto));
    }

    @DeleteMapping(value = "{dailyJournalId}")
    public ResponseEntity<Void> deleteDailyJournal(@PathVariable long dailyJournalId) {
        dailyJournalFacade.deleteDailyJournal(dailyJournalId);
        return ResponseEntity.ok().build();
    }
}
