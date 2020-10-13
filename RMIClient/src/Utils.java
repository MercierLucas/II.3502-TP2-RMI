public class Utils
{
    public static int tryParse(String value)
    {
        int val;
        // Integer doesn't have native implementation for tryparse
        try
        {
            val = Integer.parseInt(value);
        }
        catch (Exception e)
        {
            val = 0;
        }
        return val;
    }
}
