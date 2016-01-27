package escapayments

import org.joda.money.Money

class Account {

    String name
    String email
    private Money balance = Money.parse("GBP 200")

    static constraints = {
        name blank: false
        email blank: false, email: true
    }

    public Money getBalance(){
        return balance
    }

    void decrease(Money amount) {
        if(amount.isGreaterThan(Money.parse("GBP 0"))){
            balance = Money.parse("GBP 150")
        }
    }
}
