using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10HF
{
    class AmPark
    {
        private List<TargetShot> targetShots;
        private List<Guest> guests;
        public AmPark(List<TargetShot> t)
        {
            if (t.Count < 2) throw new Exception();

            targetShots = t;
            guests = new();
        }
        public string Best(TargetShot t)
        {
            if (guests.Count == 0) throw new Exception();

            Guest maxGuest = guests[0];
            for (int i = 1; i < guests.Count; i++)
            {
                if (guests[i].Result(t) > maxGuest.Result(t))
                {
                    maxGuest = guests[i];
                }
            }
            return maxGuest.getName();
        }
        public void Receives(Guest g)
        {
            if (guests.Contains(g)) throw new Exception();
            guests.Add(g);
        }
    }

}
