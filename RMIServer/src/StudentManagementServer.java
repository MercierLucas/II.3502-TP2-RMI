import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;


public class StudentManagementServer extends UnicastRemoteObject
{

    public StudentManagementServer() throws java.rmi.RemoteException
    {
        super();
    }

    public static void main(String args[])
    {

        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StudentManager manager = new StudentManager();

            // start RMIRegistry: port 12345
            // Alternative: start rmiregistry in terminal !
            java.rmi.registry.LocateRegistry.createRegistry(12345);

            // register the object
            Naming.rebind("rmi://localhost:12345/studentManagementServer",manager);

            System.out.println("StudentManagementServer bound in registry");

            try
            {
                System.out.println("");
                String choice = br.readLine().trim();
            }
            catch (Exception e)
            {

            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


}
