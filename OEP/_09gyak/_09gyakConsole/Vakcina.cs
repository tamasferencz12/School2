using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace _09gyakConsole
{
    public abstract class Vakcina
    {
        private DateTime lejar;

        public abstract string Nev();
        public virtual int Ism()
        {
            return 0;
        }
    }
}