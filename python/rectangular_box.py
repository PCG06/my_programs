"""
    Program 15:
    Python script to create a class Rectangle to find area and perimeter,
    and a child class Box to find its surface area (override area() and volume
"""

class Rectangle:
    def __init__(self, length, width):
        self.length = length
        self.width = width

    def area(self):
        return self.length * self.width
    
    def perimeter(self):
        return 2 * (self.length + self.width)
    
class Box(Rectangle):
    def __init__(self, length, width, height):
        super().__init__(length, width)
        self.height = height

    # Overriding area() method from parent class
    def area(self):
        return 2 * ((self.length * self.width)
                 + (self.length * self.height)
                 + (self.width * self.height))
    
    def volume(self):
        return self.length * self.width * self.height
    
l, w, h = map(float, input("Enter length, width and height: ").split())
r = Rectangle(l, w)
b = Box(l, w, h)
print("Area of rectangle:", r.area())
print("Perimeter of rectangle:", r.perimeter())
print("Surface area of box:", b.area())
print("Volume of box:", b.volume())
