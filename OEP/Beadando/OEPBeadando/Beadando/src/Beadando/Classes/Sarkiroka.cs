using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Classes
{
    public class Sarkiroka : Ragadozo
    {
        public Sarkiroka() : base("Sarkiroka")
        {

        }

        public override void Szaporodik()
        {
            int x = kolonia!.Letszam / 4;
            if (kolonia.TundraSG.Kor % 3 == 0)
            {
                kolonia.Letszam = kolonia.Letszam + (3 * x);
            }
        }

        public override void Tamad(Lemming lemming)
        {
            int x = lemming.KoloniaSG.Letszam * 5 / 100;
            lemming.KoloniaSG.Letszam = lemming.KoloniaSG.Letszam - x;
            if (x / 4 < kolonia!.Letszam)
            {
                kolonia.Letszam = x / 4;
            }
        }

        public override void Tamad(Sarkinyul sarkinyul)
        {
            int x = sarkinyul.KoloniaSG.Letszam * 35 / 100;
            sarkinyul.KoloniaSG.Letszam = sarkinyul.KoloniaSG.Letszam - x;
            if (x / 2 < kolonia!.Letszam)
            {
                kolonia.Letszam = x / 2;
            }
        }

        public override void Tamad(Javorszarvas javorszarvas)
        {
            int x = javorszarvas.KoloniaSG.Letszam * 0 / 100;
            javorszarvas.KoloniaSG.Letszam = javorszarvas.KoloniaSG.Letszam - x;
            if (x / 0 < kolonia!.Letszam)
            {
                kolonia.Letszam = 0;
            }
        }
    }
}