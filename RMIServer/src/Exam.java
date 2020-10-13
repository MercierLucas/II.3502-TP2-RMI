public class Exam implements java.io.Serializable
{
    private String _subject;
    private int _grade;
    private double _coefficient;

    public String get_subject() {
        return _subject;
    }

    public int get_grade() {
        return _grade;
    }

    public double get_coefficient()
    {
        return _coefficient;
    }

    public Exam(String subject, int grade, double coefficient)
    {
        _subject = subject;
        _grade = grade;
        _coefficient = coefficient;
    }
}
