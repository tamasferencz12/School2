using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace _7HFConsole
{
    public class Card
    {
        public string cNum;
        private string pin;

        public Card(string cNum, string pin)
        {
            this.cNum = cNum;
            this.pin = pin;
        }
        public bool CheckPIN(string p)
        {
            return pin.Equals(p);
        }

        public void SetPIN(string p)
        {
            pin = p;
        }
    }
}