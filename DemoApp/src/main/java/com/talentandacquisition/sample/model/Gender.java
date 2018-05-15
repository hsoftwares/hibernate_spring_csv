package com.talentandacquisition.sample.model;

public enum Gender implements java.io.Serializable{
    MALE("male"), FEMALE("female");

    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
