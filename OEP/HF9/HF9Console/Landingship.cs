using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace HF9Console
{
    public class Landingship : Starship
    {

        public Landingship(string name, int shield, int armor, int guardian) : base(name, shield, armor, guardian)
        {

        }
        public override float FireP()
        {
            return (float)guardian;
        }
    }
}