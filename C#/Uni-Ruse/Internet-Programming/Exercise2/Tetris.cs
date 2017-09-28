using System;

namespace InternetProgramming
{
    class Program
    {
        static BaseFigure[] figures = new BaseFigure[10];
        static Random rand = new Random();

        const int COLOR_MIN_VALUE = 7;
        const int COLOR_MAX_VALUE = 15;
        const int X_MIN_VALUE = 10;
        const int X_MAX_VALUE = 70;
        const int Y_MIN_VALUE = 0;
        const int Y_MAX_VALUE = 20;

        enum FigureType
        {
            //IFigure,
            //JFigure,
            //LFigure,
            OFigure,
            //ZFigure,
            //TFigure,
            //SFigure
        }

        static BaseFigure getRandomFigure(bool top = false)
        {
            int randomColor = rand.Next(COLOR_MIN_VALUE, COLOR_MAX_VALUE + 1);
            int randomX = rand.Next(X_MIN_VALUE, X_MAX_VALUE + 1);
            int y;
            if (top == false)
            {
                y = rand.Next(Y_MIN_VALUE, Y_MAX_VALUE + 1);
            }
            else
            {
                y = 1;
            }

            Array figureTypes = Enum.GetValues( typeof(FigureType) );
            FigureType randomFigure = (FigureType) figureTypes.GetValue( rand.Next(figureTypes.Length) );

            switch (randomFigure)
            {
                case (FigureType.OFigure):
                    return new OFigure(randomColor, randomX, y);
                default:
                    return null;
            }
        }

        static void Main(string[] args)
        {
            BaseFigure o = getRandomFigure();
            o.drawFigure();

            Console.ReadKey();
        }
    }

    abstract class BaseFigure
    {
        protected int color;
        protected int x;
        public int Y { get; set; }

        public int getColor()
        {
            return color;
        }

        public void setColor(int color)
        {
            this.color = color;
        }

        public int X
        {
            get
            {
                return x;
            }

            set
            {
                if (value <= 0)
                {
                    throw new ArgumentNullException("X", "x must be greater than 0");
                }
                x = value;
            }
        }

        public BaseFigure(int color, int x, int y)
        {
            this.color = color;
            this.x = x;
            this.Y = y;
        }

        abstract public void drawFigure();
    }

    class OFigure : BaseFigure
    {
        public OFigure(int color, int x, int y) : base(color, x, y)
        {
        }

        public override void drawFigure()
        {
            Console.ForegroundColor = (ConsoleColor) getColor();
            Console.BackgroundColor = (ConsoleColor) getColor();

            Console.CursorLeft = X;
            Console.CursorTop = Y;
            Console.Write("*");

            Console.CursorLeft = X + 1;
            Console.CursorTop = Y;
            Console.Write("*");

            Console.CursorLeft = X;
            Console.CursorTop = Y + 1;
            Console.Write("*");

            Console.CursorLeft = X + 1;
            Console.CursorTop = Y + 1;
            Console.Write("*");
        }
    }
}
