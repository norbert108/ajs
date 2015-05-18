package server;

import Ice.Current;
import Ice.StringHolder;
import server.generated.Bank.*;

import java.io.*;
import java.util.*;

import java.security.MessageDigest;
import java.util.LinkedList;

public class BankManagerImpl extends _BankManagerDisp {
    private Map<String, Account> registeredAccounts;

    public BankManagerImpl(){
        super();
        registeredAccounts = new HashMap<>();
    }

    //TODO: sprawdzanie czy konto nie istnieje
    @Override
    public void createAccount(PersonalData data, accountType type, StringHolder accountID, Current __current) throws IncorrectData, RequestRejected {
        try{
            String generatedAccountID = generateAccountID(data);
            accountID.value = generatedAccountID;

            Account account = new AccountImpl(data, type, generatedAccountID);

            // create account file
            File accountFile = new File("./" + generatedAccountID);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(accountFile));
            oos.writeObject(account);

            registeredAccounts.put(generatedAccountID, account);

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void removeAccount(String accountID, Current __current) throws IncorrectData, NoSuchAccount {

    }

    private String generateAccountID(PersonalData data){
        String accId = data.firstName + data.lastName + data.nationalIDNumber + data.nationality;
        StringBuilder digest = new StringBuilder();

        for (int i = 0; i < 10; i++){
            digest.append(accId.charAt((i * 15) % accId.length()));
        }
        return digest.toString();
    }
}
