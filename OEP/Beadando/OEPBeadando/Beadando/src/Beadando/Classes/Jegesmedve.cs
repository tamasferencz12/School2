using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Classes
{
    public class Jegesmedve : Ragadozo
    {
        public Jegesmedve() : base("Jegesmedve")
        {

        }

        public override void Szaporodik()
        {
            int x = kolonia!.Letszam / 4;
            if (kolonia.TundraSG.Kor % 8 == 0)
            {
                kolonia.Letszam = kolonia.Letszam + x;
            }
        }

        public override void Tamad(Lemming lemming)
        {
            int x = lemming.KoloniaSG.Letszam * 2 / 100;
            lemming.KoloniaSG.Letszam = lemming.KoloniaSG.Letszam - x;
            if (x / 20 < kolonia!.Letszam)
            {
                kolonia.Letszam = x / 20;
            }
        }

        public override void Tamad(Sarkinyul sarkinyul)
        {
            int x = sarkinyul.KoloniaSG.Letszam * 1 / 100;
            sarkinyul.KoloniaSG.Letszam = sarkinyul.KoloniaSG.Letszam - x;
            if (x / 10 < kolonia!.Letszam)
            {
                kolonia.Letszam = x / 10;
            }
        }

        public override void Tamad(Javorszarvas javorszarvas)
        {
            int x = (javorszarvas.KoloniaSG.Letszam * 25) / 100;
            javorszarvas.KoloniaSG.Letszam = javorszarvas.KoloniaSG.Letszam - x;
            if (x / 0.5 < kolonia!.Letszam)
            {
                kolonia.Letszam = x * 1 / 2;
            }
        }
    }
}