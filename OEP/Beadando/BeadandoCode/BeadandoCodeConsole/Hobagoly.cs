using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BeadandoCodeConsole
{
    public class Hobagoly : Ragadozo
    {
        public Hobagoly() : base("Hobagoly")
        {

        }

        public override void Szaporodik()
        {
            int x = kolonia.Letszam / 4;
            if (kolonia.getTundra().getKor() % 3 == 0)
            {
                kolonia.Letszam = kolonia.Letszam + (2 * x);
            }
        }

        public override void tamad(Lemming lemming)
        {
            int x = (lemming._kolonia.Letszam * 30) / 100;
            lemming._kolonia.Letszam = lemming._kolonia.Letszam - x;
            if (x / 2 < kolonia.Letszam)
            {
                kolonia.Letszam = 2;
            }
        }

        public override void tamad(Sarkinyul sarkinyul)
        {
            int x = (sarkinyul._kolonia.Letszam * 20) / 100;
            sarkinyul._kolonia.Letszam = sarkinyul._kolonia.Letszam - x;
            if (x / 1 < kolonia.Letszam)
            {
                kolonia.Letszam = 1;
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