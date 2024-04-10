using System;
namespace Circle_Point
{
	public class Circle
	{
		public class WrongRadiusExeption : Exception { }

		private readonly Point c;
		private readonly double r;

		public Circle(Point c, double r)
		{
			if (r < 0) throw new WrongRadiusExeption();
			this.c = c;
			this.r = r;
		}

		public bool Contains(Point p)
		{
			return c.Distance(p) <= r;
		}
	}
}

