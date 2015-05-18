package server;

public class Server extends Thread {

    private Ice.Communicator ic = null;
    private String[] args;

    public Server(String[] args) {
        this.args = args;
    }

    @Override
    public void run() {
        try {
            ic = Ice.Util.initialize(args);

            Ice.ObjectAdapter adapter = ic.createObjectAdapter("generated");
            adapter.add(new BankManagerImpl(), ic.stringToIdentity("BankManager"));
            adapter.addServantLocator(new Evictor(2), "Accounts");
            adapter.activate();

            ic.waitForShutdown();
        } finally {
            if(ic != null) {
                ic.destroy();
            }
        } //chuj
    }

    public Ice.Communicator getIc() {
        return ic;
    }

}
