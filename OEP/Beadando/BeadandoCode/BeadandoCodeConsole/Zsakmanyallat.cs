using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BeadandoCodeConsole
{
    public abstract class Zsakmanyallat : Allat
    {
        public Zsakmanyallat(string faj) : base(faj)
        {

        }
        public virtual void tamadott(Ragadozo ragadozo)
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