using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BeadandoCodeConsole
{
    public class Kolonia
    {
        private string becenev;
        private int letszam;
        private Allat allat;
        private Tundra tundra;

        public int Letszam { get { return letszam; } set { letszam = value; } }

        public Kolonia(string becenev, int letszam, Allat allat)
        {
            this.becenev = becenev;
            this.letszam = letszam;
            this.allat = allat;
        }

        public string getBecenev()
        {
            return this.becenev;
        }

        public Allat getAllat()
        {
            return this.allat;
        }

        public Tundra getTundra()
        {
            return this.tundra;
        }
    }
}