using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10HF
{
    class TargetShot
    {
        private string site;

        private List<Gift> gifts;
        public List<Gift> GetGifts()
        {
            return gifts;
        }
        public TargetShot(string s)
        {
            site = s;
            gifts = new();
        }
        public void Shows(Gift g)
        {
            if (g.TargetShot is not null) throw new Exception();
            if (gifts.Contains(g)) throw new Exception();

            g.TargetShot = this;
            gifts.Add(g);
        }
    }
}
