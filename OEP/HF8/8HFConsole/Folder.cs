using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace _8HFConsole
{
    public class Folder : Registration
    {
        private List<Registration> items;

        public Folder()
        {
            items = new List<Registration>();
        }

        public override int GetSize()
        {
            int summ = 0;
            foreach (var item in items)
            {
                summ += item.GetSize();
            }
            return summ;
        }

        public void Add(Registration r)
        {
            items.Add(r);
        }

        public void Remove(Registration r)
        {
            items.Remove(r);
        }
    }
}