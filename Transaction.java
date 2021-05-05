public class Transaction extends Thread {
    private final int idTransaction;
    private final double sumOfTransaction;
    private Account FROM;
    private Account TO;
    private Bank bank;
    private boolean completed = false;

    public Transaction(Account from,Account to,double sumOfTransaction,Bank bank) {
        this.FROM = from;
        this.TO = to;
        this.sumOfTransaction = sumOfTransaction;
        this.bank = bank;
        this.idTransaction = initIdTransaction();
    }

    public Transaction(BankPersonalAccount from,BankPersonalAccount to,double sumOfTransaction,Bank bank){
        this.FROM = from.getMyAccount();
        this.TO = to.getMyAccount();
        this.sumOfTransaction = sumOfTransaction;
        this.bank = bank;
        this.idTransaction = initIdTransaction();
    }

    private int initIdTransaction(){
        return  (int) (Math.random() * 1_000_000_000);
    }


    private void transferMoney(){
        if (FROM.abilityToWithdraw(sumOfTransaction)){
            FROM.setBalance(FROM.getBalance() - sumOfTransaction);
            TO.setBalance(TO.getBalance() + sumOfTransaction);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void run() {
        try {
            synchronized (this) {
                transferMoney();
                System.out.println("Transaction with id " + idTransaction + " completed!");
                this.completed = true;
            }
        }
        catch (IllegalArgumentException exception){
            System.out.println("Transaction failed, not enough money on " + FROM.toString() +
                    "( wanted " + sumOfTransaction + " $ )");
        }
        finally {
            bank.addTransaction(this);
        }
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "idTransaction=" + idTransaction +
                ", sumOfTransaction=" + sumOfTransaction +
                "$, FROM=" + FROM +
                ", TO=" + TO +
                ", bank=" + bank +
                ", completed=" + completed +
                '}';
    }
}
