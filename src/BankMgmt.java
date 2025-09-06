/*
Program 13:
    - Create an interface Bank with minimum balance.
    - Create a class Customer with methods to set and display customer details.
    - Create a child class Transaction from class Customer and interface Bank to set and check balance, deposit and withdraw.
    - Create the main class to accept input for customer details, deposit and withdrawal.
*/

import java.util.Scanner;

interface Bank
{
    int minBalance = 1000;
    void checkBalance();
}

class Customer
{
    int custId;
    String custName, accType;

    void setCustomer(int id, String name, String type)
    {
        custId = id;
        custName = name;
        accType = type;
    }

    void putCustomer()
    {
        System.out.println("\n---Customer details---");
        System.out.println("Customer ID: " + custId);
        System.out.println("Customer name: " + custName);
        System.out.println("Account type: " + accType);
    }
}

class Transaction extends Customer implements Bank
{
    double bal;

    void setBalance(double b)
    {
        bal = b;
    }

    public void checkBalance()
    {
        System.out.println("Your balance is " + bal);
    }

    void deposit(double dep)
    {
        bal += dep;
        System.out.println("Deposited " + dep);
        checkBalance();
    }

    void withdraw(double with)
    {
        if ((bal - with) < minBalance)
        {
            System.out.println("Maintain minimum balance!");
        }
        else
        {
            bal -= with;
            System.out.println("Withdrawn " + with);
            checkBalance();
        }
    }
}

public class BankMgmt
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Transaction t = new Transaction();

        System.out.print("Enter customer id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter customer name: ");
        String name = sc.nextLine();
        System.out.print("Enter account type (SB,RD,FD): ");
        String type = sc.nextLine();
        t.setCustomer(id, name, type);
        t.putCustomer();

        System.out.print("\nEnter opening balance: ");
        t.setBalance(sc.nextDouble());

        System.out.print("Enter amount to be deposited: ");
        t.deposit(sc.nextDouble());

        System.out.print("\nEnter amount to be withdrawn: ");
        t.withdraw(sc.nextDouble());

        sc.close();
    }
}
