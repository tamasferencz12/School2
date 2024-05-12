using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Classes
{
    public abstract class Allat
    {
        private string faj;

        protected Kolonia? kolonia;

        public Kolonia KoloniaSG { get => kolonia!; set => kolonia = value; }
        public Allat(string faj)
        {
            this.faj = faj;
        }

        public virtual void Elvandorol()
        {

        }

        public virtual bool IsAlive()
        {
            return false;
        }

        public abstract void Szaporodik();
    }
}