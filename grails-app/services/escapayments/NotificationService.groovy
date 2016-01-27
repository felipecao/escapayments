package escapayments

import grails.transaction.Transactional

@Transactional
class NotificationService {

    def mailService

    void sendConfirmationEmailToAccountHolders(Transaction transaction) {
        mailService.sendMail {}
        mailService.sendMail {}
    }
}
