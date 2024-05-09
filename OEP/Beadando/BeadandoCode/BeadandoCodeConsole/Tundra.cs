using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BeadandoCodeConsole
{
    public class Tundra
    {
        private int kor;
        private List<Kolonia> kolonia = new List<Kolonia>();

        public int getKor()
        {
            return this.kor;
        }
        public List<Kolonia> GetKolonia()
        {
            return kolonia;
        }
    }


}