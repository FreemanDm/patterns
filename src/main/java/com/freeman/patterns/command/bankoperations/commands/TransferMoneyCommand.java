package com.freeman.patterns.command.bankoperations.commands;

import com.freeman.patterns.command.bankoperations.receivers.Bank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TransferMoneyCommand implements Command {

    private Bank bank;

//    public TransferMoneyCommand(Bank bank) {
//        this.bank = bank;
//    }

    @Override
    public void execute() {
        bank.send();
    }

    @Override
    public void undo() {
        bank.receive();
    }
}
