package com.freeman.patterns.command.bankoperations.invokers;

import com.freeman.patterns.command.bankoperations.Person;
import com.freeman.patterns.command.bankoperations.commands.Command;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoneyTransfer {

    private Command transferCommand;
    private LinkedList<Command> undoCommands = new LinkedList<>();


    public void transferMoneyOperation(Command transferCommand){
        transferCommand.execute();
        undoCommands.addFirst(transferCommand);
    }

    public void undoMoneyOperation(){
        if (undoCommands.size() != 0){
            System.out.println(undoCommands.getFirst());
            undoCommands.removeFirst().undo();

        } else {
            System.out.println("Stack for 'Undo' is empty");
        }
    }

    @Override
    public String toString() {
        return "MoneyTransfer{" +
                "transferCommand=" + transferCommand +
                ", undoCommands=" + undoCommands +
                '}';
    }
}
