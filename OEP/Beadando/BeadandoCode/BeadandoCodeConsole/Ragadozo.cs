using System;
using System.Collections.Generic;
using System.Linq
using System.Threading.Tasks;

namespace BeadandoCodeConsole
{
    public abstract class Ragadozo : Allat
    {
        public Ragadozo(string faj) : base(faj)
        {

        }

        public virtual void tamad(Lemming lemming)
        {

        }

        public virtual void tamad(Sarkinyul sarkinyul)
        {

        }

        public virtual void tamad(Javorszarvas javorszarvas)
        {

        }

        public override bool isAlive()
        {
            if (kolonia.Letszam > 0)
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