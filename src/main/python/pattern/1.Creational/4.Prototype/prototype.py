import copy
from abc import abstractmethod


class Prototype:
    _type = None
    _value = None

    def get_type(self):
        return self._type

    def get_value(self):
        return self._value

    def clone(self):
        pass


class Type1(Prototype):
    def __init__(self, number):
        self._type = "Type1"
        self._value = number

    def clone(self):
        return copy.copy(self)


class Type2(Prototype):
    def __init__(self, number):
        self._type = "Type2"
        self._value = number

    def clone(self):
        return copy.copy(self)


class ObjectFactory:
    __type1Value1 = None
    __type1Value2 = None
    __type2Value1 = None
    __type2Value2 = None

    @staticmethod
    def initialize():
        ObjectFactory.__type1Value1 = Type1(1)
        ObjectFactory.__type1Value2 = Type1(2)
        ObjectFactory.__type2Value1 = Type2(1)
        ObjectFactory.__type2Value2 = Type2(2)

    @staticmethod
    def get_type_1_value_1():
        return ObjectFactory.__type1Value1.clone()

    @staticmethod
    def get_type_1_value_2():
        return ObjectFactory.__type1Value2.clone()

    @staticmethod
    def get_type_2_value_1():
        return ObjectFactory.__type2Value1.clone()

    @staticmethod
    def get_type_2_value_2():
        return ObjectFactory.__type2Value2.clone()


ObjectFactory.initialize()

instance = ObjectFactory.get_type_1_value_1()
print("%s: %s" % (instance.get_type(), instance.get_value()))

instance = ObjectFactory.get_type_1_value_2()
print("%s: %s" % (instance.get_type(), instance.get_value()))

instance = ObjectFactory.get_type_2_value_1()
print("%s: %s" % (instance.get_type(), instance.get_value()))

instance = ObjectFactory.get_type_2_value_2()
print("%s: %s" % (instance.get_type(), instance.get_value()))
