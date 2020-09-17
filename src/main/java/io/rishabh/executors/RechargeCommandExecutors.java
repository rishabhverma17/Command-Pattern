package io.rishabh.executors;

import io.rishabh.model.Command;
import io.rishabh.other.Database;
import io.rishabh.other.RechargeProvider;

public class RechargeCommandExecutors extends CommandExecutors {

    private static final String RECHARGE = "Recharge";
    private RechargeProvider rechargeProvider;

    public RechargeCommandExecutors(Database database, RechargeProvider rechargeProvider){
        super(database);
        this.rechargeProvider = rechargeProvider;
    }

    @Override
    public boolean isApplicable(Command command) {
        return command.getName().equals(RECHARGE);
    }

    @Override
    protected String executeValidCommand(Command command) {
        String user = command.getParams().get(0);
        Integer rechargeAmount = Integer.parseInt(command.getParams().get(1));
        Integer userBalance = database.getUserBalance(user);
        if(rechargeAmount > userBalance){
            return "Insufficient Balance";
        }
        rechargeProvider.recharge(user,rechargeAmount);
        return "Recharge Done.";
    }

    @Override
    protected boolean isValid(Command command) {
        return command.getParams().size() == 2;
    }
}
