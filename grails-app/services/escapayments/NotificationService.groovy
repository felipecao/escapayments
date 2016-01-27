package escapayments

import grails.transaction.Transactional
import org.joda.money.Money

@Transactional
class NotificationService {

    def mailService

    void sendConfirmationEmailToAccountHolders(Transaction transaction) {
        notifyCredit(transaction.to.email, transaction.amount)
        notifyDebit(transaction.from.email, transaction.amount)
    }

    private void notifyCredit(String email, Money amount){
        mailService.sendMail {
            to email
            subject "Money credited to your account"
            body "Amount credited: ${amount.toString()}"
        }
    }

    private void notifyDebit(String email, Money amount){
        mailService.sendMail {
            to email
            subject "Money debited to your account"
            body "Amount debited: ${amount.toString()}"
        }
    }
}
