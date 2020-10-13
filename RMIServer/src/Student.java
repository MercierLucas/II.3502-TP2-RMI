import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Student extends UnicastRemoteObject implements java.io.Serializable, StudentInterface
{
    private String _name;
    private int _age;
    private int _id;

    private List<Exam> _exams;

    public Student(String name, int age, int id) throws java.rmi.RemoteException
    {
        _name = name;
        _age = age;
        _id = id;

        _exams = new ArrayList<>();

        // test exams

        // _exams.add(new Exam("English",20,0.5));
        // _exams.add(new Exam("Maths",15,0.5));
    }

    public String print_exams() throws java.rmi.RemoteException
    {
        StringBuilder builder = new StringBuilder();

        for(Exam exam : _exams)
        {
            builder.append(exam.get_subject()+" grade: "+exam.get_grade() +" \n");
        }
        return  builder.toString();
    }

    public String get_infos() throws java.rmi.RemoteException
    {
        StringBuilder builder = new StringBuilder();

        builder.append(" -----| "+_name +" |----- \n");
        builder.append("- id: "+_id +"\n");
        builder.append("- age: "+_age +"\n");
        builder.append("- Average: "+get_average() +"\n");

        return builder.toString();
    }

    @Override
    public double get_average() throws RemoteException
    {
        double average = 0;

        for(Exam exam : _exams)
        {
            average += exam.get_grade() * exam.get_coefficient();
        }

        return average;
    }

    @Override
    public void add_exam(String subject, int grade, double coefficient) throws RemoteException
    {
        _exams.add(new Exam(subject, grade, coefficient));
    }

    public String get_name() {
        return _name;
    }
}
