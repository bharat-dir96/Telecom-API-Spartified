package com.spartified.telecomApi.service;

import com.spartified.telecomApi.entity.TelecomEntry;
import com.spartified.telecomApi.repository.TelecomEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TelecomEntryService {

    @Autowired
    private TelecomEntryRepository telecomEntryRepository;

    public List<TelecomEntry> getAllEntries() {
        List<TelecomEntry> entries = telecomEntryRepository.findAll();

        for(TelecomEntry entry: entries) {
            int voiceInMinutes = entry.getVoiceMinutes() / 60;
            entry.setVoiceMinutes(voiceInMinutes);

            long dataInGB = entry.getDataInternet() / (1024L * 1024L * 1024L);
            entry.setDataInternet(dataInGB);
        }

        return entries;
    }

    public void saveEntry(TelecomEntry telecomEntry) {
        int voiceInSeconds = telecomEntry.getVoiceMinutes() * 60;
        telecomEntry.setVoiceMinutes(voiceInSeconds);

        long dataInBytes = telecomEntry.getDataInternet() * 1024L * 1024L * 1024L;
        telecomEntry.setDataInternet(dataInBytes);

        telecomEntryRepository.save(telecomEntry);
    }

    public Optional<TelecomEntry> getEntryBySimNumber(String simNumber) {
        Optional<TelecomEntry> entryOptional = telecomEntryRepository.findBySimNumber(simNumber);

        entryOptional.ifPresent(entry -> {
            int voiceInMinutes = entry.getVoiceMinutes() / 60;
            entry.setVoiceMinutes(voiceInMinutes);

            long dataInGB = entry.getDataInternet() / (1024L * 1024L * 1024L);
            entry.setDataInternet(dataInGB);
        });

        return entryOptional;
    }

    public void saveEntryRaw(TelecomEntry telecomEntry) {
        int voiceInSeconds = telecomEntry.getVoiceMinutes() * 60;
        telecomEntry.setVoiceMinutes(voiceInSeconds);

        long dataInBytes = telecomEntry.getDataInternet() * 1024L * 1024L * 1024L;
        telecomEntry.setDataInternet(dataInBytes);

        telecomEntryRepository.save(telecomEntry);
    }

}
