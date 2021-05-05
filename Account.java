import java.util.Random;

public class Account {
    private final long idAccount;
    private double balance;

    public Account() {
        this.balance = initAccountValue();
        this.idAccount = initAccountId();
    }

    public Account(double balance){
        this.balance = balance;
        this.idAccount = initAccountId();
    }

    public boolean abilityToWithdraw(double sum){
        return balance > sum ;
    }

    private double initAccountValue(){
        double val = (1 *(new Random().nextDouble() * (1_000_000 - 1) ));

        return Round.roundDoubleTo2PlacesAfterSign(val);
    }


    private long initAccountId(){
        return 1L + (long) (Math.random() * (1_000_000_000 - 1L));
    }

    public void setBalance(double balance) {
        this.balance = Round.roundDoubleTo2PlacesAfterSign(balance);
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                " idAccount=" + idAccount +
                ", balance=" + balance +
                "$ }";
    }
}
