using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace HF9Console
{
    public class Solarsystem
    {
        public List<Planet> planets = new List<Planet>();

        public Solarsystem()
        {

        }

        public (bool l, Starship starship) MaxFireP()
        {
            float max = 0;
            bool l = false;
            Starship starship = null;

            foreach (var planet in planets)
            {
                foreach (var ship in planet.GetStarships())
                {
                    float firePower = ship.FireP();
                    if (firePower > max)
                    {
                        max = firePower;
                        l = true;
                        starship = ship;
                    }
                }
            }

            return (l, starship);
        }

        public List<Planet> Defenseless()
        {
            List<Planet> defens = new List<Planet>();

            foreach (var e in planets)
            {
                if (e.ShipCount() == 0)
                {
                    defens.Add(e);
                }
            }
            return defens.ToArray().ToList();
        }
    }
}