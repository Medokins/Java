public class Main {
    public static void main(String[] args) {
        Amount x1 = new Amount( 9, 99 );
        Amount x2 = new Amount( 2, 07 );
        Amount x3 = new Amount( 0, 12 );
        System.out.println("1a) " + x1 + " ; " + x2 + " ; " + x3);
        Amount y1 = Amount.add(x1, x3);
        System.out.println("1b) " + x1 + " + " + x3 + " = " + y1);
        y1 = Amount.subtract(x2, x3);
        System.out.println("1b) " + x2 + " - " + x3 + " = " + y1);
        System.out.println();

        String id = "12 3456 7899";
        Account account1 = new Account(id, x1);
        System.out.println("2a) " + account1);
        x1.set( 0, 00 );
        System.out.println("2b) " + account1);
        Amount x5 = account1.getBalance();
        x5.set( -1000, 00 );
        System.out.println("2c) " + account1);
        account1.setBalance( new Amount(99, 11) );
        System.out.println("2d) " + account1);
        System.out.println();

        Bank bank = new Bank();
        bank.createAccount("22 8765 0001");
        bank.createAccount("33 8765 0002");
        System.out.println("3a) " + bank);
        x1.set( 9, 99 );
        bank.paymentIntoAccount("22 8765 0001", x1);
        bank.paymentIntoAccount("33 8765 0002", x1);
        System.out.println("3b) " + bank);
        bank.paymentFromAccount("22 8765 0001", x2);
        System.out.println("3c) " + bank);
        y1 = bank.accountBalance("33 8765 0002");
        y1.set(0,0);
        System.out.println("3d) " + bank);
    }
}
