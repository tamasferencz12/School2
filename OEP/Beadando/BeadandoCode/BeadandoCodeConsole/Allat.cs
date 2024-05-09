using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BeadandoCodeConsole
{
    public abstract class Allat
    {
        private string faj;

        protected Kolonia kolonia;

        public Kolonia _kolonia { get { return kolonia; } }
        public Allat(string faj)
        {
            this.faj = faj;
        }

        public virtual void Elvandorol()
        {

        }

        public virtual bool isAlive()
        {
            return false;
        }

        public abstract void Szaporodik();
    }
}