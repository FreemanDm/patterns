package com.freeman.patterns.command.bankoperations;

import com.freeman.patterns.command.bankoperations.receivers.Bank;
import lombok.Data;

@Data
public class Person {
    private String name;
    private int accountId;
    private Long amountOfMoneyOnTheCount;
    private Bank bankOfTheClient;

//    public Person(String name, int accountId, Long amountOfMoneyOnTheCount, Bank bankOfTheClient) {
//        this.name = name;
//        this.accountId = accountId;
//        this.amountOfMoneyOnTheCount = amountOfMoneyOnTheCount;
//        this.bankOfTheClient = bankOfTheClient;
//    }

    @Override
    public String toString() {
        return "Count of the " + name + ": " + accountId + " = " + amountOfMoneyOnTheCount + " | ";
    }
}
