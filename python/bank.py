"""
    Program 16:
    Python script to create a bank class and sanction loans using exception handling
"""

class LowIncomeError(Exception):
    pass

class Bank:
    cust_count = 0

    def __init__(self, name, cid):
        self.name = name
        self.cid = cid
    
class Loan(Bank):
    total_fund = 500000
    sanctioned_amt = 0

    def __init__(self, name, cid, income):
        super().__init__(name, cid)
        self.income = income
        self.loan_amt = 0
    
    def sanction_loan(self, amt):
        try:
            if self.income < 25000:
                raise LowIncomeError

            if Loan.total_fund - Loan.sanctioned_amt < amt:
                raise ValueError
            
            self.loan_amt = amt
            Loan.sanctioned_amt += amt
            print(f"Loan of {amt} sanctioned successfully!")
        
        except LowIncomeError:
            print("Loan rejected: Income is too low!")
        
        except ValueError:
            print("Loan rejected: Insufficient bank funds!")

    @classmethod
    def loan_amt_left(cls):
        print("Fund left:", cls.total_fund)

    def display(self):
        print("Name:", self.name)
        print("Customer ID:", self.cid)
        print("Loan ammount:", self.loan_amt)

    @classmethod
    def loan_details(cls):
        print("\n---Bank Loan Summary---")
        print("Total customers:", cls.cust_count)
        print("Total loan fund:", cls.total_fund)
        print("Total loan sanctioned:", cls.sanctioned_amt)
        print("Balance amount:", cls.total_fund - cls.sanctioned_amt)

customers = []
choice = 'Y'

while choice.upper() == 'Y':
    print("---Enter customer details---")
    name = input("Enter customer name: ")
    cid = input("Enter customer ID: ")
    income = int(input("Enter monthly income: "))
    loan = int(input("Enter loan amount: "))

    cust = Loan(name, cid, income)
    cust.sanction_loan(loan)
    cust.loan_amt_left()
    customers.append(cust)
    
    choice = input("\nDo you want to continue? (Y/N): ")
    print()

print("\n---Customer Loan Details---")
for cust in customers:
    cust.display()

Loan.loan_details()
