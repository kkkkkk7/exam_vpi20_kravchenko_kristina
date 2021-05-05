public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bank bank = new Bank("ParisBankCentral");

        Account a1 = new Account();
        Account a2 = new Account();
        Account a3 = new Account();

        for (int i = 0; i < 7; i++) {
            new Transaction(a1, a2, Round.roundDoubleTo2PlacesAfterSign(Math.random()*100_000), bank).start();
            new Transaction(a3, a2, Round.roundDoubleTo2PlacesAfterSign(Math.random()*100_000), bank).start();
            new Transaction(a2, a3, Round.roundDoubleTo2PlacesAfterSign(Math.random()*100_000), bank).start();
        }

        Thread.sleep(3000);

        System.out.println(bank.showAllTransactions());
    }
}
