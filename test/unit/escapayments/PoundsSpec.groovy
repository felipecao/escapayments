package escapayments

import org.joda.money.Money
import spock.lang.Specification

/**
 * Created by felipe on 1/27/16.
 */
class PoundsSpec extends Specification {

    def "amount returns a money instance of 200"(){
        expect:
        Money.parse("GBP 200") == Pounds.amount(200)
    }

    def "amount returns a money instance of 500"(){
        expect:
        Money.parse("GBP 500") == Pounds.amount(500)
    }

}
