package bankingsystem;

import java.util.Scanner;

// ================= Super Class =================
class Account {

    private String accNumber;
    private String name;
    protected double balance;
    private String mobNum;
    private String add;
    private String dob;

    public Account() {
    }

    public Account(String accNumber, String name, String mobNum, String add, String dob) {
        this.accNumber = accNumber;
        this.name = name;
        this.mobNum = mobNum;
        this.add = add;
        this.dob = dob;
    }

    public void setMobNum(String mobNum) {
        this.mobNum = mobNum;
    }

    public double getBalance() {
        return balance;
    }

    public String getMobNum() {
        return mobNum;
    }

    public String getAccNum() {
        return accNumber;
    }

    public void showDetails() {
        System.out.println("================================");
        System.out.println("        ACCOUNT DETAILS          ");
        System.out.println("================================");
        System.out.println("Name           : " + name);
        System.out.println("Account Number : " + accNumber);
        System.out.println("Mobile Number  : " + mobNum);
        System.out.println("Address        : " + add);
        System.out.println("Date of Birth  : " + dob);
    }
}

// ================= Sub Class =================
class SavingsAccount extends Account {

    public SavingsAccount(String accNumber, String name, String mobNum, String add, String dob) {
        super(accNumber, name, mobNum, add, dob);
    }

    public void deposit(double amt) {
        balance += amt;
        System.out.println("--------------------------------");
        System.out.println(" Amount Deposited Successfully ");
        System.out.println("--------------------------------");
    }

    public void withdraw(double amt) {
        if (amt > balance) {
            System.out.println("--------------------------------");
            System.out.println(" Insufficient Balance ");
            System.out.println("--------------------------------");
            return;
        }
        balance -= amt;
        System.out.println("--------------------------------");
        System.out.println(" Amount Withdrawn Successfully ");
        System.out.println("--------------------------------");
    }

    public void show() {
        showDetails();
        System.out.println("Current Balance: " + balance);
        System.out.println("================================");
    }
}

// ================= Main Class =================
public class BankingSystem {

    public static void main(String[] args) {

        SavingsAccount s[] = new SavingsAccount[100];
        Scanner sc = new Scanner(System.in);

        int count = 0;
        int choice;

        do {
            System.out.println("\n======================================     ");
            System.out.println("        ONLINE BANKING SYSTEM MENU      ");
            System.out.println("========================================        ");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. More Options");
            System.out.println("5. Show Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    if (count >= s.length) {
                        System.out.println("Account limit reached!");
                        break;
                    }

                    sc.nextLine();
                    System.out.print("Enter Name           : ");
                    String name = sc.nextLine();
                    System.out.print("Enter Mobile Number  : ");
                    String mn = sc.nextLine();
                    System.out.print("Enter Address        : ");
                    String add = sc.nextLine();
                    System.out.print("Enter Date of Birth  : ");
                    String dob = sc.nextLine();

                    String accNum = "BOB" + count;
                    s[count] = new SavingsAccount(accNum, name, mn, add, dob);

                    System.out.println("--------------------------------");
                    System.out.println(" Account Credited Successfully ");
                    System.out.println(" Account Number : " + accNum);
                    System.out.println("--------------------------------");

                    count++;
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter Account Number : ");
                    String ac = sc.nextLine();
                    boolean found = false;

                    for (int i = 0; i < count; i++) {
                        if (s[i].getAccNum().equals(ac)) {
                            System.out.print("Enter Amount : ");
                            double amt = sc.nextDouble();
                            s[i].deposit(amt);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Invalid Account Number");
                    }
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Enter Account Number : ");
                    String acc = sc.nextLine();
                    found = false;

                    for (int i = 0; i < count; i++) {
                        if (s[i].getAccNum().equals(acc)) {
                            System.out.print("Enter Amount : ");
                            double amt = sc.nextDouble();
                            s[i].withdraw(amt);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Invalid Account Number");
                    }
                    break;

                case 4:
                    int ch;
                    do {
                        System.out.println("\n----------- MORE OPTIONS -----------");
                        System.out.println("1. Check Balance");
                        System.out.println("2. Update Mobile Number");
                        System.out.println("3. Search Account by Mobile");
                        System.out.println("4. Back");
                        System.out.print("Enter choice : ");
                        ch = sc.nextInt();

                        switch (ch) {

                            case 1:
                                sc.nextLine();
                                System.out.print("Enter Account Number : ");
                                String a = sc.nextLine();
                                found = false;

                                for (int i = 0; i < count; i++) {
                                    if (s[i].getAccNum().equals(a)) {
                                        System.out.println("Balance : " + s[i].getBalance());
                                        found = true;
                                        break;
                                    }
                                }
                                if (!found) {
                                    System.out.println("Invalid Account Number");
                                }
                                break;

                            case 2:
                                sc.nextLine();
                                System.out.print("Enter Account Number : ");
                                String acNum = sc.nextLine();
                                found = false;

                                for (int i = 0; i < count; i++) {
                                    if (s[i].getAccNum().equals(acNum)) {
                                        System.out.print("Enter New Mobile Number : ");
                                        String mob = sc.nextLine();
                                        s[i].setMobNum(mob);
                                        System.out.println("Mobile Number Updated");
                                        found = true;
                                        break;
                                    }
                                }
                                if (!found) {
                                    System.out.println("Invalid Account Number");
                                }
                                break;

                            case 3:
                                sc.nextLine();
                                System.out.print("Enter Mobile Number : ");
                                String mobNum = sc.nextLine();
                                found = false;

                                for (int i = 0; i < count; i++) {
                                    if (s[i].getMobNum().equals(mobNum)) {
                                        System.out.println("Account Number : " + s[i].getAccNum());
                                        found = true;
                                    }
                                }
                                if (!found) {
                                    System.out.println("No account found");
                                }
                                break;

                            case 4:
                                break;

                            default:
                                System.out.println("Invalid Choice");
                        }
                    } while (ch != 4);
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Enter Account Number : ");
                    String aNum = sc.nextLine();
                    found = false;

                    for (int i = 0; i < count; i++) {
                        if (s[i].getAccNum().equals(aNum)) {
                            s[i].show();
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Invalid Account Number");
                    }
                    break;

                case 6:
                    System.out.println("--------------------------------");
                    System.out.println(" Thank you for using Online Banking System ");
                    System.out.println("--------------------------------");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 6);
    }
}
