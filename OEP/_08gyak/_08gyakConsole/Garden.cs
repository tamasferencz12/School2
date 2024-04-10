using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace _08gyakConsole
{
    public class Garden
    {
        private readonly List<Parcel> parcels = new List<Parcel>();

        public Parcel this[int index]
        {
            get
            {
                if (index < 0 || index > parcels.Count)
                {
                    throw new ArgumentOutOfRangeException();
                }
                else
                {
                    return parcels[index];
                }
            }
        }

        public Garden(int number)
        {
            if (number <= 0)
            {
                throw new ArgumentOutOfRangeException();
            }
            for (int i = 0; i < number; i++)
            {
                parcels.Add(new Parcel());
            }
        }

        public void Plant(int where, PlantType what)
        {
            if (where < 0 || where > parcels.Count)
            {
                throw new ArgumentOutOfRangeException();
            }
            parcels[where - 1].Plant(what);
        }

        public void Harverst(int where)
        {
            parcels[where - 1].Harverst();
        }

        public List<int> CanHarvest(int month)
        {
            List<int> result = new List<int>();
            for (int i = 0; i < parcels.Count; i++)
            {
                if (parcels[i].HasRipened(month))
                {
                    result.Add(i);
                }
            }
        }
    }
}