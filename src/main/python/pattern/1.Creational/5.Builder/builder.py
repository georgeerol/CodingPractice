"""
Intent
* Separate the construction of a complex object from its representation so that the same construction process can create
different representations

Problem
* Construction of complex object which requires different representations

Solution
* Come up with way to create complex  object in steps
* Construction process should be separated from representation of object
* Provide a way for different representation of object

"""


class Director:
    def __init__(self):
        self.builder = None

    def set_builder(self, builder_obj):
        self.builder = builder_obj

    def construct(self, name):
        if name == 'Product1':
            self.builder.create()
            self.builder.build_part_a()
            self.builder.build_part_b()
        elif name == 'Product2':
            self.builder.create()
            self.builder.build_part_c()


class Builder:
    def create(self):
        raise NotImplementedError("create() must be defined in subclass")

    def build_part_a(self):
        raise NotImplementedError("build_part_a() must be defined in subclass")

    def build_part_b(self):
        raise NotImplementedError("build_part_b() must be defined in subclass")

    def build_part_c(self):
        raise NotImplementedError("build_part_c() must be defined in subclass")

    def build_part_d(self):
        raise NotImplementedError("build_part_d() must be defined in subclass")


class ConcreteBuilder1(Builder):
    def __init__(self):
        self.product = None

    def create(self):
        self.product = Product1()

    def build_part_a(self):
        pass

    def build_part_b(self):
        pass

    def build_part_c(self):
        pass

    def build_part_d(self):
        pass

    def get_product(self):
        return self.product


class ConcreteBuilder2(Builder):
    def __init__(self):
        self.product = None

    def create(self):
        self.product = Product2()

    def build_part_a(self):
        pass

    def build_part_b(self):
        pass

    def build_part_c(self):
        pass

    def build_part_d(self):
        pass

    def get_product(self):
        return self.product


class Product1:
    def use_product(self):
        print("Inside Product1:useProduct()")


class Product2:
    def use_product(self):
        print("Inside product2:UserProduct()")


director = Director()

builder1 = ConcreteBuilder1()
director.set_builder(builder1)
director.construct('Product1')
prod1 = builder1.get_product()
prod1.use_product()

builder2 = ConcreteBuilder2()
director.set_builder(builder2)
director.construct('Product2')
prod2 = builder2.get_product()
prod2.use_product()
