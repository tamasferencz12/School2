using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10HF
{
    interface Size
    {
        public virtual int Multi()
        {
            return 0;
        }
    }
    class S : Size
    {
        private static S instance;
        private S() { }
        public static S Instance()
        {
            if (instance == null)
            {
                instance = new S();
            }
            return instance;
        }
        public int Multi()
        {
            return 1;
        }
    }

    class M : Size
    {
        private static M instance;
        private M() { }
        public static M Instance()
        {
            if (instance == null)
            {
                instance = new M();
            }
            return instance;
        }
        public int Multi()
        {
            return 2;
        }
    }

    class L : Size
    {
        private static L instance;
        private L() { }
        public static L Instance()
        {
            if (instance == null)
            {
                instance = new L();
            }
            return instance;
        }
        public int Multi()
        {
            return 3;
        }
    }
    class XL : Size
    {
        private static XL instance;
        private XL() { }
        public static XL Instance()
        {
            if (instance == null)
            {
                instance = new XL();
            }
            return instance;
        }
        public int Multi()
        {
            return 4;
        }
    }

}
