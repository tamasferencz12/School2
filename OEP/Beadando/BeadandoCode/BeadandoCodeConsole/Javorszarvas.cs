using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BeadandoCodeConsole
{
    public class Javorszarvas : Zsakmanyallat
    {
        public Javorszarvas() : base("Javorszarvas")
        {

        }

        public override void Szaporodik()
        {
            if (kolonia.getTundra().getKor() % 4 == 0)
            {
                kolonia.Letszam = (int)(1.2 * kolonia.Letszam);
            }
        }

        public override void Elvandorol()
        {
            if (kolonia.Letszam == 200)
            {
                kolonia.Letszam = 40;
            }
        }

        public override void tamadott(Ragadozo ragadozo)
        {
            ragadozo.tamad(this);
        }
    }
}