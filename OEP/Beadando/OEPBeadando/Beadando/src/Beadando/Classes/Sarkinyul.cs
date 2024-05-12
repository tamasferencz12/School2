using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Classes
{
    public class Sarkinyul : Zsakmanyallat
    {
        public Sarkinyul() : base("Sarkinyul")
        {

        }

        public override void Szaporodik()
        {
            if (kolonia!.TundraSG.Kor % 2 == 0)
            {
                kolonia.Letszam = (int)(1.5 * kolonia.Letszam);
            }
        }

        public override void Elvandorol()
        {
            if (kolonia!.Letszam >= 100)
            {
                kolonia.Letszam = 20;
            }
        }

        public override void Tamadott(Ragadozo ragadozo)
        {
            ragadozo.Tamad(this);
        }
    }
}