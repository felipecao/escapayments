package escapayments

import org.joda.money.Money
import spock.lang.Specification

/**
 * Created by felipe on 1/27/16.
 */
class PoundsSpec extends Specification {

    def "amount returns a money instance with the specified value"(){
        expect:
        Money.parse("GBP 200") == Pounds.amount(200)
    }

}
