package com.freeman.patterns.command.bankoperations.invokers;

import com.freeman.patterns.command.bankoperations.Person;
import com.freeman.patterns.command.bankoperations.commands.Command;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

@Data
@NoArgsConstructor
public class MoneyTransfer {

    private Command transferCommand;
    private LinkedList<Command> undoCommands = new LinkedList<>();
    private int operationID;
    private Long amountOfMoney;
    private Person sender;
    private Person receiver;

    public MoneyTransfer(Command transferCommand, int operationID, Long amountOfMoney, Person sender, Person receiver) {
        this.transferCommand = transferCommand;
        this.operationID = operationID;
        this.amountOfMoney = amountOfMoney;
        this.sender = sender;
        this.receiver = receiver;
    }

    public void transferMoneyOperation(MoneyTransfer moneyTransfer){
        transferCommand.execute();
        undoCommands.addFirst(transferCommand);
        sender.setAmountOfMoneyOnTheCount(sender.getAmountOfMoneyOnTheCount() - amountOfMoney);
        receiver.setAmountOfMoneyOnTheCount(receiver.getAmountOfMoneyOnTheCount() + amountOfMoney);
        System.out.println(moneyTransfer);
        System.out.println("Count of the " + sender.getName() + ": "
                        + sender.getAccountId() + " = " + sender.getAmountOfMoneyOnTheCount()
                        + " | "
                        + "Count of the " + receiver.getName() + ": "
                        + receiver.getAccountId() + " = " + receiver.getAmountOfMoneyOnTheCount()
                        + " | ");
    }

    public void undoMoneyOperation(){
        if (undoCommands.size() != 0){
            undoCommands.removeFirst().undo();
        } else {
            System.out.println("Stack for 'Undo' is empty");
        }
    }

    @Override
    public String toString() {
//        StringBuffer stringBuff = new StringBuffer();
//        MoneyTransfer_old moneyTransfer;
//        if (moneyTransfer.sendMoneyOperation())
//        stringBuff.append()
//        for (int i = 0; i < onCommands.length; i++) {
//            stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName() + "     " + offCommands[i].getClass().getName() + "\n");
//        }
//        stringBuff.append("[undo] " + undoCommand.getClass().getName());
//        return stringBuff.toString();
        return  "Operation ID: " + operationID + " (" + sender.getName()
                + " sent " + amountOfMoney + " to " + receiver.getName() + ")";
    }
}
