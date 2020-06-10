"""
*Intent*
Define an interface for creating an object, but let subclasses decide wich class to instantiate.
Factory Method lets a class defer instantiation to subclasses

*Problem*
A class has to instantiate subclass of another class but does not know which one

*Solution*
Redefine a method in derived class which will decide which subclass to instantiate

"""


class Product:
    def use_product(self):
        raise NotImplementedError("user_product() must be defined in subclass")


class ConcreteProduct(Product):
    def use_product(self):
        print("Inside ConcreteProduct:use_product()")


class Creator:
    def __init__(self):
        self.product = self.factory_method()

    def factory_method(self):
        raise NotImplementedError("FactoryMethod() must be defined in subclass")

    def an_operation(self):
        return self.product


class ConcreteCreator(Creator):
    def factory_method(self):
        return ConcreteProduct()


prodCreator = ConcreteCreator()
prod = prodCreator.an_operation()
prod.use_product()
