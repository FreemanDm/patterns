package com.freeman.patterns.command.bankoperations.commands;

public interface Command {
    void execute();
    void undo();
}
