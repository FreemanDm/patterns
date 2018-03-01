package com.freeman.patterns.command.bankoperations.invokers;

import com.freeman.patterns.command.bankoperations.Person;
import com.freeman.patterns.command.bankoperations.commands.TransferMoneyCommand;
import com.freeman.patterns.command.bankoperations.receivers.Bank;
import org.junit.Test;

public class MoneyTransferTest {

    @Test
    public void moneyTransferTest(){
        Bank cityBank = new Bank("City bank");
        Person senderMike = new Person("Mike", 123456789, 100000L, cityBank);
        Person receiverJack = new Person("Jack", 987654321, 200000L, cityBank);
        System.out.print(senderMike);
        System.out.println(receiverJack);
        TransferMoneyCommand transferMoneyCommand = new TransferMoneyCommand(cityBank);
        MoneyTransfer moneyTransfer = new MoneyTransfer(transferMoneyCommand, 1, 100L, senderMike, receiverJack);
        moneyTransfer.transferMoneyOperation(moneyTransfer);



//        moneyTransfer.undoMoneyOperation();
//        System.out.print(senderMike);
//        System.out.println(receiverJack);

        
    }

}