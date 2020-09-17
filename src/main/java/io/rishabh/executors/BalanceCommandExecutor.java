package io.rishabh.executors;

import io.rishabh.model.Command;
import io.rishabh.other.Database;

public class BalanceCommandExecutor extends CommandExecutors {

    private static final String BALANCE = "Balance";

    public BalanceCommandExecutor(Database database){
        super(database);
    }

    @Override
    public boolean isApplicable(Command command) {
        return command.getName().equals(BALANCE);
    }

    @Override
    protected String executeValidCommand(Command command) {
        String userName = command.getParams().get(0);
        return database.getUserBalance(userName).toString();
    }

    @Override
    protected boolean isValid(Command command) {
        return command.getParams().size() ==1;
    }
}
