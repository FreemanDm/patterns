package com.freeman.patterns.command.bankoperations;

import com.freeman.patterns.command.bankoperations.receivers.Bank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private int accountId;
    private Long amountOfMoneyOnTheCount;
    private Bank bankOfTheClient;

    @Override
    public String toString() {
        return bankOfTheClient + " => account of the " + name + ": " + accountId + " = " + amountOfMoneyOnTheCount;
    }
}
