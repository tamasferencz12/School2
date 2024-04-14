using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace _7HFConsole
{
    public class Customer
    {
        private string pin;
        private int withdraw;
        private List<Account> accounts;


        public Customer(string pin, int withdraw)
        {
            this.pin = pin;
            this.withdraw = withdraw;
            accounts = new List<Account>();
        }

        public void Withdrawal(ATM atm)
        {
            atm.Process(this);
        }

        public Card ProvidesCard()
        {
            return accounts[0].cards[0];
        }

        public string ProvidesPIN()
        {
            return this.pin;
        }

        public int RequestMoney()
        {
            return this.withdraw;
        }

        public void AddAccount(Account a)
        {
            accounts.Add(a);
        }
    }
}