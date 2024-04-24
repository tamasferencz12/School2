using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace HF9Console
{
    public class Starship
    {
        private string name;
        protected int shield;
        protected int armor;
        protected int guardian;

        private Planet planet = null;

        public Starship(string name, int shield, int armor, int guardian)
        {
            this.name = name;
            this.shield = shield;
            this.armor = armor;
            this.guardian = guardian;
        }

        public int GetShield()
        {
            return this.shield;
        }

        public void StaysAtPlanet(Planet p)
        {
            if (planet != null)
            {
                planet.Leaves(this);
            }
            planet = p;
            planet.Defends(this);
        }

        public void LeavesPlanet()
        {
            if (planet == null)
            {
                throw new Exception();
            }
            else
            {
                planet.Leaves(this);
                planet = null;
            }
        }

        public virtual float FireP()
        {
            return 0;
        }
    }
}