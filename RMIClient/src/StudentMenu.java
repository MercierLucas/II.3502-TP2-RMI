import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StudentMenu
{
    private static StudentInterface _student;

    public StudentMenu(StudentInterface student)
    {
        _student = student;
    }

    public static void show()
    {
        Boolean returnBack = false;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (!returnBack)
        {
            StringBuilder builder = new StringBuilder();
            builder.append("- Student selected, what do you want to do? \n" );
            builder.append("1) Add exam \n");
            builder.append("2) Show exams \n");
            builder.append("3) Compute average \n");
            builder.append("4) Return \n");

            System.out.println(builder.toString());

            try
            {
                System.out.print(">");
                String choice = br.readLine().trim();

                switch (Integer.parseInt(choice))
                {
                    default:
                        returnBack = true;
                        break;
                    case 1:
                        addExam();
                        break;

                    case 2:
                        showExams();
                        break;

                    case 3:
                        getAverage();
                        break;
                }
            }
            catch (Exception e)
            {

            }
        }
    }

    private static void getAverage()
    {
        try {
            System.out.println("Average: "+_student.get_average());
        }
        catch (Exception e)
        {
            System.out.println("Error while retrieving exams data");
        }
    }

    private static void showExams()
    {
        try {
            System.out.println(_student.print_exams());
        }
        catch (Exception e)
        {
            System.out.println("Error while retrieving exams data");
        }

    }

    private static void addExam()
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            System.out.print("Subject:");
            String subject = br.readLine();

            System.out.print("Student grade:");
            int grade = Utils.tryParse(br.readLine());

            System.out.print("coefficient:");
            double coeff = Double.parseDouble(br.readLine());

            _student.add_exam(subject, grade, coeff);
            System.out.print("-- Grade added");

        }
        catch (Exception e)
        {
            System.out.println("Error while creating student.");
        }
    }
}
