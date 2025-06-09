package com.spartified.telecomApi.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "telecom_entries")
public class TelecomEntry {

    @Id
    @Schema(hidden = true)
    private ObjectId id;

    @Indexed(unique = true)
    @NotBlank(message = "SIM number is required")
    @Pattern(regexp = "^\\+91\\d{10}$", message = "SIM number must be in format +91XXXXXXXXXX")
    @Schema(example = "+919625803256")
    private String simNumber;

    @NotBlank(message = "Name is required")
    @Schema(example = "Bharat Aggarwal")
    private String name;

    @NotBlank(message = "Address is required")
    @Schema(example = "426/25, Colony Name, City Name, pincode-121003")
    private String address;

    @Indexed(unique = true)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Schema(example = "bharataggarwal2k2@gmail.com")
    private String email;

    @NotBlank(message = "Plan name is required")
    @Pattern(regexp = "^[0-9]+GB$", message = "Plan must be a number followed by GB (e.g., 10GB)")
    @Schema(example = "10GB")
    private String planName;

    @Min(value = 0, message = "SMS quantity must be non-negative")
    @Schema(example = "200")
    private int smsQuantity;

    @Min(value = 0, message = "Voice minutes must be non-negative")
    @Schema(example = "500")
    private int voiceMinutes;

    @Min(value = 0, message = "Data internet must be non-negative")
    @Schema(example = "10")
    private long dataInternet; // GB in input, converted to bytes in service

    // Getters and Setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getSimNumber() {
        return simNumber;
    }

    public void setSimNumber(String simNumber) {
        this.simNumber = simNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public int getSmsQuantity() {
        return smsQuantity;
    }

    public void setSmsQuantity(int smsQuantity) {
        this.smsQuantity = smsQuantity;
    }

    public int getVoiceMinutes() {
        return voiceMinutes;
    }

    public void setVoiceMinutes(int voiceMinutes) {
        this.voiceMinutes = voiceMinutes;
    }

    public long getDataInternet() {
        return dataInternet;
    }

    public void setDataInternet(long dataInternet) {
        this.dataInternet = dataInternet;
    }
}