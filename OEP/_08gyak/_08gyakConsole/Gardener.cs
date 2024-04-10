using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace _08gyakConsole
{
    public class Gardener
    {
        private Garden gardener;

        public Gardener Garden { get => garden; }

        public Gardener(Garden garden)
        {
            this.garden = garden;
        }
    }
}