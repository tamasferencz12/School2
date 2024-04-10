using System;
namespace Labirynth
{
    public class IllegalExceptions : Exception { };

    public enum Content
    {
        EMPTY, WALL, TREASURE, GHOST
    }

    public struct Direction { public int x, y; }

    public class Labirynth
    {

        private Content[,] map;

        public Labirynth(Content[,] map)
        {
            this.map = map;
        }

        public Content WhatIsThere(int x, int y, Direction direction)
        {
            int newX = x + direction.x;
            int newY = y + direction.y;

            if ((newX >= 0 && newX < map.GetLength(0) && newY >= 0 && newY < map.GetLength(1)) && (direction.x == 0 || direction.y == 0))
            {

                return map[newX, newY];
            }
            else
            {
                throw new IllegalExceptions();
            }
        }

        public void Collect(int x, int y)
        {
            if (map[x, y] != Content.TREASURE)
            {
                throw new IllegalExceptions();
            }
            else
            {
                map[x, y] = Content.EMPTY;
            }
        }
    }
}

