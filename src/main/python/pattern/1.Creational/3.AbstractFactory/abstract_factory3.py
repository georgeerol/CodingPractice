import random


class Course:
    """ GeeksforGeeks portal for courses """

    def __init__(self, courses_factory=None):
        """course factory is out abstract factory"""

        self.course_factory = courses_factory

    def show_course(self):
        """creates and shows courses using the abstract factory"""

        course = self.course_factory()

        print('We have a course named {}'.format(course))
        print('its price is {}'.format(course.Fee()))


class DataStructure:

    def Fee(self):
        return 11000

    def __str__(self):
        return "Data Structure"


class SystemDesign:

    def Fee(self):
        return 8000

    def __str__(self):
        return "System Design"


class DesignPattern:

    def Fee(self):
        return 15000

    def __str__(self):
        return 'Design Pattern'


def random_course():
    """A random class for choosing the course"""

    return random.choice([DesignPattern, SystemDesign, DataStructure])()


if __name__ == "__main__":

    course = Course(random_course)

    for i in range(5):
        course.show_course()
