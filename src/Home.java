// Simple java program to show how "super" works with constructors

class Room
{
    int length, width;

    Room(int x, int y)
    {
        length = x;
        width = y;
    }

    int Area()
    {
        return (length * width);
    }
}

class GuestRoom extends Room
{
    int height;

    GuestRoom(int x, int y, int z)
    {
        super(x, y);
        height = z;
    }

    int Volume()
    {
        return (length * width * height);
    }
}

public class Home
{
    public static void main(String[] args)
    {
        GuestRoom gr = new GuestRoom(10, 20, 30);

        int area = gr.Area();
        int volume = gr.Volume();

        System.out.println("Area: " + area);
        System.out.println("Volume: " + volume);
    }
}
