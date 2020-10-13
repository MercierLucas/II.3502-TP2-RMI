import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainMenu
{
    private static PromotionInterface _promotion;

    public MainMenu(PromotionInterface promotion)
    {
        _promotion = promotion;
    }

    public static void show()
    {
        Boolean returnBack = false;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (!returnBack)
        {
            StringBuilder builder = new StringBuilder();
            builder.append("Welcome to the student management server \n");
            builder.append("- What do you want to do? \n");
            builder.append("1) Add student \n");
            builder.append("2) Search for student \n");
            builder.append("3) List all students \n");
            builder.append("4) Compute promotion score \n");
            builder.append("5) Exit \n");

            System.out.println(builder.toString());

            try
            {
                System.out.print(">");
                String choice = br.readLine().trim();

                switch (Utils.tryParse(choice))
                {
                    default:
                        System.out.println("Invalid command");
                        break;
                    case 1:
                        createStudent();
                        break;

                    case 2:
                        getStudent();
                        break;
                    case 3:
                        listStudents();
                        break;

                    case 4:
                        getPromotionScore();
                        break;

                    case 5:
                        returnBack = true;
                        break;
                }
            }
            catch (Exception e)
            {

            }
        }
    }
    private static void getPromotionScore()
    {
        try {
            System.out.println("Promotion average: "+_promotion.promotion_score());
        }
        catch (Exception e)
        {
            System.out.println("Error while retrieving exams data");
        }
    }

    private static void listStudents()
    {
        try
        {
            System.out.println(_promotion.list_students());
        }
        catch (Exception e)
        {
            System.out.println("Error while retrieving student list ");
        }
    }

    private static void createStudent()
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            System.out.print("Student name:");
            String name = br.readLine();

            System.out.print("Student age:");
            int age = Utils.tryParse(br.readLine());

            System.out.print("Student id:");
            int id = Utils.tryParse(br.readLine());

            _promotion.add_student(name, age, id);
            System.out.print("-- Student added");

        }
        catch (Exception e)
        {
            System.out.println("Error while creating student.");
        }
    }

    private static void getStudent()
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            System.out.print("Student name:");
            String name = br.readLine();

            StudentInterface student = _promotion.get_student(name);

            if(student != null)
            {
                System.out.println(student.get_infos());
                StudentMenu studentMenu = new StudentMenu(student);
                studentMenu.show();
            }
            else
            {
                System.out.println("Student "+name +" not found.");
            }
        }
        catch (Exception e)
        {
            System.out.println("Error while retrieving student " +e.getMessage());
        }
    }

}
