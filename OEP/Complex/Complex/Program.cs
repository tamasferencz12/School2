using System.Globalization;

namespace Complex
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Thread.CurrentThread.CurrentCulture = new CultureInfo("en-US");
            try
            {
                Complex a = new Complex(-3.0, 2.0);
                Complex b = new Complex(-1.3, 2.5);

                Console.WriteLine($"a = {a}, b={b}");
                Console.WriteLine($"a+b = {a + b}");
                Console.WriteLine($"a-b = {a - b}");
                Console.WriteLine($"a*b = {a * b}");
                Console.WriteLine($"a/b = {a / b}");

            }
            catch (Exception a)
            {
                Console.WriteLine("Divided by 0!");
            }
        }
    }
}