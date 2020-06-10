class Order:
    def execute(self):
        pass


class Stock:
    def __init__(self):
        self.name = "ABC"
        self.quantity = 10

    def buy(self):
        print("Stock [ Name: " + self.name + ", Quantity: " + str(self.quantity) + " ] bought")

    def sell(self):
        print("Stock [ Name: " + self.name + ", Quantity: " + str(self.quantity) + " ] sold");


class BuyStock(Order):
    def __init__(self, abc_stock):
        self.abc_stock = abc_stock

    def execute(self):
        self.abc_stock.buy()


class SellStock(Order):

    def __init__(self, abc_stock):
        self.abc_stock = abc_stock

    def execute(self):
        self.abc_stock.sell()

# Command
class Broker:
    def __init__(self):
        self.order_list = []

    def take_order(self, order):
        self.order_list.append(order)

    def place_orders(self):
        for order in self.order_list:
            order.execute()
        self.order_list.clear()


abc_stock = Stock()
buy_stock_order = BuyStock(abc_stock)
sell_stock_order = SellStock(abc_stock)

broker = Broker()
broker.take_order(buy_stock_order)
broker.take_order(sell_stock_order)

broker.place_orders()
