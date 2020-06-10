from abc import abstractmethod


class Shape:

    @abstractmethod
    def draw(self):
        raise NotImplementedError("draw() must be defined in subclass")
        pass


class Rectangle(Shape):

    def draw(self):
        print("Inside Rectangle::draw() method")


class Square(Shape):

    def draw(self):
        print("Inside Square::draw() method")


class Circle(Shape):

    def __init__(self):
        pass

    def draw(self):
        print("Inside Circle::draw method")


class ShapeFactory:

    @staticmethod
    def get_shape(shape_type):
        if shape_type is None:
            return None
        if shape_type == "Circle":
            return Circle()
        elif shape_type == "Rectangle":
            return Rectangle()
        elif shape_type == "Square":
            return Square()
        else:
            return None


class Client:
    shape_factory = ShapeFactory()
    circle = shape_factory.get_shape("Circle")
    circle.draw()
