package escapayments

import org.joda.money.Money

class Transaction {

    Account from
    Account to
    Money amount

    static constraints = {
        amount validator: { val, obj, err ->
            if(val.isGreaterThan(obj.from.balance)){
                err.rejectValue("amount", "from.balanceExceeded")
            }
        }
    }
}
