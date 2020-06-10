from abc import ABCMeta, abstractmethod
import copy


class Course(metaclass=ABCMeta):

    def __init__(self):
        self.id = None
        self.type = None

    @abstractmethod
    def course(self):
        pass

    def get_type(self):
        return self.type

    def get_id(self):
        return self.id

    def set_id(self, sid):
        self.id = sid

    def clone(self):
        return copy.copy(self)


class DataStructure(Course):
    def __init__(self):
        super().__init__()
        self.type = "Data Structure"

    def course(self):
        print("Inside DataStructure::course() method")


class SystemDesign(Course):
    def __init__(self):
        super().__init__()
        self.type = "System Design"

    def course(self):
        print("Inside SystemDesign::course() method")


class DesignPattern(Course):

    def __init__(self):
        super().__init__()
        self.type = "Design Pattern"

    def course(self):
        print("Inside DesignPattern::course() method")


class CourseCache:
    cache = {}

    @staticmethod
    def get_course(sid):
        COURSE = CourseCache.cache.get(sid, None)
        return COURSE.clone()

    @staticmethod
    def load():
        system_design = SystemDesign()
        system_design.set_id("1")
        CourseCache.cache[system_design.get_id()] = system_design

        data_structure = DataStructure()
        data_structure.set_id("2")
        CourseCache.cache[data_structure.get_id()] = data_structure

        design_pattern = DesignPattern()
        design_pattern.set_id("3")
        CourseCache.cache[design_pattern.get_id()] = design_pattern


if __name__ == '__main__':
    CourseCache.load()

    system_design = CourseCache.get_course("1")
    print(system_design.get_type())

    data_structure = CourseCache.get_course("2")
    print(data_structure.get_type())

    design_pattern = CourseCache.get_course("3")
    print(design_pattern.get_type())
