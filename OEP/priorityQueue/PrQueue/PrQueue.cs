using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace PrQueue
{
    public class PrQueue
    {
        public struct Element
        {
            public int pr;
            public string data;
        }
        private List<Element> seq = new List<Element>();

        public void SetEmpty()
        {
            seq.Clear();
        }

        public bool isEmpty()
        {
            return seq.Count == 0;
        }

        public void Add(Element e)
        {
            seq.Add(e);
        }

        public Element GetMax()
        {
            if (seq.Count == 0)
            {
                throw new InvalidOperationException("Sequence is empty");
            }

            int x = MaxSelect(out int ind);

            return seq[ind];
        }

        public Element RemMax()
        {
            if (seq.Count == 0)
            {
                throw new InvalidOperationException("Sequence is empty");
            }

            int x = MaxSelect(out int ind);
            Element e = seq[ind];
            this.seq.RemoveAt(ind);

            return e;
        }

        private int MaxSelect(out int ind)
        {
            if (seq.Count == 0)
            {
                throw new InvalidOperationException("Sequence is empty");
            }
            ind = 0;
            int max = seq[0].pr;

            for (int i = 1; i < seq.Count; i++)
            {
                if (seq[i].pr > max)
                {
                    max = seq[i].pr;
                    ind = i;
                }
            }
            return max;
        }
    }
}