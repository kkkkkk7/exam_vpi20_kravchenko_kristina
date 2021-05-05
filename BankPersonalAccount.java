public class BankPersonalAccount {
    private String name;
    public Bank bank;
    private final Account myAccount;

    public BankPersonalAccount() {
        this.myAccount = initAccount();
    }

    public BankPersonalAccount(String name) {
        this.name = name;
        this.myAccount = initAccount();
    }

    public BankPersonalAccount(String name, Bank bank, Account myAccount) {
        this.name = name;
        this.bank = bank;
        this.myAccount = myAccount;
    }

    private Account initAccount(){
        return new Account();
    }

    public Account getMyAccount() {
        return myAccount;
    }

    public double getBalanceOnAccount(){
        return myAccount.getBalance();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name==null) System.out.println("Sorry,but name can not have null value.");
        else if (name.trim().isEmpty()) System.out.println("Sorry,but name can not be empty.");
        else this.name = name;
    }
}
