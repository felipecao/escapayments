package escapayments

import grails.plugin.mail.MailService
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.springframework.mail.MailMessage
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

        service.mailService = mailServiceMock
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
        1 * mailServiceMock.sendMail(_ as Closure) >> { args ->
            MailMessage email = MailMessageParser.parseWithRequest(args[0])

            assert [transaction.to.email].containsAll((email.to as List))
            assert email.subject == "Money credited to your account"
            assert email.text.contains("Amount credited: " + transaction.amount.toString())
        }

        1 * mailServiceMock.sendMail(_ as Closure) >> { args ->
            MailMessage email = MailMessageParser.parseWithRequest(args[0])

            assert [transaction.from.email].containsAll((email.to as List))
            assert email.subject == "Money debited to your account"
            assert email.text.contains("Amount debited: " + transaction.amount.toString())
        }
    }
}
