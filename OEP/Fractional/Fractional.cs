using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Numerics;

namespace Rac
{
    public class Rac
    {
        private int n;
        private int d;

        public Rac(int n, int d)
        {
            if (d == 0)
            {
                throw new Exception();
            }

            this.n = n;
            this.d = d;
        }

        public static Rac operator +(Rac a, Rac b)
        {
            return new Rac(a.n * b.d + a.d * b.n, a.d * b.d);
        }

        public static Rac operator -(Rac a, Rac b)
        {
            return new Rac(a.n * b.d - a.d * b.n, a.d * b.d);
        }

        public static Rac operator *(Rac a, Rac b)
        {
            return new Rac(a.n * b.n, a.d * b.d);
        }

        public static Rac operator /(Rac a, Rac b)
        {
            if (b.n == 0)
            {
                throw new Exception();
            }
            else
            {
                return new Rac(a.n * b.d, a.d * b.n);
            }
        }

        public override string ToString()
        {
            if (d == 0)
            {
                return String.Format($"{n:#}");
            }
            else if (d > 0 || d < 0)
            {
                return String.Format($"{n} / {d}");
            }
            else
            {
                return String.Empty;
            }
        }
    }
}

