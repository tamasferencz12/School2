using System;

namespace Spiral
{
	public class Notebook
	{
        #region Exceptions
        public class IllegalSideExceptions : Exception { };
        #endregion

        #region Enums
        public enum Sort { plain, grid, lined};
        public enum State { empty, full};
        #endregion

        #region Fields
        private readonly Sort type;
        private readonly List<Page> pages;
        private int total;
        #endregion

        #region Properties
        public Sort Type { get { return type; } }
        #endregion

        #region Constructors
        public Notebook(int n, Sort type)
        {
            this.type = type;
            pages = new List<Page>();
            for (int i = 0; i < n; i++)
            {
                pages.Add(new Page());
            }
            total = 0;
        }
        #endregion

        #region Public methods
        public int Count()
        {
            return pages.Count;
        }
        public int EmptyCount()
        {
            return pages.Count - total;
        }
        public void Write(int ind)
        {
            --ind;
            if (ind < 0 || ind >= pages.Count || pages[ind].state == State.full)
            {
                throw new IllegalSideExceptions();
            }
            pages[ind].state = State.full;
            ++total;

        }
        public void Remove(int ind)
        {
            --ind;
            if (ind < 0 || ind >= pages.Count)
            {
                throw new IllegalSideExceptions();
            }
            if (pages[ind].state == State.full )
            {
                --total;
            }
            pages.RemoveAt(ind);
        }
        public bool Search(out int ind)
        {
            ind = 0;
            for (int i = 0; i < pages.Count; i++)
            {
                if (pages[i].state==State.empty)
                {
                    ind = i + 1;
                    return true;
                }
            }
            return false;
        }
        #endregion
    }
}

