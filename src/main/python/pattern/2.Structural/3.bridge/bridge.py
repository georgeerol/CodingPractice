from abc import abstractmethod


class DrawAPI:
    @abstractmethod
    def draw_circle(self, radius, x, y):
        pass


class RedCircle(DrawAPI):

    def draw_circle(self, radius, x, y):
        print("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]")


class GreenCircle(DrawAPI):

    def draw_circle(self, radius, x, y):
        print("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]")


class Shape:
    def __init__(self, draw_api):
        self.draw_api = draw_api

    @abstractmethod
    def draw(self):
        pass


class Circle(Shape):

    def __init__(self, x, y, radius, draw_api):
        super().__init__(draw_api)
        self.x = x
        self.y = y
        self.radius = radius

    def draw(self):
        self.draw_api.drawCircle(self.radius, self.x, self.y)


redCircle = Circle(100, 100, 10, RedCircle())
greenCircle = Circle
