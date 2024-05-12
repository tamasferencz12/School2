using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Classes
{
    public class Javorszarvas : Zsakmanyallat
    {
        public Javorszarvas() : base("Javorszarvas")
        {

        }

        public override void Szaporodik()
        {
            if (kolonia!.TundraSG.Kor % 4 == 0)
            {
                kolonia.Letszam = (int)(1.2 * kolonia.Letszam);
            }
        }

        public override void Elvandorol()
        {
            if (kolonia!.Letszam >= 200)
            {
                kolonia.Letszam = 40;
            }
        }

        public override void Tamadott(Ragadozo ragadozo)
        {
            ragadozo.Tamad(this);
        }
    }
}