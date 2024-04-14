using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace _7HFConsole
{
    public class Center
    {
        private List<Bank> banks;

        public Center(List<Bank> banks)
        {
            this.banks = banks;
        }

        public int GetBalance(string cNum)
        {
            bool l = FindBank(cNum, out Bank bank);

            if (l)
            {
                return bank.GetBalance(cNum);
            }
            else
            {
                return -1;
            }
        }

        public void Transaction(string cNum, int amount)
        {
            bool l = FindBank(cNum, out Bank bank);

            if (l)
            {
                bank.Transaction(cNum, amount);
            }
        }

        private bool FindBank(string cNum, out Bank baank)
        {
            foreach (Bank bank in banks)
            {
                if (bank.CheckAccount(cNum))
                {
                    baank = bank;
                    return true;
                }
            }
            baank = null;
            return false;
        }
    }
}