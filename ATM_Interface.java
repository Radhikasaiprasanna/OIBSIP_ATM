import java.util.Scanner;

class Bank_account {
    String name, Username, password, account_no;
    float balance = 100000f;
    int transactions = 0;
    String Transaction_History = "";

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter your name : ");
        this.name = sc.nextLine();
        System.out.println("\nEnter your username : ");
        this.Username = sc.nextLine();
        System.out.println("\nEnter your password : ");
        this.password = sc.nextLine();
        System.out.println("\nEnter your Account Number : ");
        this.account_no = sc.nextLine();
        System.out.println("\nRegistration completed \nKindly Login\n ");
    }

    public boolean login() {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while (!isLogin) {
            System.out.println("\nEnter your user name : ");
            String username = sc.nextLine();
            if (username.equals(Username)) {
                while (!isLogin) {
                    System.out.println("\nEnter your password : ");
                    String Password = sc.nextLine();
                    if (Password.equals(password)) {
                        System.out.println("\nLogin Successful!! : ");
                        isLogin = true;
                    } else {
                        System.out.println("\nIncorrect password");
                    }
                }
            } else {
                System.out.println("\nUser name not found");
            }
        }
        return isLogin;
    }

    public void withdraw() {
        System.out.println("\nEnter amount to withdraw : ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try {
            if (balance >= amount) {
                transactions++;
                balance -= amount;
                System.out.println("\nWithdrawl Successful!! : ");
                String str = amount + "Rs withdrawed\n";
                Transaction_History = Transaction_History.concat(str);
            } else {
                System.out.println("\nInsufficient Balance");
            }
        } catch (Exception e) {
        }
    }

    public void deposit() {
        System.out.println("\nEnter amount to deposit : ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try {
            if (amount <= 100000f) {
                transactions++;
                balance += amount;
                System.out.println("\nSuccessfully Deposited!! : ");
                String str = amount + "Rs deposited\n";
                Transaction_History = Transaction_History.concat(str);
            } else {
                System.out.println("\nSorry.......Limit is 100000.0");
            }
        } catch (Exception e) {
        }
    }

    public void transfer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter recepeint's name : ");
        String recepeint = sc.nextLine();
        System.out.println("\nEnter amount to transfer : ");
        float amount = sc.nextFloat();
        try {
            if (balance >= amount) {
                if (amount <= 5000f) {
                    transactions++;
                    balance -= amount;
                    System.out.println("\nSuccessfully transferred to " + recepeint);
                    String str = amount + "Rs transferred to " + recepeint + "\n";
                    Transaction_History = Transaction_History.concat(str);
                } else {
                    System.out.println("\nSorry.......Limit is 50000.0");
                }
            } else {
                System.out.println("\nInsufficient Balance");
            }
        } catch (Exception e) {
        }
    }

    public void checkbalance() {
        System.out.println("\nBalance is " + balance + " Rs");
    }

    public void transHistory() {
        if (transactions == 0) {
            System.out.println("\nEmpty");
        } else {
            System.out.println("\n" + Transaction_History);
        }
    }
}

public class ATM_Interface {
    public static int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;
        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;
                if (flag && input > limit || input < 1) {
                    System.out.println("\nChoose the number between 1 to " + limit);
                    flag = false;
                }
            } catch (Exception e) {
                System.out.println("\nEnter only integer value");
                flag = false;

            }
        }
        return input;
    }

    public static void main(String[] args) {
        System.out.println("\n****WELCOME TO SBI ATM SYSTEM****\n");
        System.out.println("1.Register \n2.Exit");
        System.out.println("\nEnter your choice ");
        int choice = takeIntegerInput(2);
        if (choice == 1) {
            Bank_account b = new Bank_account();
            b.register();
            while (true) {
                System.out.println("1.Login \n2.Exit");
                System.out.println("\nEnter your choice ");
                int ch = takeIntegerInput(2);
                if (ch == 1) {
                    if (b.login()) {
                        System.out.println("\n****WELCOME BACK " + b.name + " *****\n");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println(
                                    "\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.transaction History \n6.Exit");
                            System.out.println("\nEnter your choice ");
                            int c = takeIntegerInput(6);
                            switch (c) {
                                case 1:
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposit();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.checkbalance();
                                    break;
                                case 5:
                                    b.transHistory();
                                    break;
                                case 6:
                                    isFinished = true;
                                    break;

                            }

                        }
                    }
                } else {
                    System.exit(0);
                }
            }
        } else {
            System.exit(0);
        }
    }
}