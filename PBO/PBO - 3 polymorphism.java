import java.util.*;

class Shape 
{
    public void draw() 
    {
        System.out.println("Drawing a Shape");
    }

    public void erase() 
    {
        System.out.println("Erasing a Shape");
    }

    public void newMethod() 
    { 
        System.out.println("This is a new method in Shape");
    } 
}
class Circle extends Shape 
{
    @Override
    public void draw() 
    {
        System.out.println("Drawing a Circle");
    }

    @Override
    public void erase() 
    {
        System.out.println("Erasing a Circle");
    }
    @Override 
    public void newMethod() 
    {
        System.out.println("This is a new method in Circle that overrides the one in Shape");
    } 
}
class Square extends Shape 
{
    @Override
    public void draw() 
    {
        System.out.println("Drawing a Square");
    }

    @Override
    public void erase() 
    {
        System.out.println("Erasing a Square");
    }
}
class Triangle extends Shape 
{
    @Override
    public void draw() 
    {
        System.out.println("Drawing a Triangle");
    }

    @Override
    public void erase() 
    {
        System.out.println("Erasing a Triangle");
    }
}
class Rectangle extends Shape 
{
    @Override
    public void draw() 
    {
        System.out.println("Drawing a Rectangle");
    }

    @Override
    public void erase() 
    {
        System.out.println("Erasing a Rectangle");
    }
}
class Cycle 
{
    public int wheels() 
    {
        return 2; // A standard cycle has 2 wheels
    }

    public void ride() 
    {
        System.out.println("Riding a Cycle with " + wheels() + " wheels.");
    }
}
public class Main 
{
    public static void main(String[] args) 
    {
        Shape s1 = new Circle();
        Shape s2 = new Square();
        Shape s3 = new Triangle();
        Shape s4 = new Rectangle(); // New Shape

        s1.draw(); // Output: Drawing a Circle
        s2.draw(); // Output: Drawing a Square
        s3.draw(); // Output: Drawing a Triangle
        s4.draw(); // Output: Drawing a Rectangle

        s1.newMethod(); // Output: This is a new method in Circle that overrides the one in Shape
        s2.newMethod(); // Output: This is a new method in Shape
        s3.newMethod(); // Output: This is a new method in Shape

        Cycle cycle = new Cycle();
        cycle.ride(); 
    }
}
