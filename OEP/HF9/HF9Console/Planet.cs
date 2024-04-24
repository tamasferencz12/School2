using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace HF9Console
{
    public class Planet
    {
        public string name;
        private List<Starship> ships = new List<Starship>();

        public List<Starship> GetStarships()
        {
            return ships;
        }

        public Planet(string name)
        {
            this.name = name;
        }

        public void Defends(Starship s)
        {
            if (ships.Contains(s))
            {
                throw new Exception();
            }
            else
            {
                ships.Add(s);
            }
        }

        public void Leaves(Starship s)
        {
            if (!ships.Contains(s))
            {
                throw new Exception();
            }
            else
            {
                ships.Remove(s);
            }
        }

        public int ShipCount()
        {
            return ships.Count();
        }

        public int ShieldSum()
        {
            int summ = 0;
            foreach (var e in ships)
            {
                summ += e.GetShield();
            }
            return summ;
        }

        public (bool y, float max, Starship starship) MaxFireP()
        {
            float max = 0;
            bool y = false;
            Starship starship = null;

            foreach (Starship e in ships)
            {
                if (e.FireP() > max)
                {
                    max = e.FireP();
                    y = true;
                    starship = e;
                }
            }

            return (y, max, starship);
        }
    }
}