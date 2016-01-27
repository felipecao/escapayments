package escapayments

import grails.transaction.Transactional
import org.joda.money.Money

@Transactional
class TransactionService {

    def notificationService

    Transaction transferAmountFromAccountToAnotherAccount(Money amount, Account from, Account to) {

        Transaction transaction = new Transaction(
                from: from,
                to: to,
                amount: amount
        )

        if(!transaction.validate()){
            transaction.discard()
            return transaction
        }

        transaction.save()

        from.decrease(amount)
        to.increase(amount)

        from.save()
        to.save()

        notificationService.sendConfirmationEmailToAccountHolders(transaction)

        return transaction
    }
}
