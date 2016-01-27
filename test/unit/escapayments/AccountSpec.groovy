package escapayments

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Account)
class AccountSpec extends Specification {

    Account account

    def setup() {
        mockForConstraintsTests(Account)

        account = new Account()
    }

    void "name cannot be null"() {
        when:
        account.validate()

        then:
        account.hasErrors()
        "nullable" == account.errors["name"]
    }

    void "name cannot be blank"() {
        given:
        account.name = "   "

        when:
        account.validate()

        then:
        account.hasErrors()
        "blank" == account.errors["name"]
    }

    void "email cannot be null"() {
        when:
        account.validate()

        then:
        account.hasErrors()
        "nullable" == account.errors["email"]
    }

    void "email cannot be blank"() {
        given:
        account.email = "   "

        when:
        account.validate()

        then:
        account.hasErrors()
        "blank" == account.errors["email"]
    }

    void "email must be well-formed"() {
        given:
        account.email = "email@example"

        when:
        account.validate()

        then:
        account.hasErrors()
        "email" == account.errors["email"]
    }

    void "starting balance is 200 pounds"() {
        expect:
        Pounds.amount(200) == account.balance
    }

    void "an Account with non-blank name and valid e-mail address is valid and starts with GBP 200"() {
        given:
        account.name = "test account"
        account.email = "email@example.com"

        when:
        Account savedAccount = account.save(failOnError: true)

        then:
        "test account" == savedAccount.name
        "email@example.com" == savedAccount.email
        Pounds.amount(200) == savedAccount.balance
    }

    void "decrease (guess what?) decreases the balance by 50"(){
        when:
        account.decrease(Pounds.amount(50))

        then:
        Pounds.amount(150) == account.balance
    }

    void "balance remains the same when decrease by 0"(){
        when:
        account.decrease(Pounds.amount(0))

        then:
        Pounds.amount(200) == account.balance
    }

    void "balance remains the same when decrease by negative number"(){
        when:
        account.decrease(Pounds.amount(-10))

        then:
        Pounds.amount(200) == account.balance
    }

    void "decrease decreases the balance by 30"(){
        when:
        account.decrease(Pounds.amount(30))

        then:
        Pounds.amount(170) == account.balance
    }

    void "decrease decreases the balance by 20 and save keeps the updated balance"(){
        given:
        account.name = "test account"
        account.email = "email@example.com"
        account.decrease(Pounds.amount(20))

        when:
        Account savedAccount = account.save(failOnError: true)

        then:
        Pounds.amount(180) == savedAccount.balance
    }
}
