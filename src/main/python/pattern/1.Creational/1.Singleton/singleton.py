class Singleton(object):
    __instance = None

    @classmethod
    def instance(cls):
        if cls.__instance is None:
            cls.__instance = Singleton()
        return cls.__instance

    def __init__(self):
        self.data = None
        if self.__instance:
            raise ValueError("A Singleton instance is already existing")

    def set_data(self, num):
        self.data = num

    def get_data(self):
        return self.data


Singleton.instance().set_data(10)
print("Data: {}".format(Singleton.instance().get_data()))
