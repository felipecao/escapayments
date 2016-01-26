package escapayments

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.joda.money.Money
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Transaction)
@Mock(Account)
class TransactionSpec extends Specification {

    Transaction transaction

    def setup() {
        mockForConstraintsTests(Transaction)

        transaction = new Transaction()
    }

    void "a Transaction cannot be saved without a 'from' Account"() {
        when:
        transaction.validate()

        then:
        "nullable" == transaction.errors["from"]
    }

    void "a Transaction cannot be saved without a 'to' Account"() {
        when:
        transaction.validate()

        then:
        "nullable" == transaction.errors["to"]
    }

    void "a Transaction cannot be saved without an amount"() {
        when:
        transaction.validate()

        then:
        "nullable" == transaction.errors["amount"]
    }

    void "a Transaction cannot be saved if it exceeds the balance of the 'from' account"() {
        given:
        transaction.from = fromAccount
        transaction.to = toAccount
        transaction.amount = Money.parse("GBP 201")

        when:
        transaction.validate()

        then:
        "from.balanceExceeded" == transaction.errors["amount"]
    }

    void "a Transaction can be saved if it has both 'from' and 'to' accounts, and the amount does not exceed the balance of the 'from' account"() {
        expect: "fix me"
        true == false
    }

    private Account getFromAccount(){
        return new Account(name: "from", email: "from@account.com").save(failOnError: true)
    }

    private Account getToAccount(){
        return new Account(name: "to", email: "to@account.com").save(failOnError: true)
    }
}
