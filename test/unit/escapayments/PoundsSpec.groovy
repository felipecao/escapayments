package escapayments

import org.joda.money.Money

/**
 * Created by felipe on 1/27/16.
 */
class PoundsSpec {

    def "amount returns a money instance with the specified value"(){
        expect:
        Money.parse("GBP 200") == Pounds.amount(200)
    }

}
