package client;

import Ice.StringHolder;
import client.generated.Bank.*;

import java.util.Scanner;

public class Client {
    public static void
    main(String[] args)
    {
        int status = 0;
        Ice.Communicator ic = null;
        Scanner scanIn = new Scanner(System.in);
        String choice;

        try {
            while(true) {
                System.out.println("1 - stworz konto, 2 - ! usun konto, 3 - zaloguj sie, q - zakoncz");
                choice = scanIn.nextLine();

                ic = Ice.Util.initialize(args);
                Ice.ObjectPrx base = ic.stringToProxy("managment/BankManager:tcp -h 127.0.0.1 -p 10000");
                BankManagerPrx bankManager = BankManagerPrxHelper.checkedCast(base);

                if (choice.equals("1")) {
                    if (bankManager == null)
                        throw new Error("Invalid proxy");

                    System.out.println("Podaj dane konta. Imie, nazwisko, narodowosc oraz losowy numer ktorego i tak nikt nie sprawdzi");
                    String firstName = scanIn.nextLine();
                    String lastName = scanIn.nextLine();
                    String nationality = scanIn.nextLine();
                    String nationalIDNumber = scanIn.nextLine();

                    System.out.println("Premium? t/n");
                    String premium = scanIn.nextLine();

                    accountType accType;
                    if(premium.equals("y")){
                        accType = accountType.PREMIUM;
                    } else if (premium.equals("n")){
                        accType = accountType.SILVER;
                    } else {
                        System.out.println("Lol, nie ma tak");
                        continue;
                    }

                    PersonalData personalData = new PersonalData(firstName, lastName, nationality, nationalIDNumber);

                    bankManager.createAccount(personalData, accType, null);
                } else if (choice.equals("2")) {
                    System.out.println("usun konto");
                } else if (choice.equals("3")) {
                    System.out.println("Podaj id konta");
                    String accNumber = scanIn.nextLine();

                    try {
                        Ice.ObjectPrx accountServantPrx = ic.stringToProxy(accNumber + ":tcp -h 127.0.0.1 -p 10000");
                        AccountPrx acc = AccountPrxHelper.checkedCast(accountServantPrx);

                        System.out.println("1 - stan konta, 2 - numer konta, 3 - zrob przelew");
                        choice = scanIn.nextLine();
                        if (choice.equals("1")) {
                            System.out.println("Stan k¹ta: " + acc.getBalance());
                        } else if (choice.equals("2")) {
                            System.out.println("Number konta: " + acc.getAccountNumber());
                        } else if (choice.equals("3")) {
                            System.out.println("Podaj id konta na ktore chcesz przelac piniondz, oraz ilosc owego");
                            String receiverAccNumber = scanIn.nextLine();
                            int amount = Integer.parseInt(scanIn.nextLine());

                            try{
                                acc.transferMoney(receiverAccNumber, amount);
                            } catch (IncorrectAccountNumber incorrectAccountNumber){
                                System.out.println("Konto na ktore chcesz przelac pineniondz nie isteniej!");
                            } catch (IncorrectAmount incorrectAmount){
                                System.out.println("Nie masz " + amount + " z³ota na koncie!");
                            }
                        }
                    } catch (Ice.ProxyParseException e){
                        System.out.println("Konto o wskazanym id nie istnieje!");
                    }
                } else if (choice.equals("q")){
                    break;
                }
            }
        } catch (Ice.LocalException e) {
            e.printStackTrace();
            status = 1;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            status = 1;
        }
        if (ic != null) {
            // Clean up
            //
            try {
                ic.destroy();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                status = 1;
            }
        }
        System.exit(status);
    }
}