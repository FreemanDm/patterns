package com.freeman.patterns.command.bankoperations.commands;

import com.freeman.patterns.command.bankoperations.receivers.Bank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferMoneyCommand implements Command {

    private Bank bank;

    @Override
    public void execute() {
        bank.send();
    }

    @Override
    public void undo() {
        bank.receive();
    }
}
