package escapayments

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Transaction)
@Mock(Account)
class TransactionSpec extends Specification {

    def setup() {
        mockForConstraintsTests(Transaction)
    }

    def cleanup() {
    }

    void "a Transaction cannot be saved without a 'from' Account"() {
        given:
        Transaction transaction = new Transaction()

        when:
        transaction.validate()

        then:
        "nullable" == transaction.errors["from"]
    }

    void "a Transaction cannot be saved without a 'to' Account"() {
        expect: "fix me"
        true == false
    }

    void "a Transaction cannot be saved without an amount"() {
        expect: "fix me"
        true == false
    }

    void "a Transaction cannot be saved if it exceeds the balance of the 'from' account"() {
        expect: "fix me"
        true == false
    }

    void "a Transaction can be saved if it has both 'from' and 'to' accounts, and the amount does not exceed the balance of the 'from' account"() {
        expect: "fix me"
        true == false
    }
}
