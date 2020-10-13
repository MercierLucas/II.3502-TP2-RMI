import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StudentManager extends UnicastRemoteObject implements java.io.Serializable, PromotionInterface
{
    private Promotion _promotion;

    public StudentManager() throws java.rmi.RemoteException
    {
        _promotion = new Promotion();
    }

    // Promotion
    @Override
    public void add_student(String name, int age, int id) throws RemoteException
    {
        _promotion.add_student(name, age, id);
    }

    @Override
    public StudentInterface get_student(String name) throws RemoteException
    {
        return _promotion.get_student(name);
    }

    @Override
    public String list_students() throws RemoteException {
        return _promotion.list_students();
    }

    @Override
    public double promotion_score() throws RemoteException
    {
        return _promotion.promotion_score();
    }
}
