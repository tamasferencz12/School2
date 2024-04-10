using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Channels;
using System.Threading.Tasks;

namespace MapS
{
    internal class Menu
    {
        public readonly Map map = new Map();
        public void Run()
        {
            int v;
            do
            {
                v = GetMenuPoint();
                switch (v)
                {
                    case 1:
                        map.SetEmpty();
                        break;
                    case 2:
                        Console.WriteLine($"Number of elements: {map.Count()}");
                        break;
                    case 3:
                        Console.Write("key: ");
                        int.TryParse(Console.ReadLine(), out int key);
                        Console.Write("data: ");
                        string data = Console.ReadLine()!;
                        try
                        {
                            map.Insert(new Map.Item(key, data));
                        }
                        catch (Map.AlreadyExistingKeyException)
                        {
                            Console.WriteLine($"There is already an element with the key {key}");
                        }
                        break;
                    case 4:
                        Console.Write("key: ");
                        int.TryParse(Console.ReadLine(), out key);
                        try
                        {
                            map.Remove(key);
                        }
                        catch (Map.NonExistringException)
                        {
                            Console.WriteLine($"There is no element with the key {key}");
                        }
                        break;
                    case 5:
                        Console.Write("key: ");
                        int.TryParse(Console.ReadLine(), out key);
                        if (map.In(key))
                        {
                            Console.WriteLine($"Map contains an element with the key {key}");
                        }
                        else
                        {
                            Console.WriteLine($"Map does not contain an element with the key {key}");
                        }
                        break;
                    case 6:
                        Console.Write("key: ");
                        int.TryParse(Console.ReadLine(), out key);
                        try
                        {
                            Console.WriteLine($"Data of the element with the key {key} is {map.Select(key)}");
                        }
                        catch (Map.NonExistringException)
                        {
                            Console.WriteLine($"There is no element with the key {key}");
                        }
                        break;
                    default:
                        break;
                }
                Console.WriteLine(map.ToString());
            } while (v != 0);
        }
        public static int GetMenuPoint()
        {
            int v;
            do
            {
                Console.WriteLine("\n*******************");
                Console.WriteLine("0. Exit");
                Console.WriteLine("1. SetEmpty");
                Console.WriteLine("2. Number of elements");
                Console.WriteLine("3. Insert");
                Console.WriteLine("4. Remove");
                Console.WriteLine("5. Is it in the map");
                Console.WriteLine("6. Read");
                Console.WriteLine("*********************");
                if (!int.TryParse(Console.ReadLine(), out v))
                {
                    v = -1;
                }
            } while (v < 0 || v > 6);
            return v;
        }
    }
}
