"""
    Program 14:
    Python script to book a guest house and rent a vehicle using abstract class and method
"""

from abc import ABC, abstractmethod

class Tourism(ABC):
    gh_rent = int(input("Enter guesthouse rent per day: "))
    vh_rent = int(input("Enter vehicle rent per KM: "))

    def __init__(self, name):
        self.name = name

    @abstractmethod
    def booking(value):
        pass

class Guesthouse(Tourism):
    def __init__(self, name, guests):
        super().__init__(name)
        self.guests = guests

    def booking(self, value):
        self.days = value
        print("Customer name:", self.name)
        print("No. of people staying:", self.guests)
        rent = self.days * Tourism.gh_rent * self.guests
        print("Total rent of guesthouse: Rs", rent)

class Vehicle(Tourism):
    def __init__(self, name):
        super().__init__(name)

    def booking(self, value):
        self.kms = value
        print("Customer name:", self.name)
        print("Kilometers traveled:", self.kms)
        
        if self.kms < 25:
            rent = 400 + (25 * Tourism.vh_rent)
        else:
            rent = 400 + (self.kms * Tourism.vh_rent)
        print("Total rent of vehicle: Rs", rent)

print("\nGuesthouse booking")
guest = Guesthouse(input("Enter guest name: "), int(input("Enter no. of guests: ")))
guest.booking(int(input("Enter no. of days stayed: ")))
print("\nVehicle booking")
cust = Vehicle(input("Enter customer name: "))
cust.booking(int(input("Enter no. of KMs traveled: ")))