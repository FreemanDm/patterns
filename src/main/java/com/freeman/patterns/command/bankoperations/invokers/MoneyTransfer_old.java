package com.freeman.patterns.command.bankoperations.invokers;

import com.freeman.patterns.command.bankoperations.commands.Command;
import lombok.Data;

import java.util.LinkedList;

@Data
public class MoneyTransfer_old {

    private Command sendCommand, receiveCommand;
    private LinkedList<Command> undoCommands = new LinkedList<>();
    private int operationID;
//    private int receiveOperationID;
    private Long amountOfMoney;

    public void sendMoneyOperation(int operationID, Command sendCommand, Long amountOfMoney){
        this.sendCommand = sendCommand;
        this.operationID = operationID;
        this.amountOfMoney = amountOfMoney;
        sendCommand.execute();
//        System.out.println(operationID);
        undoCommands.addFirst(sendCommand);
    }

    public void receiveMoneyOperation(int operationID, Command receiveCommand, Long amountOfMoney){
        this.receiveCommand = receiveCommand;
        this.operationID = operationID;
        this.amountOfMoney = amountOfMoney;
        receiveCommand.execute();
        undoCommands.addFirst(receiveCommand);
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
        return  "Operation ID: " + operationID + ", amount of money: " + amountOfMoney;
    }
}
