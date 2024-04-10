using System;

namespace Spiral
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Notebook notebook = new Notebook(32, Notebook.Sort.lined);
            Console.WriteLine($"Type of notebook: {notebook.Type}");
            Console.WriteLine($"Number of pages: {notebook.Count()}");
            Console.WriteLine($"Number of empty pages: {notebook.EmptyCount()}");
            notebook.Write(1);
            notebook.Write(2);
            notebook.Remove(1);
            Console.WriteLine($"Number of pages: {notebook.Count()}");
            Console.WriteLine($"Number of empty pages: {notebook.EmptyCount()}");
            bool l = notebook.Search(out int ind);
            if (l)
            {
                Console.WriteLine($"Found empty page: {ind}");
            }
            else
            {
                Console.WriteLine("No empty pages");
            }
        }
    }
}

