package escapayments

import org.joda.money.Money

class Account {

    String name
    String email
    private Money balance = Pounds.amount(200)

    static constraints = {
        name blank: false
        email blank: false, email: true
    }

    public Money getBalance(){
        return balance
    }

    void decrease(Money amount) {
        if(amount.isGreaterThan(Pounds.amount(0))){
            balance = balance.minus(amount)
        }
    }
}
