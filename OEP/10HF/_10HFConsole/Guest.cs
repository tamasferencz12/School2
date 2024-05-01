using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10HF
{
    class Guest
    {
        private string name;
        private List<Gift> prizes;
        public string getName() => name;

        public Guest(string n)
        {
            name = n;
            prizes = new();
        }
        public void Wins(Gift g)
        {
            if (!g.TargetShot.GetGifts().Contains(g)) throw new Exception();
            g.TargetShot.GetGifts().Remove(g);
            prizes.Add(g);
        }
        public int Result(TargetShot t)
        {
            return prizes.Where(gift => gift.TargetShot == t).Sum(gift => gift.Value());
        }
    }
}
