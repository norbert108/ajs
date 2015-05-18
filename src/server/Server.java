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

            Ice.ObjectAdapter adapter = ic.createObjectAdapterWithEndpoints("Bank", "default -p 10000");
            adapter.add(new BankManagerImpl(), ic.stringToIdentity("managment/BankManager"));
            adapter.addServantLocator(new Evictor(2), "");
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
