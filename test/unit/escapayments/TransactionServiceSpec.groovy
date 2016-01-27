package escapayments

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.joda.money.Money
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(TransactionService)
@Mock([Account, Transaction])
class TransactionServiceSpec extends Specification {

    NotificationService notificationServiceMock = Mock()
    Transaction transaction

    def setup() {
        service.notificationService = notificationServiceMock
        transaction = null
    }

    void "when an account A has enough money to be transferred to an account B, then an email is sent to both account holders and values are properly updated on accounts"() {
        given: 'I select a From account'
        Account from = TestInputs.buildFromAccount()

        and: 'a different To account'
        Account to = TestInputs.buildToAccount()

        and: 'specify an amount less than or equal to the balance of the From account'
        Money amount = Pounds.amount(200)

        when: 'the transaction is performed'
        transaction = service.transferAmountFromAccountToAnotherAccount(amount, from, to)

        then: 'the transaction succeeds'
        !transaction.hasErrors()

        and: 'the balance of the From account decreases by the amount specified'
        Pounds.amount(0) == Account.read(from.id).balance

        and: 'the balance of the From account increases by the amount specified'
        Pounds.amount(400) == Account.read(to.id).balance

        and: 'an email is sent to both account holders confirming the transference'
        1 * notificationServiceMock.sendConfirmationEmailToAccountHolders(_ as Transaction)
    }

    void "when an account A does not have enough money to be transferred to an account B, then no email is sent and balances remain unchanged on accounts"() {
        given: 'I select a From account'
        Account from = TestInputs.buildFromAccount()

        and: 'a different To account'
        Account to = TestInputs.buildToAccount()

        and: 'specify an amount greater than the balance of the From account'
        Money amount = Pounds.amount(201)

        when: 'the transaction is performed'
        transaction = service.transferAmountFromAccountToAnotherAccount(amount, from, to)

        then: 'the transaction fails'
        transaction.hasErrors()

        and: 'the balance of the From account remains unchanged'
        Pounds.amount(200) == Account.read(from.id).balance

        and: 'the balance of the From account remains unchanged'
        Pounds.amount(200) == Account.read(to.id).balance

        and: 'no email is sent'
        0 * notificationServiceMock.sendConfirmationEmailToAccountHolders(_ as Transaction)
    }

}
