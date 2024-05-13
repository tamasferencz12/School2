using Classes;

using System;
using System.Collections.Generic;
using System.IO;
using System.Net.Mail;

namespace Beadando
{
    class Program
    {
        static void Main(string[] args)
        {
            string filePath = "input.txt";

            int preyColoniesCount = 0;
            int predatorColoniesCount = 0;
            bool alive = false;
            bool countDouble = false;
            int predatorColonyLetszamSum = 0;

            List<Kolonia> preyColonies = new List<Kolonia>();
            List<Kolonia> predatorColonies = new List<Kolonia>();
            Tundra tundra = new Tundra(1);

            if (filePath != "input.txt")
            {
                throw new Exception("File not found! - try: 'input.txt'");
            }

            using (StreamReader reader = new StreamReader(filePath))
            {

                string? firstLine = reader.ReadLine();
                try
                {
                    if (firstLine != null)
                    {
                        string[] counts = firstLine.Split(' ');
                        preyColoniesCount = int.Parse(counts[0]);
                        predatorColoniesCount = int.Parse(counts[1]);

                        for (int i = 0; i < preyColoniesCount; i++)
                        {
                            string? line = reader.ReadLine();
                            if (line != null)
                            {
                                string[] colonyData = line.Split(' ');

                                if (colonyData.Length >= 3)
                                {
                                    string becenev = colonyData[0];
                                    string faj = colonyData[1];
                                    int letszam = int.Parse(colonyData[2]);

                                    Allat allat = CreateAllatInstance(faj);

                                    Kolonia kolonia = new Kolonia(becenev, letszam, allat, tundra);
                                    kolonia.AllatSG.KoloniaSG = kolonia;
                                    preyColonies.Add(kolonia);

                                }
                                else
                                {
                                    throw new Exception("$Invalid input line for prey colony: { line}");
                                }
                            }
                            else
                            {
                                throw new Exception("End of file reached or error while reading.");
                            }
                        }

                        for (int i = 0; i < predatorColoniesCount; i++)
                        {
                            string? line = reader.ReadLine();
                            if (line != null)
                            {
                                string[] colonyData = line.Split(' ');

                                if (colonyData.Length >= 3)
                                {
                                    string becenev = colonyData[0];
                                    string faj = colonyData[1];
                                    int letszam = int.Parse(colonyData[2]);
                                    predatorColonyLetszamSum += letszam;

                                    Allat allat = CreateAllatInstance(faj);

                                    Kolonia kolonia = new Kolonia(becenev, letszam, allat, tundra);
                                    kolonia.AllatSG.KoloniaSG = kolonia;
                                    predatorColonies.Add(kolonia);
                                }
                                else
                                {
                                    throw new Exception($"Invalid input line for predator colony: {line}");
                                }
                            }
                            else
                            {
                                throw new Exception("End of file reached or error while reading.");
                            }
                        }
                    }
                    else
                    {
                        throw new Exception("Empty or missing first line in the input file.");
                    }
                }
                catch (Exception ex)
                {
                    throw new Exception("First line is null.", ex);
                }
            }
            Console.WriteLine("-------------------------------------------------");
            Console.WriteLine("Zsakmanyallat kolonia(k):");
            foreach (var colony in preyColonies)
            {
                Console.WriteLine($"Becenev: {colony.Becenev}, Allat: {colony.AllatSG.GetType().Name}, Letszam: {colony.Letszam}");
            }

            Console.WriteLine("Ragadozo kolonia(k):");
            foreach (var colony in predatorColonies)
            {
                Console.WriteLine($"Becenev: {colony.Becenev}, Allat: {colony.AllatSG.GetType().Name}, Letszam: {colony.Letszam}");
            }
            Console.WriteLine("-------------------------------------------------");
            Console.WriteLine("\n");


            while (checkAbove4(predatorColonies) && checkDouble(predatorColonies, predatorColonyLetszamSum))
            {
                alive = false;
                countDouble = false;
                Console.WriteLine("------------Zsakmanyallat szaporodik-------------");
                foreach (var allat in preyColonies)
                {
                    if (allat.GetType().Name == "Lemming")
                    {
                        Lemming lemming = (Lemming)allat.AllatSG;
                        lemming.Szaporodik();
                    }
                    if (allat.GetType().Name == "Sarkinyul")
                    {
                        Sarkinyul sarkinyul = (Sarkinyul)allat.AllatSG;
                        sarkinyul.Szaporodik();
                    }
                    if (allat.GetType().Name == "Javorszarvas")
                    {
                        Javorszarvas javorszarvas = (Javorszarvas)allat.AllatSG;
                        javorszarvas.Szaporodik();
                    }
                    Console.WriteLine($"Becenev: {allat.Becenev}, Allat: {allat.AllatSG.GetType().Name}, Letszam: {allat.Letszam}");
                }
                Console.WriteLine("-------------------------------------------------");
                Console.WriteLine("\n");

                Console.WriteLine("------------Zsakmanyallat elvandorol(?)-------------");
                foreach (var allat in preyColonies)
                {
                    if (allat.GetType().Name == "Lemming")
                    {
                        Lemming lemming = (Lemming)allat.AllatSG;
                        lemming.Elvandorol();
                    }
                    if (allat.GetType().Name == "Sarkinyul")
                    {
                        Sarkinyul sarkinyul = (Sarkinyul)allat.AllatSG;
                        sarkinyul.Elvandorol();
                    }
                    if (allat.GetType().Name == "Javorszarvas")
                    {
                        Javorszarvas javorszarvas = (Javorszarvas)allat.AllatSG;
                        javorszarvas.Elvandorol();
                    }
                    Console.WriteLine($"Becenev: {allat.Becenev}, Allat: {allat.AllatSG.GetType().Name}, Letszam: {allat.Letszam}");
                }
                Console.WriteLine("-------------------------------------------------");
                Console.WriteLine("\n");

                Console.WriteLine("--------------Ragadozo szaporodik----------------");
                foreach (var allat in predatorColonies)
                {
                    allat.AllatSG.Szaporodik();
                    Console.WriteLine($"Becenev: {allat.Becenev}, Allat: {allat.AllatSG.GetType().Name}, Letszam: {allat.Letszam}");
                }
                Console.WriteLine("-------------------------------------------------");
                Console.WriteLine("\n");

                Random random = new Random();
                int predatorIndex = random.Next(0, predatorColonies.Count);
                int preyIndex = random.Next(0, preyColonies.Count);

                Kolonia predatorColony = predatorColonies[predatorIndex];
                Kolonia preyColony = preyColonies[preyIndex];

                if (predatorColony != null && preyColony != null)
                {

                    if (predatorColony.AllatSG is Ragadozo && preyColony.AllatSG is Zsakmanyallat)
                    {
                        /*if (predatorColony.AllatSG.GetType().Name == "Jegesmedve" && preyColony.AllatSG.GetType().Name == "Lemming")
                        {

                            Lemming lemming = (Lemming)preyColony.AllatSG;
                            Jegesmedve jegesmedve = (Jegesmedve)predatorColony.AllatSG;
                            lemming.Tamadott(jegesmedve);
                        }
                        if (predatorColony.AllatSG.GetType().Name == "Jegesmedve" && preyColony.AllatSG.GetType().Name == "Sarkinyul")
                        {

                            Sarkinyul sarkinyul = (Sarkinyul)preyColony.AllatSG;
                            Jegesmedve jegesmedve = (Jegesmedve)predatorColony.AllatSG;
                            sarkinyul.Tamadott(jegesmedve);
                        }
                        if (predatorColony.AllatSG.GetType().Name == "Jegesmedve" && preyColony.AllatSG.GetType().Name == "Javorszarvas")
                        {

                            Javorszarvas javorszarvas = (Javorszarvas)preyColony.AllatSG;
                            Jegesmedve jegesmedve = (Jegesmedve)predatorColony.AllatSG;
                            javorszarvas.Tamadott(jegesmedve);
                        }

                        if (predatorColony.AllatSG.GetType().Name == "Hobagoly" && preyColony.AllatSG.GetType().Name == "Lemming")
                        {

                            Lemming lemming = (Lemming)preyColony.AllatSG;
                            Hobagoly hobagoly = (Hobagoly)predatorColony.AllatSG;
                            lemming.Tamadott(hobagoly);
                        }
                        if (predatorColony.AllatSG.GetType().Name == "Hobagoly" && preyColony.AllatSG.GetType().Name == "Sarkinyul")
                        {

                            Sarkinyul sarkinyul = (Sarkinyul)preyColony.AllatSG;
                            Hobagoly hobagoly = (Hobagoly)predatorColony.AllatSG;
                            sarkinyul.Tamadott(hobagoly);
                        }
                        if (predatorColony.AllatSG.GetType().Name == "Hobagoly" && preyColony.AllatSG.GetType().Name == "Javorszarvas")
                        {

                            Javorszarvas javorszarvas = (Javorszarvas)preyColony.AllatSG;
                            Hobagoly hobagoly = (Hobagoly)predatorColony.AllatSG;
                            javorszarvas.Tamadott(hobagoly);
                        }

                        if (predatorColony.AllatSG.GetType().Name == "Sarkiroka" && preyColony.AllatSG.GetType().Name == "Lemming")
                        {

                            Lemming lemming = (Lemming)preyColony.AllatSG;
                            Sarkiroka sarkiroka = (Sarkiroka)predatorColony.AllatSG;
                            lemming.Tamadott(sarkiroka);
                        }
                        if (predatorColony.AllatSG.GetType().Name == "Sarkiroka" && preyColony.AllatSG.GetType().Name == "Sarkinyul")
                        {

                            Sarkinyul sarkinyul = (Sarkinyul)preyColony.AllatSG;
                            Sarkiroka sarkiroka = (Sarkiroka)predatorColony.AllatSG;
                            sarkinyul.Tamadott(sarkiroka);
                        }
                        if (predatorColony.AllatSG.GetType().Name == "Sarkiroka" && preyColony.AllatSG.GetType().Name == "Javorszarvas")
                        {

                            Javorszarvas javorszarvas = (Javorszarvas)preyColony.AllatSG;
                            Sarkiroka sarkiroka = (Sarkiroka)predatorColony.AllatSG;
                            javorszarvas.Tamadott(sarkiroka);
                        }*/
                        Zsakmanyallat zsakmanyallat = (Zsakmanyallat)preyColony.AllatSG;
                        Ragadozo ragadozo = (Ragadozo)predatorColony.AllatSG;
                        zsakmanyallat.Tamadott(ragadozo);

                        Console.WriteLine("--------------Tamadas----------------");
                        Console.WriteLine($"Ragadozo beceneve: {predatorColony.Becenev}, Allat: {predatorColony.AllatSG.GetType().Name}, Letszam: {predatorColony.Letszam}");
                        Console.WriteLine($"Zsakmanyallat becenev: {preyColony.Becenev}, Allat: {preyColony.AllatSG.GetType().Name}, Letszam: {preyColony.Letszam}");
                        Console.WriteLine("-------------------------------------");

                    }
                    else
                    {
                        throw new Exception("Predator or prey is not of the expected type.");
                    }
                }
                else
                {
                    throw new Exception("Predator or prey colony is null.");
                }

                tundra.IncrementKor();
                foreach (var kolonia in predatorColonies)
                {
                    kolonia.TundraSG = tundra;
                }
                Console.WriteLine($"\nKor: {tundra.Kor}");
                Console.WriteLine("\n---------------------------------------------------- Kor vege ----------------------------------------------------\n");
            }

            int sumPredators(List<Kolonia> predatorColonies)
            {
                int sum = 0;
                foreach (var allat in predatorColonies)
                {
                    sum += allat.Letszam;
                }
                return sum;
            }

            bool checkAbove4(List<Kolonia> predatorColonies)
            {
                foreach (var allat in predatorColonies)
                {
                    if (allat.Letszam > 4)
                    {
                        alive = true;
                    }
                }

                return alive;
            }
            bool checkDouble(List<Kolonia> predatorColonies, int predatorColonyLetszamSum)
            {
                if (!(2 * predatorColonyLetszamSum == sumPredators(predatorColonies)))
                {
                    countDouble = true;
                }

                return countDouble;
            }
        }

        private static Allat CreateAllatInstance(string faj)
        {
            switch (faj)
            {
                case "l": // lemming
                    return new Lemming();
                case "n": // nyúl
                    return new Sarkinyul();
                case "s": // sarki róka
                    return new Sarkiroka();
                case "sz": // jávorszarvas
                    return new Javorszarvas();
                case "j": // jegesmedve
                    return new Jegesmedve();
                case "h": // hóbagoly
                    return new Hobagoly();
                default:
                    throw new ArgumentException($"Unknown species: {faj}");
            }
        }

    }
}
