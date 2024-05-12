using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Classes
{
    public abstract class Ragadozo : Allat
    {
        public Ragadozo(string faj) : base(faj)
        {

        }

        public abstract void Tamad(Lemming lemming);

        public abstract void Tamad(Sarkinyul sarkinyul);

        public abstract void Tamad(Javorszarvas javorszarvas);

        public override bool IsAlive()
        {
            if (kolonia!.Letszam > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

    }
}