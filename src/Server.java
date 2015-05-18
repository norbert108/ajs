public class Server
{

    public void t1(String[] args)
    {
        int status = 0;
        Ice.Communicator ic = null;

        try
        {
            ic = Ice.Util.initialize(args);

            Ice.ObjectAdapter adapter = ic.createObjectAdapter("Adapter11");

            Ice.ServantLocator mylocator = new Evictor("A");

            adapter.add(hs1, ic.stringToIdentity("sr1"));
            adapter.add(hs2, ic.stringToIdentity("sr2"));
            adapter.add(hs1, ic.stringToIdentity("sr3"));

            adapter.addDefaultServant(hs3, "k1");

            adapter.activate();

            System.out.println("Entering event processing loop...");

            ic.waitForShutdown();
        }
        catch (Exception e)
        {
            System.err.println(e);
            status = 1;
        }
        if (ic != null)
        {
            // Clean up
            //
            try
            {
                ic.destroy();
            }
            catch (Exception e)
            {
                System.err.println(e);
                status = 1;
            }
        }
        System.exit(status);
    }


    public static void main(String[] args)
    {
        Server app = new Server();
        app.t1(args);
    }
}
