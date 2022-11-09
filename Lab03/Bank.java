import java.util.ArrayList;

public class Bank {
    private final ArrayList<Account> members = new ArrayList<>();

    public void createAccount(String id){
        members.add(new Account(id, new Amount(0)));
    }
    @Override
    public String toString() {
        StringBuilder temp = new StringBuilder();
        for(Account account: members) temp.append(account).append(" ; ");
        return temp.toString();
    }
    public void paymentIntoAccount(String id, Amount x){
        for(Account account: members){
            if(id.equals(account.getId())){
                account.setBalance(x);
            }
        }
    }
    public void paymentFromAccount(String id, Amount x){
        Amount copy = new Amount(x.getVal());
        for(Account account: members){
            if(id.equals(account.getId())){
                account.setBalance(Amount.subtract(account.getBalance(), copy));
            }
        }
    }
    public Amount accountBalance(String id){
        for(Account account: members){
            if(id.equals(account.getId())){
                return new Amount(account.getBalance().getVal());
            }
        }
        return null;
    }
}
