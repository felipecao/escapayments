package escapayments

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Account)
class AccountSpec extends Specification {

    def setup() {
        mockForConstraintsTests(Account)
    }

    def cleanup() {
    }

    void "name cannot be null"() {
        given:
        Account account = new Account()

        when:
        account.validate()

        then:
        account.hasErrors()
        "nullable" == account.errors["name"]
    }

    void "name cannot be blank"() {
        expect:"fix me"
        true == false
    }

    void "email cannot be null"() {
        expect:"fix me"
        true == false
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
