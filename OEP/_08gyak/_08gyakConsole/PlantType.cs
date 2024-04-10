using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace _08gyakConsole
{
    public class PlantType
    {
        protected int ripeningTime;
        public int RipeningTime { get; }

        public PlantType(int ripeningTime)
        {
            this.ripeningTime = ripeningTime;
        }

        public virtual bool IsVegetable()
        {
            return false;
        }

        public virtual bool IsFlower()
        {
            return false;
        }
    }

    public class Flower : PlantType
    {
        protected Flower(int time) : base(time) { }
        public override bool IsFlower()
        {
            return true;
        }
    }

    public class Vegetable : PlantType
    {
        protected Vegetable(int time) : base(time) { }
        public override bool IsVegetable()
        {
            return true;
        }
    }

    class Potato : Vegetable
    {
        private Potato() : base(0) { }
        private static Potato instance;

        public static Potato Instance()
        {
            if (instance == null)
            {
                instance = new Potato();
            }
            return instance;
        }
    }

    class Pea : Vegetable
    {
        private Pea() : base(1) { }
        private static Pea instance;

        public static Pea Instance()
        {
            if (instance == null)
            {
                instance = new Pea();
            }
            return instance;
        }
    }

    class Onion : Vegetable
    {
        private Onion() : base(1) { }
        private static Onion instance;

        public static Onion Instance()
        {
            if (instance == null)
            {
                instance = new Onion();
            }
            return instance;
        }
    }

    class Tulip : Flower
    {
        private Tulip() : base(1) { }
        private static Tulip instance;

        public static Tulip Instance()
        {
            if (instance == null)
            {
                instance = new Tulip();
            }
            return instance;
        }
    }

    class Carnation : Flower
    {
        private Carnation() : base(1) { }
        private static Carnation instance;

        public static Carnation Instance()
        {
            if (instance == null)
            {
                instance = new Carnation();
            }
            return instance;
        }
    }

    class Rose : Flower
    {
        private Rose() : base(1) { }
        private static Rose instance;

        public static Rose Instance()
        {
            if (instance == null)
            {
                instance = new Rose();
            }
            return instance;
        }
    }


}