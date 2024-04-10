using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapS
{
    internal class Map
    {
        public class AlreadyExistingKeyException : Exception { }
        public class NonExistringException : Exception { }
        public class Item
        {
            private readonly int key;
            private readonly string data;
            public int Key { get { return key; } }
            public string Data { get { return data; } }
            public Item(int key, string data)
            {
                this.key = key;
                this.data = data;
            }
            public Item(Item item)
            {
                this.key = item.Key;
                this.data = item.Data;
            }
            public override string ToString()
            {
                return $"({key}:{data})";
            }
        }
        private List<Item> seq = new List<Item>();
        public void SetEmpty()
        {
            seq.Clear();
        }
        public int Count()
        {
            return seq.Count;
        }
        public void Insert(Item item)
        {
            bool l = LogSearch(item.Key, out int ind);
            if (l)
            {
                throw new AlreadyExistingKeyException();
            }
            else
            {
                seq.Insert(ind, new Item(item));
            }
        }
        public void Remove(int key)
        {
            bool l = LogSearch(key, out int ind);
            if (!l)
            {
                throw new NonExistringException();
            }
            else
            {
                seq.RemoveAt(ind);
            }
        }
        public bool In(int key)
        {
            return LogSearch(key, out int ind);
        }
        public string Select(int key)
        {
            bool l = LogSearch(key, out int ind);
            if (!l)
            {
                throw new NonExistringException();
            }
            else
            {
                return seq[ind].Data;
            }
        }
        public override string ToString()
        {
            string[] output = new string[seq.Count];
            foreach (var item in seq)
            {
                output = output.Append(item.ToString()).ToArray();
            }
            return $"[{string.Join(string.Empty, output)}]";
        }
        private bool LogSearch(int key, out int ind)
        {
            ind = 0;
            bool l = false;
            int ll = 0;
            int ul = seq.Count - 1;
            while (ll <= ul)
            {
                ind = (ll + ul) / 2;
                if (seq[ind].Key == key)
                {
                    l = true;
                    break;
                }
                else if (seq[ind].Key > key)
                {
                    ul = ind - 1;
                }
                else if (seq[ind].Key < key)
                {
                    ll = ind + 1;
                }
            }
            if (!l)
            {
                ind = ll;
            }
            return l;
        }
    }
}
