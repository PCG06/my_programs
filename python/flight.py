"""
    Program 12:
    Python script to create a class to update flight attributes and book tickets
    using setattr() and getattr()
"""

class Skyway: # Airline name
    flight_no = int(input("Flight no: "))
    origin = input("Origin: ")
    destination = input("Destination: ")
    fare = int(input("Fare: "))
    tickets = int(input("Tickets: "))
    meal = input("Meal: ")
    itenary = input("Itenary: ")

    @classmethod
    def display(cls):
        print("\nThe flight information:")
        print("Flight no:", getattr(Skyway, "flight_no"))
        print("Origin:", getattr(Skyway, "origin"))
        print("Destination:", getattr(Skyway, "destination"))
        print("Fare:", getattr(Skyway, "fare"))
        print("Tickets:", getattr(Skyway, "tickets"))
        print("Meal:", getattr(Skyway, "meal"))
        print("Itenary:", getattr(Skyway, "itenary"))
        print()

    @classmethod
    def baggage(cls):
        setattr(Skyway, "check_in", "15Kg")
        setattr(Skyway, "cabin", "7Kg")
        print("Baggage:")
        print("Check-in:", getattr(Skyway, "check_in"))
        print("Cabin:", getattr(Skyway, "cabin"))

    def bookTickets(self, name, ntickets):
        self.name = name
        self.ntickets = ntickets

        if (self.ntickets <= Skyway.tickets):
            Skyway.tickets -= self.ntickets
            self.cost = self.ntickets * int(Skyway.fare)
            print(f"Passenger name: {self.name}")
            print(f"Ticket fare: {self.cost}")
            print("Thank you!")
        else:
            print("Sorry! Too many tickets!")

Skyway.display()
s = Skyway()

while True:
    print("\n---Flight Menu---")
    print("1. Update fare\n"
        "2. Display baggage\n"
        "3. Update itenary\n"
        "4. Book tickets\n"
        "5. Exit\n")
    ch = int(input("Enter your choice: "))

    # 1. Update tickets
    if ch == 1:
        fare = int(input("Enter updated fare: "))
        setattr(Skyway, "fare", fare)
        print(f"Fare updated to {Skyway.fare}")

    # 2. Display baggage
    elif ch == 2:
        Skyway.baggage()

    # 3. Update itenary
    elif ch == 3:
        itenary = input(f"Enter itenary for flight no {Skyway.flight_no}: ")
        setattr(Skyway, "itenary", itenary)
        print(f"Iternary updated to {Skyway.itenary}")

    # 4. Book tickets
    elif ch == 4:
        name = input("Enter passenger name: ")
        ntickets = int(input("Enter no. of tickets to be booked: "))
        s.bookTickets(name, ntickets)
        print(f"Tickets remaining for {Skyway.flight_no}: {Skyway.tickets}")

    # 5. Exit
    elif ch == 5:
        print("Exiting...")
        break

    # Default
    else:
        print("Invalid choice! Enter again!")