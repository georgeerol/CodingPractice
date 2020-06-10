from abc import abstractmethod


class Shape:
    @abstractmethod
    def draw(self):
        pass


class Rectangle(Shape):

    def draw(self):
        print("Rectangle::draw()")


class Square(Shape):
    def draw(self):
        print("Square::draw()")


class Circle(Shape):

    def draw(self):
        print("Circle::draw()")


# Facade
class ShapeMaker:
    def __init__(self):
        self.circle = Circle()
        self.rectangle = Rectangle()
        self.square = Square()

    def draw_circle(self):
        self.circle.draw()

    def draw_rectangle(self):
        self.rectangle.draw()

    def draw_square(self):
        self.square.draw()


shape = ShapeMaker()
shape.draw_circle()
shape.draw_rectangle()
shape.draw_rectangle()
