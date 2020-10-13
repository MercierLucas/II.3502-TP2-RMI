public interface StudentInterface extends java.rmi.Remote
{
    public void add_exam(String subject, int grade, double coefficient) throws java.rmi.RemoteException;

    public String print_exams() throws java.rmi.RemoteException;

    public String get_infos() throws java.rmi.RemoteException;

    public double get_average() throws java.rmi.RemoteException;
}
