package escapayments

import org.joda.money.Money

/**
 * Created by felipe on 1/27/16.
 */
class Pounds {
    static Money amount(Integer amount) {
        return Money.parse("GBP $amount")
    }
}
