using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace _8HFConsole
{
    public class File : Registration
    {
        private int size;

        public File(int size)
        {
            this.size = size;
        }

        public override int GetSize()
        {
            return this.size;
        }

    }
}