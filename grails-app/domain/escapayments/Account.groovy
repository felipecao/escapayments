package escapayments

import org.joda.money.Money

class Account {

    String name
    String email
    Money balance = Money.parse("GBP 200")

    static constraints = {
        name blank: false
        email blank: false, email: true
    }
}
