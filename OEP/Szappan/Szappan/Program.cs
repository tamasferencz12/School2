using System;
namespace Dispenser
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Dispenser dispenser = new Dispenser(100, 5);
            Console.WriteLine($"Actual content after creation: {dispenser.Actual}");
            dispenser.Fill();
            Console.WriteLine($"Actual content after filling: {dispenser.Actual}");
            for (int i = 0; i < 3; i++)
            {
                dispenser.Press();
            }
            Console.WriteLine($"Actual content after pressing 3 times: {dispenser.Actual}");
        }
    }
}

