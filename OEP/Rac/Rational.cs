using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Numerics;

using System;

namespace Rational
{
    public class Rational
    {
        private int n;
        private int d;

        public Rational(int n, int d)
        {
            if (d == 0)
            {
                throw new Exception();
            }

            this.n = n;
            this.d = d;
        }

        public static Rational operator +(Rational a, Rational b)
        {
            return new Rational(a.n * b.d + a.d * b.n, a.d * b.d);
        }

        public static Rational operator -(Rational a, Rational b)
        {
            return new Rational(a.n * b.d - a.d * b.n, a.d * b.d);
        }

        public static Rational operator *(Rational a, Rational b)
        {
            return new Rational(a.n * b.n, a.d * b.d);
        }

        public static Rational operator /(Rational a, Rational b)
        {
            if (b.n == 0)
            {
                throw new Exception();
            }
            else
            {
                return new Rational(a.n * b.d, a.d * b.n);
            }
        }

        public static Rational Add(Rational a, Rational b)
        {
            return new Rational(a.n * b.d + a.d * b.n, a.d * b.d);
        }

        public static Rational Substract(Rational a, Rational b)
        {
            return new Rational(a.n * b.d - a.d * b.n, a.d * b.d);
        }

        public static Rational Multiply(Rational a, Rational b)
        {
            return new Rational(a.n * b.n, a.d * b.d);
        }

        public static Rational Divide(Rational a, Rational b)
        {
            if (b.n == 0)
            {
                throw new Exception();
            }
            else
            {
                return new Rational(a.n * b.d, a.d * b.n);
            }
        }

        public override string ToString()
        {
            if (n == 0)
            {
                return String.Format($"{n:#}");
            }
            else if (n > 0 || n < 0)
            {
                return String.Format($"{n}/{d}");
            }
            else
            {
                return String.Empty;
            }
        }
    }
}

