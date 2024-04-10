using System;

namespace _08gyakConsole
{
    public class Program
    {
        static void Main(string[] args)
        {
            Garden garden = new Garden(5);
            Gardener gardener = new Gardener(garden);

            gardener.Garden.Plant(1, Tulip.Instance());
            gardener.Garden.Plant(2, Pea.Instance());
            gardener.Garden.Plant(3, Potato.Instance());
            gardener.Garden.Plant(4, Rose.Instance());

            foreach (var item in gardener.Garden.CanHarvest(7))
            {
                Console.WriteLine($"Parcel number: {item}");
            }

            for (int i = 0; i < 3; i++)
            {
                Console.WriteLine(garden[i].Content);
            }
        }
    }
}