using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace _7HFConsole
{
    public class ATM
    {
        public string site;
        private Center center;

        public ATM(string site, Center center)
        {
            this.site = site;
            this.center = center;
        }

        public void Process(Customer c)
        {
            Card card = c.ProvidesCard();
            if (card.CheckPIN(c.ProvidesPIN()))
            {
                int a = c.RequestMoney();
                if (center.GetBalance(card.cNum) >= a)
                {
                    center.Transaction(card.cNum, -a);
                }
            }
        }
    }
}