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
        notify(email, amount, Operation.CREDIT)
    }

    private void notifyDebit(String email, Money amount){
        notify(email, amount, Operation.DEBIT)
    }

    private void notify(String email, Money amount, Operation operation){
        mailService.sendMail {
            to email
            subject "Money ${operation.name().toLowerCase()}ed to your account"
            body "Amount ${operation.name().toLowerCase()}ed: ${amount.toString()}"
        }
    }
}

enum Operation {
    CREDIT, DEBIT
}
