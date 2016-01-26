package escapayments

import org.joda.money.Money

class Transaction {

    Account from
    Account to
    Money amount

    static constraints = {
    }
}
