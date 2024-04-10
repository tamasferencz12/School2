using System;

namespace Weather
{
    public class Weather
    {
        public double Temperature { get; set; }

        public Weather(double temperature)
        {
            Temperature = temperature;
        }
    }

    internal class Program
    {
        static void Main(string[] args)
        {
            string inputFile = args[0];
            TextFileReader reader = new TextFileReader(inputFile);

            int db = 0;
            double s = 0.0;
            double e = 0.0;
            bool l = true;

            while (ReadWeather(reader, out Weather weather))
            {
                if (weather.Temperature < 0)
                {
                    e = weather.Temperature;
                    break;
                }
                else
                {
                    s += weather.Temperature;
                    db++;
                }
            }

            while (ReadWeather(reader, out Weather weather) && weather.Temperature < 0)
            {

                l = l && e < 0;

                if (weather.Temperature < e)
                {
                    e = weather.Temperature;
                }
            }

            double averageBeforeFreezing = db > 0 ? s / db : 0;

            try
            {
                FileStream stream = new FileStream("out.txt", FileMode.OpenOrCreate);
                using (StreamWriter writer = new StreamWriter(stream))
                {
                    writer.WriteLine(averageBeforeFreezing);

                    if (l)
                    {
                        writer.WriteLine("True");
                    }
                    else
                    {
                        writer.WriteLine("False");
                    }

                    writer.WriteLine(e);
                }
            }
            catch (Exception exp)
            {
                Console.Write(exp.Message);
            }

        }

        static bool ReadWeather(TextFileReader reader, out Weather weather)
        {
            string line;

            if (reader.ReadString(out line))
            {
                if (double.TryParse(line, out double temperature))
                {
                    weather = new Weather(temperature);
                    return true;
                }
            }
            weather = null;
            return false;
        }
    }
}