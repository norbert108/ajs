package server;

import Ice.Current;
import Ice.StringHolder;
import server.generated.Bank.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BankManagerImpl extends _BankManagerDisp {
    private Map<String, AccountImpl> registeredAccounts;

    public BankManagerImpl(){
        super();
        registeredAccounts = new HashMap<>();
    }

    @Override
    public void createAccount(PersonalData data, accountType type, StringHolder accountID, Current __current) throws IncorrectData, RequestRejected {
        Account account = new AccountImpl(data, type, accountID.value);

        try{
            File accountFile = new File("./" + accountID.value);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(accountFile));
            oos.writeObject(account);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeAccount(String accountID, Current __current) throws IncorrectData, NoSuchAccount {

    }
}
