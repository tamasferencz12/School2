using System;
using System.Collections.Generic;
using System.IO;

namespace Shopp
{
    public struct Product
    {
        public int Id { get; set; }
        public int Price { get; set; }

        public Product(int Id, int Price)
        {
            this.Id = Id;
            this.Price = Price;
        }

        public override string ToString()
        {
            return ($"{{ Id: {Id}, Price: {Price} }}");
        }
    }
    public struct Invoice
    {
        public string name;
        public List<Product> products;
        public string Name { get { return name; } set { name = value; } }
        public List<Product> Products { get { return products; } set { products = value; } }

        public Invoice(string name, List<Product> products)
        {
            this.name = name;
            this.products = products;
        }

        public int SumPrice()
        {
            return products.Select(p => p.Price).ToList().Sum();
        }

        public override string ToString()
        {
            return ($"{{Name: {Name}, Items: {String.Join(", ", products.Select(p => p.ToString()).ToList())}, Sum: {SumPrice()} }}");
        }
    }

    internal class Program
    {
        public static int Summ(List<Product> x)
        {
            int sum = 0;
            foreach (Product e in x)
            {
                sum = sum + e.Price;
            }
            return sum;
        }
        static void Main(string[] args)
        {
            string inputFile = args[0];
            StreamReader reader = new StreamReader(inputFile);


            int income = 0;
            while (ReadInvoice(reader, out Invoice invoice))
            {
                income = income + Summ(invoice.Products);
                Console.WriteLine(invoice.ToString());
            }

            Console.WriteLine(income);

            try
            {
                FileStream stream = new FileStream("out.txt", FileMode.OpenOrCreate);
                using (StreamWriter writer = new StreamWriter(stream))
                {
                    writer.WriteLine(income);
                }
            }
            catch (Exception exp)
            {
                Console.Write(exp.Message);
            }
        }

        public static bool ReadInvoice(StreamReader reader, out Invoice invoice)
        {
            invoice = new Invoice(string.Empty, new List<Product>());

            string? line = reader.ReadLine();
            if (line != null)
            {
                string[] parts = line.Split(' ');

                string[] parts1 = new string[] { parts[0] };
                string[] parts2 = parts.Skip(1).ToArray();
                if (parts2.Length >= 2)
                {

                    string name = parts1[0];
                    //Console.WriteLine("Name: " + invoice.Name);
                    List<Product> products = new List<Product>();
                    for (int i = 0; i < parts2.Length; i += 2)
                    {
                        if (i + 1 <= parts2.Length && int.TryParse(parts2[i], out int productId) && int.TryParse(parts2[i + 1], out int productPrice))
                        {
                            products.Add(new Product(productId, productPrice));
                        }
                        else
                        {
                            Console.WriteLine("Invalid product detail.");
                            return false;
                        }
                    }
                    invoice = new Invoice(name, products);
                    return true;
                }
            }
            else
            {
                return false;
            }

            return true;
        }
    }
}