import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Promotion extends UnicastRemoteObject implements PromotionInterface
{
    private List<Student> _students;

    public Promotion() throws java.rmi.RemoteException
    {
        _students = new ArrayList<>();

        add_student("Lucas",22,1);
    }

    @Override
    public void add_student(String name, int age, int id) throws RemoteException
    {
        _students.add(new Student(name, age, id));
    }

    @Override
    public String list_students() throws RemoteException
    {
        StringBuilder builder = new StringBuilder();

        for(Student student : _students)
        {
            builder.append("- "+student.get_name() +" \n");
        }
        return  builder.toString();
    }

    @Override
    public double promotion_score() throws RemoteException
    {
        if(_students.size() == 0) return 0;

        double average = 0;
        for(Student student : _students)
        {
            average += student.get_average();
        }
        return average/_students.size();
    }

    @Override
    public StudentInterface get_student(String name) throws RemoteException
    {
        for (Student student : _students)
        {
            if(student.get_name().equals(name))
            {
                return (StudentInterface)student;
            }
        }
        return null;
    }
}
