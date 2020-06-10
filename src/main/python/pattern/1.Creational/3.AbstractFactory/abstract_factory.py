"""
Intent
* Provide an interface for creating families of related or dependent object without specifying their concrete classes

Problem
* Instantiation of families of related objects

Solution
* Come up with a way to create the family of objects
* Separate the instantiation of objects from use

"""
from abc import abstractmethod


class AbstractFactory:
    @abstractmethod
    def create_product_a(self):
        raise NotImplementedError("create_product_a() must be defined in subclass")

    @abstractmethod
    def create_product_b(self):
        raise NotImplementedError("create_product_b() must be defined in subclass")


class ConcreteFactory1(AbstractFactory):
    def create_product_a(self):
        return ProductA1()

    def create_product_b(self):
        return ProductB1()


class ConcreteFactory2(AbstractFactory):
    def create_product_a(self):
        return ProductA2()

    def create_product_b(self):
        return ProductB2()


class AbstractProduct1:
    @abstractmethod
    def display(self):
        raise NotImplementedError("Display() must be define in subclass")


class ProductA1(AbstractProduct1):
    def display(self):
        print("Inside ProductA1:Display()")


class ProductB1(AbstractProduct1):
    def display(self):
        print("Inside ProductB1:Display()")


class AbstractProduct2:
    def display(self):
        raise NotImplementedError("Display()must be define in subclass")


class ProductA2(AbstractProduct2):
    def display(self):
        print("Inside ProductA2:Display()")


class ProductB2(AbstractProduct2):
    def display(self):
        print("Inside ProductB2:Display()")


# Series 1 products
factory1 = ConcreteFactory1()
prod1 = factory1.create_product_a()
prod1.display()
prod2 = factory1.create_product_b()
prod2.display()

# Series 2 products
factory2 = ConcreteFactory2()
prod1 = factory2.create_product_a()
prod1.display()
prod2 = factory2.create_product_b()
prod2.display()
