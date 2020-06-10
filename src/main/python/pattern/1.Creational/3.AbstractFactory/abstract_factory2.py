from abc import abstractmethod, ABC


class Shape:

    @abstractmethod
    def draw(self):
        raise NotImplementedError("draw() must be defined in subclass")
        pass


class RoundedRectangle(Shape):

    def draw(self):
        print("Inside RoundedRectangle::draw() method.")


class RoundedSquare(Shape):
    def draw(self):
        print("Inside RoundedSquare::draw() method.")


class Rectangle(Shape):
    def draw(self):
        print("Inside Rectangle::draw() method.")


class Square(Shape):
    def draw(self):
        print("Inside Square::draw() method.")


class AbstractFactory(Shape):

    @abstractmethod
    def get_shape(self, shape_type):
        raise NotImplementedError("get_shape() mut be defined in sublass")
        pass


class ShapeFactory(AbstractFactory, ABC):

    def get_shape(self, shape_type):
        if shape_type == "RECTANGLE":
            return Rectangle()
        elif shape_type == "SQUARE":
            return Square()
        else:
            return None


class RoundedShapeFactory(AbstractFactory, ABC):

    def get_shape(self, shape_type):
        if shape_type == "RECTANGLE":
            return RoundedRectangle()
        elif shape_type == "SQUARE":
            return RoundedSquare()


class FactoryProducer(AbstractFactory, ABC):

    @staticmethod
    def get_factory(rounded):
        if rounded:
            return RoundedShapeFactory()
        else:
            return ShapeFactory()


# get shape factory
shape_factory = FactoryProducer.get_factory(False)
# get an object of Shape Rectangle
shape1 = shape_factory.get_shape("RECTANGLE")
# call draw method of Shape Rectangle
shape1.draw()

shape2 = shape_factory.get_shape("SQUARE")
shape2.draw()

shape_factory1 = FactoryProducer.get_factory(True)
shape3 = shape_factory1.get_shape("RECTANGLE")
shape3.draw()
shape4 = shape_factory1.get_shape("SQUARE")
shape4.draw()
