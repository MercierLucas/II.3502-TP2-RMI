import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;

public class StudentManagementClient
{
    private static PromotionInterface _promotion;

    public static void main(String args[])
    {
        try
        {
            _promotion = (PromotionInterface) Naming.lookup("rmi://localhost:12345/studentManagementServer");
            MainMenu mainMenu = new MainMenu(_promotion);

            mainMenu.show();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
