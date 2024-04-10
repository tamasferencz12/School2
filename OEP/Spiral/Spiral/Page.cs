using System;
using static Spiral.Notebook;

namespace Spiral
{
	public class Page
	{
		public State state;
		public string content;

		public Page()
		{
			state = State.empty;
			content = string.Empty;
		}
	}
}

