package io.rishabh.executors;

import io.rishabh.model.Command;
import io.rishabh.other.Database;

abstract public class CommandExecutors {
    protected Database database;

    public CommandExecutors(Database database){
        this.database = database;
    }

    public String execute(final Command command){
        if(!isValid(command)){
            return "Invalid Command";
        }
        return executeValidCommand(command);
    }

    public abstract boolean isApplicable(final Command command);

    protected abstract String executeValidCommand(final Command command);

    protected abstract boolean isValid(final Command command);
}
