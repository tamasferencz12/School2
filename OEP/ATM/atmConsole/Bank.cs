using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace ATM
{
    public class Account
    {
        public string name;
        public int accountId;
        public int pin;
        public int value;

        public string Name { get { return name; } }

        public int Pin { get { return pin; } }

        public int AccountId { get { return accountId; } }

        public int Value { get { return value; } }

        public Account(string name, int pin, int accountId, int value)
        {
            this.name = name;
            this.accountId = accountId;
            this.value = value;
            this.pin = pin;
        }

    }
    public class Bank
    {
        private List<Account> accounts;

        public List<Account> Account { get { return accounts; } }

        public Bank(List<Account> accounts)
        {
            this.accounts = accounts;
        }

    }
}