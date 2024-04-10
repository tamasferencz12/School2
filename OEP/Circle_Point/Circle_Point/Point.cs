using System;

namespace Circle_Point
{
	public class Point
	{
		private readonly double x;
		private readonly double y;

		public Point(double x, double y)
		{
			this.x = x;
			this.y = y;
		}

		public double Distance(Point p) {
			return Math.Sqrt(Math.Pow(x - p.x, 2) + Math.Pow(y - p.y, 2));
        }
		
	}
}

