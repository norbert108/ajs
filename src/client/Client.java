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
        try {
            System.out.println("1 - stworz konto, 2 - usun konto, 3 - zaloguj sie");
            int choice = System.in.read();

            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy("managment/BankManager:tcp -h 127.0.0.1 -p 10000");
            BankManagerPrx bankManager = BankManagerPrxHelper.checkedCast(base);

            if (choice == (int)'1'){
                if (bankManager == null)
                    throw new Error("Invalid proxy");

                System.out.println("Podaj dane konta. Imie, nazwisko, narodowosc, losowy numer ktorego i tak nikt nie sprawdzi");
                Scanner scanIn = new Scanner(System.in);
                scanIn.nextLine();
                String firstName = scanIn.nextLine();
                String lastName = scanIn.nextLine();
                String nationality = scanIn.nextLine();
                String nationalIDNumber = scanIn.nextLine();

                PersonalData personalData = new PersonalData(firstName, lastName, nationality, nationalIDNumber);

                bankManager.createAccount(personalData, accountType.SILVER, null);
            } else if (choice == (int)'2'){
                System.out.println("usun konto");
            } else if (choice == (int)'3'){
                System.out.println("Podaj nr konta");
                Scanner scanIn = new Scanner(System.in);
                scanIn.nextLine();
                String accNumber = scanIn.nextLine();


                Ice.ObjectPrx evictor = ic.stringToProxy("Bank:tcp -h 127.0.0.1 -p 10000");
                Ice.Identity id = new Ice.Identity(accNumber, "");

                Account acc = (Account)evictor.ice_getLocator().begin_findObjectById(id);
                System.out.println(acc.getBalance());

            } else {
                System.exit(1);
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