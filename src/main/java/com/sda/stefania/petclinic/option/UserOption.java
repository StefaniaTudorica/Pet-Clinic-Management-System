package com.sda.stefania.petclinic.option;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public enum UserOption {
    ADD_NEW_VET("Add new Veterinarian", 1),
    SHOW_ALL("Display all veterinarians", 2),
    DELETE_BY_ID("Delete veterinarian bt id", 3),
    UPDATE("Update a veterinarian", 4),
    ADD_NEW_PET("Add a new pet", 5),
    EXIT("Exit", 999),
    UNKNOWN("Unknown option, try again", 1000);

    public final String prettyName;
    private final int optionNumber;

    UserOption(String prettyName, int optionNumber) {
        this.prettyName = prettyName;
        this.optionNumber = optionNumber;
    }

    public String getPrettyName() {
        return prettyName;
    }

    public int getOptionNumber() {
        return optionNumber;
    }

    public static void printAllOptions(){
        System.out.println("-------------------------------------------");
        Arrays.stream(UserOption.values())
                .filter(userOption -> !userOption.equals(UserOption.UNKNOWN))
                .forEach(option -> System.out.println(option.prettyName + "->" + option.getOptionNumber()));
    }

    public static Optional<UserOption> findBy(int optionNumber){
        return Arrays.stream(UserOption.values())
                .filter(userOption -> userOption.getOptionNumber()==optionNumber)
                .findAny();
    }
}
