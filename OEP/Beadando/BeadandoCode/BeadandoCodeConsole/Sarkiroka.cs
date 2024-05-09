using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BeadandoCodeConsole
{
    public class Sarkiroka : Ragadozo
    {
        public Sarkiroka() : base("Sarkiroka")
        {

        }

        public override void Szaporodik()
        {
            int x = kolonia.Letszam / 4;
            if (kolonia.getTundra().getKor() % 3 == 0)
            {
                kolonia.Letszam = kolonia.Letszam + (3 * x);
            }
        }

        public override void tamad(Lemming lemming)
        {
            int x = (lemming._kolonia.Letszam * 5) / 100;
            lemming._kolonia.Letszam = lemming._kolonia.Letszam - x;
            if (x / 4 < kolonia.Letszam)
            {
                kolonia.Letszam = 4;
            }
        }

        public override void tamad(Sarkinyul sarkinyul)
        {
            int x = (sarkinyul._kolonia.Letszam * 35) / 100;
            sarkinyul._kolonia.Letszam = sarkinyul._kolonia.Letszam - x;
            if (x / 2 < kolonia.Letszam)
            {
                kolonia.Letszam = 2;
            }
        }

        public override void tamad(Javorszarvas javorszarvas)
        {
            int x = (javorszarvas._kolonia.Letszam * 0) / 100;
            javorszarvas._kolonia.Letszam = javorszarvas._kolonia.Letszam - x;
            if (x / 0 < kolonia.Letszam)
            {
                kolonia.Letszam = 0;
            }
        }
    }
}