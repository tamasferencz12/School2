using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BeadandoCodeConsole
{
    public class Jegesmedve : Ragadozo
    {
        public Jegesmedve() : base("faj")
        {

        }

        public override void Szaporodik()
        {
            int x = kolonia.Letszam / 4;
            if (kolonia.getTundra().getKor() % 8 == 0)
            {
                kolonia.Letszam = kolonia.Letszam + x;
            }
        }

        public override void tamad(Lemming lemming)
        {
            int x = (lemming._kolonia.Letszam * 2) / 100;
            lemming._kolonia.Letszam = lemming._kolonia.Letszam - x;
            if (x / 20 < kolonia.Letszam)
            {
                kolonia.Letszam = 20;
            }
        }

        public override void tamad(Sarkinyul sarkinyul)
        {
            int x = (sarkinyul._kolonia.Letszam * 1) / 100;
            sarkinyul._kolonia.Letszam = sarkinyul._kolonia.Letszam - x;
            if (x / 10 < kolonia.Letszam)
            {
                kolonia.Letszam = 10;
            }
        }

        public override void tamad(Javorszarvas javorszarvas)
        {
            int x = (javorszarvas._kolonia.Letszam * 25) / 100;
            javorszarvas._kolonia.Letszam = javorszarvas._kolonia.Letszam - x;
            if (x / 0.5 < kolonia.Letszam)
            {
                kolonia.Letszam = (int)0.5;
            }
        }
    }
}