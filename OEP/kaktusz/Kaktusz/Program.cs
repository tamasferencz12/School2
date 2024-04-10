using System;
using Kaktusz;

namespace Kaktusz
{
    public class Kaktusz
    {
        private string name, country, color;
        private int size;

        public int Size { get { return size; } set { size = value; } }
        public string Name { get { return name; } set { name = value; } }
        public string Country { get { return country; } set { country = value; } }
        public string Color { get { return color; } set { color = value; } }

        public Kaktusz(int size, string name, string country, string color)
        {
            this.size = size;
            this.name = name;
            this.country = country;
            this.color = color;
        }
    }

    internal class Program
    {
        static void Main(string[] args)
        {
            TextFileReader reader = new TextFileReader("in.txt");
            StreamWriter writer1 = new StreamWriter("out1.txt");
            StreamWriter writer2 = new StreamWriter("out2.txt");
            while (ReadKaktusz(reader, out Kaktusz kaktusz))
            {
                if (kaktusz.Color == "piros")
                {
                    writer1.WriteLine(kaktusz.Name);
                }
                if (kaktusz.Country == "mexico")
                {
                    writer2.WriteLine(kaktusz.Name);
                }
            }
        }

        static bool ReadKaktusz(TextFileReader reader, out Kaktusz kaktusz)
        {
            kaktusz = new Kaktusz(0, string.Empty, string.Empty, string.Empty);
            bool l = reader.ReadString(out string name);
            kaktusz.Name = name;
            reader.ReadString(out string country);
            kaktusz.Country = country;
            reader.ReadString(out string color);
            kaktusz.Color = color;
            reader.ReadInt(out int size);
            kaktusz.Size = size;

            return l;
        }
    }

}