using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection.Metadata.Ecma335;
using System.Threading.Tasks;

namespace Classes
{
    public class Kolonia
    {
        private string becenev;
        private int letszam;
        private Allat allat;
        private Tundra tundra;


        public string Becenev { get => becenev; }
        public Allat AllatSG { get => allat; set => this.allat = value; }
        public int Letszam { get { return letszam; } set { letszam = value; } }
        public Tundra TundraSG { get { return tundra; } set { tundra = value; } }

        public Kolonia(string becenev, int letszam, Allat allat, Tundra tundra)
        {
            string newString = becenev;
            int newInt = letszam;
            this.becenev = newString;
            this.letszam = newInt;
            this.allat = allat;
            this.tundra = tundra;
        }
    }
}