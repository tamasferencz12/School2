using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace _09gyakConsole
{
    public class Oltohely
    {
        private string hely;
        private List<Paciens> regisztraltak;

        private List<Vakcina> vakcinak;

        public void Beszerez(Vakcina v)
        {
            vakcinak.Add(v);
        }

        public void Regisztral(Paciens p)
        {
            foreach (Paciens e in regisztraltak)
            {
                if (e.getTaj() == p.getTaj())
                {
                    throw new Exception("");
                }
                else
                {
                    regisztraltak.Add(p);
                }
            }
        }

        public void Beolt(Paciens p, string vnev)
        {
            foreach (Oltas e in vakcinak)
            {
                if ()
            }
        }

        public int HanyanKettot()
        {
            int sum = 0;
            foreach (Paciens e in regisztraltak)
            {
                if (e.Hanyoltas() >= 2)
                {
                    sum++;
                }
            }

            return sum;
        }
    }
}