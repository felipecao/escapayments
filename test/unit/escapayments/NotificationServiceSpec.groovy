package escapayments

import grails.plugin.mail.MailService
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(NotificationService)
@Mock([Account, Transaction])
class NotificationServiceSpec extends Specification {

    MailService mailServiceMock

    def setup() {
        mailServiceMock = Mock()
    }

    void "when a confirmation e-mail is sent, mailService is invoked twice, one for each account holder involved in the transaction"() {
        given:
        Transaction transaction = new Transaction(
                from: TestInputs.buildFromAccount(),
                to: TestInputs.buildToAccount(),
                amount: TestInputs.pounds(100)
        )

        when:
        service.sendConfirmationEmailToAccountHolders(transaction)

        then:
        2 * mailServiceMock.sendMail(_ as Closure)
    }
}
