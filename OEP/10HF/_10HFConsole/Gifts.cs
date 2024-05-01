using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _10HF
{
    class Gift
    {
        Size size;
        private TargetShot targetShot;
        public TargetShot TargetShot { get; set; }
        public Gift(Size s)
        {
            size = s;
        }
        public int Value() => Point() * size.Multi();

        public virtual int Point()
        {
            return 0;
        }
    }
    class Ball : Gift
    {
        private Size size;
        public Ball(Size s) : base(s)
        {
            size = s;
        }
        public override int Point()
        {
            return 1;
        }
    }
    class Figure : Gift
    {
        private Size size;
        public Figure(Size s) : base(s)
        {
            size = s;
        }
        public override int Point()
        {
            return 2;
        }
    }
    class Plush : Gift
    {
        private Size size;
        public Plush(Size s) : base(s)
        {
            size = s;
        }
        public override int Point()
        {
            return 3;
        }
    }
}
