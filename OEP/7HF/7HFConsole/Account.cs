using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace _7HFConsole
{
    public class Account
    {
        public string accNum;
        private int balance;
        public List<Card> cards;

        public Account(string accNum)
        {
            this.accNum = accNum;
            this.balance = 0;
            cards = new List<Card>();
        }

        public int GetBalance()
        {
            return this.balance;
        }

        public void Change(int a)
        {
            this.balance += a;
        }
    }
}