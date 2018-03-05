package com.freeman.patterns.command.bankoperations.commands;

import com.freeman.patterns.command.bankoperations.Person;
import com.freeman.patterns.command.bankoperations.receivers.Bank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferMoneyCommand implements Command {

    private int operationID;
    private Bank bank;
    private Person sender;
    private Person receiver;
    private Long amountOfMoney;

    @Override
    public void execute() {
        sender.setAmountOfMoneyOnTheCount(sender.getAmountOfMoneyOnTheCount() - amountOfMoney);
        receiver.setAmountOfMoneyOnTheCount(receiver.getAmountOfMoneyOnTheCount() + amountOfMoney);
        setOperationID(getOperationID());
        bank.send();
    }

    @Override
    public void undo() {
        sender.setAmountOfMoneyOnTheCount(sender.getAmountOfMoneyOnTheCount() + amountOfMoney);
        receiver.setAmountOfMoneyOnTheCount(receiver.getAmountOfMoneyOnTheCount() - amountOfMoney);
        bank.receive();
    }

    @Override
    public String toString() {
        return "Transferring money: " +
                "transfer ID = " + operationID +
                ", operation bank: " +
                bank +
                ", " +
                sender.getName() +
                " -> " +
                receiver.getName() +
                ", amount of money transfer = " + amountOfMoney;
    }
}
