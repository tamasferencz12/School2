using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Classes
{
    public class Lemming : Zsakmanyallat
    {
        public Lemming() : base("Lemming")
        {

        }

        public override void Szaporodik()
        {
            if (kolonia!.TundraSG.Kor % 2 == 0)
            {
                kolonia.Letszam = 2 * kolonia.Letszam;
            }
        }

        public override void Elvandorol()
        {
            if (kolonia!.Letszam >= 200)
            {
                kolonia.Letszam = 30;
            }
        }

        public override void Tamadott(Ragadozo ragadozo)
        {
            ragadozo.Tamad(this);
        }
    }
}