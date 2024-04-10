using System;
namespace Dispenser
{
    public class Dispenser
    {
        private readonly int total;
        private readonly int portion;
        private int actual;

        public int Total { get { return total; } }
        public int Portion { get { return portion; } }
        public int Actual { get { return actual; } }

        public Dispenser(int total, int portion)
        {
            this.total = total;
            this.portion = portion;
            actual = 0;
        }

        public void Press()
        {
            actual = Math.Max(actual - portion, 0);
        }

        public void Fill()
        {
            actual = total;
        }
    }
}

