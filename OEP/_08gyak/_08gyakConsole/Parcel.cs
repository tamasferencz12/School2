using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace _08gyakConsole
{
    public class Parcel
    {
        private int plantigTime;
        private PlantType? content;

        public int PlantingTime { get { return plantigTime; } }

        public PlantType Content { get { return content; } }

        public Parcel()
        {
            plantigTime = 0;
            content = null;
        }

        public void Plant(PlantType plant)
        {
            if (content == null)
            {
                content = plant;
                plantigTime = DateTime.Now.Month;
            }
            else
            {
                throw new InvalidOperationException();
            }
        }

        public bool HasRipened(int month)
        {
            return content != null && content.IsVegetable() && month - plantigTime == content.RipeningTime;
        }

        public void Harvest()
        {
            content = null;
        }

    }
}