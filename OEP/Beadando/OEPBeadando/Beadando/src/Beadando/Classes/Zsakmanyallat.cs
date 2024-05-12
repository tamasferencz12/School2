using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Classes
{
    public abstract class Zsakmanyallat : Allat
    {
        public Zsakmanyallat(string faj) : base(faj)
        {

        }
        public abstract void Tamadott(Ragadozo ragadozo);
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