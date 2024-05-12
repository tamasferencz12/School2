using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Classes
{
    public class Tundra
    {
        private int kor;
        private List<Kolonia> kolonia = new List<Kolonia>();

        public int Kor { get { return kor; } }

        public List<Kolonia> KoloniaG { get { return kolonia; } }

        public Tundra(int kor)
        {
            this.kor = kor;
        }

        public void IncrementKor()
        {
            this.kor++;
        }
    }
}