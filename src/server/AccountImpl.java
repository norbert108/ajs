package server;

import Ice.Current;
import client.generated.Bank.*;
import server.generated.Bank.*;
import server.generated.Bank.AccountPrx;
import server.generated.Bank.AccountPrxHelper;
import server.generated.Bank.IncorrectAccountNumber;
import server.generated.Bank.IncorrectAmount;
import server.generated.Bank.PersonalData;
import server.generated.Bank._AccountDisp;
import server.generated.Bank.accountType;

public class AccountImpl extends _AccountDisp {
    private PersonalData personalData;
    private accountType type;
    private String accountID;

    Integer balance;

    public AccountImpl(PersonalData personalData, accountType type, String accountID){
        this.personalData = personalData;
        this.type = type;
        this.accountID = accountID;
    }

    @Override
    public int getBalance(Current __current) {
        return balance;
    }

    @Override
    public String getAccountNumber(Current __current) {
        return null;
    }

    @Override
    public void transferMoney(String accountNumber, int amount, Current __current) throws IncorrectAccountNumber, IncorrectAmount {
//        Ice.ObjectPrx proxy = __current.adapter.getCommunicator().stringToProxy(accountNumber + ":default -p 10000");
//        AccountPrx accountPrx = AccountPrxHelper.checkedCast(proxy);
//
//        System.out.println(accountPrx.getBalance());
    }

    private void setBalance(Integer balance){
        this.balance = balance;
    }

    public void addMoney(Integer amount){
        this.balance += amount;
    }
}
