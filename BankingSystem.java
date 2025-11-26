import java.util.*;
class Customer
{
    String cname;
    int balance;
    int loanAmt;

    void showCustomer() {
        System.out.println("Name: " + cname + "  Balance: " + balance + "  Loan: " + loanAmt);
    }
}

class Bank
{
    String bname;
    int totalBal;

    void showBank() {
        System.out.println("Bank: " + bname + "  Total Balance: " + totalBal);
    }

    void deposit(Customer c, int amt) {
        c.balance += amt;
        totalBal += amt;
    }

    void withdraw(Customer c, int amt) {
        c.balance -= amt;
        totalBal -= amt;
    }
}

class ATM
{
    String atmLoc;
    int atmBal;

    void showATM() {
        System.out.println("ATM Location: " + atmLoc + "  ATM Balance: " + atmBal);
    }

    void atmWithdraw(Customer c, Bank b, int amt) {
        c.balance -= amt;
        b.totalBal -= amt;
        atmBal -= amt;
    }
}

class LoanDept
{
    int loanGiven;

    void showLoanDept() {
        System.out.println("Loan Given: " + loanGiven);
    }

    void applyLoan(Customer c, int amt) {
        c.loanAmt += amt;
        c.balance += amt;
        loanGiven += amt;
    }
}

class BankingSystem
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Customer c1 = new Customer();
        Bank b = new Bank();
        ATM atm = new ATM();
        LoanDept ld = new LoanDept();

        // Taking Inputs
        System.out.print("Enter Customer Name: ");
        c1.cname = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        c1.balance = sc.nextInt();

        c1.loanAmt = 0;

        System.out.print("Enter Bank Name: ");
        sc.nextLine(); 
        b.bname = sc.nextLine();

        System.out.print("Enter Bank Total Balance: ");
        b.totalBal = sc.nextInt();

        System.out.print("Enter ATM Location: ");
        sc.nextLine();
        atm.atmLoc = sc.nextLine();

        System.out.print("Enter ATM Balance: ");
        atm.atmBal = sc.nextInt();

        ld.loanGiven = 0;

        System.out.println("\n----- Before Transactions -----");
        c1.showCustomer();
        b.showBank();
        atm.showATM();
        ld.showLoanDept();

        // Perform Transactions
        System.out.print("\nEnter Deposit Amount: ");
        int dAmt = sc.nextInt();
        b.deposit(c1, dAmt);

        System.out.print("Enter ATM Withdraw Amount: ");
        int wAmt = sc.nextInt();
        atm.atmWithdraw(c1, b, wAmt);

        System.out.print("Enter Loan Amount: ");
        int lAmt = sc.nextInt();
        ld.applyLoan(c1, lAmt);

        System.out.println("\n----- After Transactions -----");
        c1.showCustomer();
        b.showBank();
        atm.showATM();
        ld.showLoanDept();

        
    }
}
