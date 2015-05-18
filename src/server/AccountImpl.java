package server;

import Ice.Current;
import server.generated.Bank.*;

public class AccountImpl extends _AccountDisp {
    private PersonalData personalData;
    private accountType type;
    private String accountID;

    public AccountImpl(PersonalData personalData, accountType type, String accountID){
        this.personalData = personalData;
        this.type = type;
        this.accountID = accountID;
    }

    @Override
    public int getBalance(Current __current) {
        return 0;
    }

    @Override
    public String getAccountNumber(Current __current) {
        return null;
    }

    @Override
    public void transferMoney(String accountNumber, int amount, Current __current) throws IncorrectAccountNumber, IncorrectAmount {

    }
}
