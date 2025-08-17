// Simple java program to show how "super" works

class Person
{
    String name = "Adithya";
}

public class Name extends Person
{
    String name = "Jaison";

    void show()
    {
        System.out.println("Name in parent class: " + super.name);
        System.out.println("Name in child class: " + name);
    }

    public static void main(String[] args)
    {
        Name n = new Name();
        n.show();
    }
}
