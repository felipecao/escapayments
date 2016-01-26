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
        given:
        account.email = "   "

        when:
        account.validate()

        then:
        account.hasErrors()
        "nullable" == account.errors["email"]
    }

    void "email cannot be blank"() {
        expect:"fix me"
        true == false
    }

    void "email must be well-formed"() {
        expect:"fix me"
        true == false
    }

    void "starting balance is 200 pounds"() {
        expect:"fix me"
        true == false
    }
}
