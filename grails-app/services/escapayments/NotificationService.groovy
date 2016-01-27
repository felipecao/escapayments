package escapayments

import grails.transaction.Transactional

@Transactional
class NotificationService {

    def mailService

    void sendConfirmationEmailToAccountHolders(Transaction transaction) {
        mailService.sendMail {
            to transaction.to.email
            subject "Money credited to your account"
            body "Amount credited: ${transaction.amount.toString()}"
        }

        mailService.sendMail {
            to transaction.from.email
            subject "Money debited to your account"
            body "Amount debited: ${transaction.amount.toString()}"
        }
    }
}
