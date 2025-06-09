package com.spartified.telecomApi.contoller;

import com.spartified.telecomApi.entity.TelecomEntry;
import com.spartified.telecomApi.service.TelecomEntryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/telecom")
@Tag(name = "Telecom API", description = "Operations for SIM management")
public class TelecomEntryController {

    @Autowired
    private TelecomEntryService telecomEntryService;

    @Operation(summary = "Get all telecom entries")
    @GetMapping("/get")
    public List<TelecomEntry> getAll() {
        return telecomEntryService.getAllEntries();
    }

    @Operation(summary = "Create a new telecom entry")
    @PostMapping("/create")
    public String createEntry(@Valid @RequestBody TelecomEntry newEntry) {
        telecomEntryService.saveEntry(newEntry);
        return "New Entry Created Successfully";
    }

    @Operation(summary = "Get a telecom entry by sim number")
    @GetMapping("/get/{simNumber}")
    public TelecomEntry getTelecomEntryBySimNumber(@PathVariable String simNumber) {
        return telecomEntryService.getEntryBySimNumber(simNumber).orElse(null);
    }

    @Operation(summary = "Modify a telecom entry by sim number")
    @PatchMapping ("/modify/{simNumber}")
    public TelecomEntry updateTelecomEntryBySimNumber(@PathVariable String simNumber, @RequestBody TelecomEntry newEntry) {
        TelecomEntry oldEntry = telecomEntryService.getEntryBySimNumber(simNumber).orElse(null);

        if (oldEntry != null) {
            if (newEntry.getName() != null && !newEntry.getName().isEmpty()) oldEntry.setName(newEntry.getName());
            if (newEntry.getAddress() != null && !newEntry.getAddress().isEmpty())
                oldEntry.setAddress(newEntry.getAddress());
            if (newEntry.getEmail() != null && !newEntry.getEmail().isEmpty()) oldEntry.setEmail(newEntry.getEmail());
            if (newEntry.getPlanName() != null && !newEntry.getPlanName().isEmpty())
                oldEntry.setPlanName(newEntry.getPlanName());
            if (newEntry.getSmsQuantity() > 0) oldEntry.setSmsQuantity(newEntry.getSmsQuantity());

            if (newEntry.getVoiceMinutes() > 0) oldEntry.setVoiceMinutes(newEntry.getVoiceMinutes());

            if (newEntry.getDataInternet() > 0) oldEntry.setDataInternet(newEntry.getDataInternet());


            telecomEntryService.saveEntryRaw(oldEntry);
        }

        return telecomEntryService.getEntryBySimNumber(simNumber).orElse(null);
    }

}
