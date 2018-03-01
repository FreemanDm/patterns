package com.freeman.patterns.command.bankoperations.commands;

import com.freeman.patterns.command.bankoperations.receivers.Bank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReceiveMoneyCommand implements Command {

    private Bank bank;

    public ReceiveMoneyCommand(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void execute() {
        bank.receive();
    }

    @Override
    public void undo() {
        bank.send();
    }
}
