package escapayments

import org.joda.money.Money
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by felipe on 1/27/16.
 */
@Unroll
class PoundsSpec extends Specification {

    def "amount returns a money instance of #amount"(){
        expect:
        Money.parse(str) == Pounds.amount(amt)

        where:
        str       | amt
        "GBP 200" | 200
        "GBP 500" | 500
    }

}
