package com.freeman.patterns.command.bankoperations.invokers;

import com.freeman.patterns.command.bankoperations.Person;
import com.freeman.patterns.command.bankoperations.commands.TransferMoneyCommand;
import com.freeman.patterns.command.bankoperations.receivers.Bank;
import org.junit.Test;

public class MoneyTransferTest {

    @Test
    public void moneyTransferTest(){
        Bank cityBank = new Bank("City bank");
        Bank leumiBank = new Bank("Leumi bank");
        Person mike = new Person("Mike", 123456789, 100000L, cityBank);
        Person jack = new Person("Jack", 987654321, 200000L, cityBank);
        Person anna = new Person("Anna", 567382905, 500000L, leumiBank);
        Person jimmy = new Person("Jimmy", 980567325, 300000L, leumiBank);
        System.out.println("==========Start State=========================================================================");
        System.out.println(mike);
        System.out.println(jack);
        System.out.println(anna);
        System.out.println(jimmy);

        MoneyTransfer moneyTransfer = new MoneyTransfer();
        TransferMoneyCommand transferMoneyCommand1 = new TransferMoneyCommand(1, cityBank, mike, jack, 100L);
        TransferMoneyCommand transferMoneyCommand2 = new TransferMoneyCommand(2, cityBank, mike, anna, 1000L);
        TransferMoneyCommand transferMoneyCommand3 = new TransferMoneyCommand(3, cityBank, mike, jimmy, 500L);
        TransferMoneyCommand transferMoneyCommand4 = new TransferMoneyCommand(4, cityBank, mike, jack, 2500L);
        TransferMoneyCommand transferMoneyCommand5 = new TransferMoneyCommand(5, leumiBank, anna, jimmy, 250L);
        TransferMoneyCommand transferMoneyCommand6 = new TransferMoneyCommand(6, leumiBank, anna, jack, 50000L);
        TransferMoneyCommand transferMoneyCommand7 = new TransferMoneyCommand(7, leumiBank, jimmy, jack, 400000L);
        TransferMoneyCommand transferMoneyCommand8 = new TransferMoneyCommand(8, cityBank, mike, anna, 750L);
        System.out.println("==========Transferring Money==================================================================");
        System.out.println(transferMoneyCommand1);
        moneyTransfer.transferMoneyOperation(transferMoneyCommand1);
        System.out.println(transferMoneyCommand2);
        moneyTransfer.transferMoneyOperation(transferMoneyCommand2);
        System.out.println(transferMoneyCommand3);
        moneyTransfer.transferMoneyOperation(transferMoneyCommand3);
        System.out.println(transferMoneyCommand4);
        moneyTransfer.transferMoneyOperation(transferMoneyCommand4);
        System.out.println(transferMoneyCommand5);
        moneyTransfer.transferMoneyOperation(transferMoneyCommand5);
        System.out.println(transferMoneyCommand6);
        moneyTransfer.transferMoneyOperation(transferMoneyCommand6);
        System.out.println(transferMoneyCommand7);
        moneyTransfer.transferMoneyOperation(transferMoneyCommand7);
        System.out.println(transferMoneyCommand8);
        moneyTransfer.transferMoneyOperation(transferMoneyCommand8);

        System.out.println("==========After Transferring State============================================================");
        System.out.println(mike);
        System.out.println(jack);
        System.out.println(anna);
        System.out.println(jimmy);

        System.out.println("==========Undo Operation======================================================================");
        moneyTransfer.undoMoneyOperation();
        moneyTransfer.undoMoneyOperation();
//        moneyTransfer.undoMoneyOperation();
//        moneyTransfer.undoMoneyOperation();
//        moneyTransfer.undoMoneyOperation();
//        moneyTransfer.undoMoneyOperation();
//        moneyTransfer.undoMoneyOperation();
//        moneyTransfer.undoMoneyOperation();
//        moneyTransfer.undoMoneyOperation();

        System.out.println("==========After Undo State====================================================================");
        System.out.println(mike);
        System.out.println(jack);
        System.out.println(anna);
        System.out.println(jimmy);
        
    }

}