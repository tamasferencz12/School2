using System;
namespace Complex
{
	public class Complex
	{
		private readonly double x;
        private readonly double y;

		public Complex(double x, double y)
		{
			this.x = x;
			this.y = y;
		}

		public static Complex operator +(Complex a, Complex b)
		{
			return new Complex(a.x + b.x, a.y + b.y);
		}

        public static Complex operator -(Complex a, Complex b)
        {
            return new Complex(a.x - b.x, a.y - b.y);
        }

        public static Complex operator *(Complex a, Complex b)
        {
            return new Complex(a.x * b.x + a.y * b.y, a.x + b.y + a.y * b.x);
        }

        public static Complex operator /(Complex a, Complex b)
        {
            if (b.x == 0 || b.y == 0)
            {
                throw new Exception();
            }
            return new Complex((a.x * b.x + a.y + b.y) / (b.x * b.x + b.y * b.y),(a.y * b.x - a.x *b.y)/ (b.x * b.x + b.y * b.y));
        }

        public override string ToString()
        {
            if (y == 0.0)
            {
                return String.Format($"{x:0.0#}");
            }
            else if (y > 0.0)
            {
                return String.Format($"{x:0.0#} + { Math.Abs(y):0.0#}i");
            }
            else if (y < 0.0)
            {
                return String.Format($"{x:0.0#} - {Math.Abs(y):0.0#}i");
            }
            else
            {
                return String.Empty;
            }
        }
    }
}

