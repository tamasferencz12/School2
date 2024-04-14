using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace _7HFConsole
{
    public class Bank
    {
        private List<Account> accounts;

        public Bank()
        {
            accounts = new List<Account>();
        }

        private bool FindAccount(string cNum, out Account a)
        {
            a = accounts.Find(x => x.accNum == cNum);
            return a == null ? false : true;
        }

        public void OpenAccount(string cNum, Customer c)
        {
            Account a = new Account(cNum);
            c.AddAccount(a);
            accounts.Add(a);
        }

        public void ProvidesCard(string cNum)
        {
            bool l = FindAccount(cNum, out Account a);
            if (l)
            {
                a.cards.Add(new Card(cNum, "1234"));
            }
            else
            {
                throw new Exception();
            }
        }

        public int GetBalance(string cNum)
        {
            bool l = FindAccount(cNum, out Account a);
            if (l)
            {
                return a.GetBalance();
            }
            else
            {
                return -1;
            }
        }

        public void Transaction(string cNum, int ammount)
        {
            bool l = FindAccount(cNum, out Account a);
            if (l)
            {
                a.Change(ammount);
            }
            else
            {
                throw new Exception();
            }
        }

        public bool CheckAccount(string cNum)
        {
            bool l = FindAccount(cNum, out Account a);

            return l;
        }
    }
}