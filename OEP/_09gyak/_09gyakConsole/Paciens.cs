using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace _09gyakConsole
{
    public class Paciens
    {
        private string taj;
        private List<Oltas> oltasok;

        public string getTaj()
        {
            return this.taj;
        }

        public int Hanyoltas()
        {
            return oltasok.Count;
        }
    }
}