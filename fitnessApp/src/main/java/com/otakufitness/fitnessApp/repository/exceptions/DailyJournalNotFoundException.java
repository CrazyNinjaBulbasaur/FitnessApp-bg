package com.otakufitness.fitnessApp.repository.exceptions;

public class DailyJournalNotFoundException extends Exception{

    public DailyJournalNotFoundException(long id) {
        super("DailyJournal with " + id + " not found.");
    }
}
