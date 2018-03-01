package com.freeman.patterns.command.bankoperations.commands;

import com.freeman.patterns.command.bankoperations.Person;
import com.freeman.patterns.command.bankoperations.receivers.Bank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
public class SendMoneyCommand implements Command {

    private Bank bank;

    public SendMoneyCommand(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void execute() {
        bank.send();
    }

    @Override
    public void undo() {
        bank.receive();
    }
}
