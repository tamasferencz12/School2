//dotnet new console --framework net7.0
using System.Globalization;
using System.Numerics;

namespace Rac;

class Program
{
    static void Main(string[] args)
    {
        Thread.CurrentThread.CurrentCulture = new CultureInfo("en-US");
        try
        {
            Rac a = new Rac(1, 2);
            Rac b = new Rac(1, 2);

            Console.WriteLine($"a = {a}, b = {b}");
            Console.WriteLine("-------------------------------");
            Console.WriteLine($"a + b = {a + b}");
            Console.WriteLine($"a - b = {a - b}");
            Console.WriteLine($"a * b = {a * b}");
            Console.WriteLine($"a / b = {a / b}");

        }
        catch (Exception)
        {
            Console.WriteLine("Divided by 0!");
        }
    }
}

