using TextFile;
using Circle_Point;

namespace Circle_Point
{
    public class Program
    {
        static void Main(string[] args)
        {
            try {
                TextFileReader reader = new TextFileReader("input.txt");
                reader.ReadDouble(out double a);
                reader.ReadDouble(out double b);
                reader.ReadDouble(out double c);
                Circle circle = new(new Point(a, b), c);

                reader.ReadInt(out int n);
                Point[] x = new Point[n];
                for (int i = 0; i < n; i++)
                {
                    reader.ReadDouble(out a);
                    reader.ReadDouble(out b);
                    x[i] = new Point(a, b);
                }
                int db = 0;
                foreach (var item in x)
                {
                    if (circle.Contains(item))
                    {
                        db++;
                    }
                }
                Console.WriteLine($"Number of points whithin the circle: {db}");
            }
            catch(System.IO.FileNotFoundException)
            {
                Console.WriteLine("File not found!");
            }
            catch (Circle.WrongRadiusExeption)
            {
                Console.WriteLine("Radius can not be negative!");
            }
        }
    }
}