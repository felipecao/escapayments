package escapayments

import grails.transaction.Transactional
import org.joda.money.Money

@Transactional
class TransactionService {

    def notificationService

    Transaction transferAmountFromAccountToAnotherAccount(Money amount, Account from, Account to) {

        Transaction transaction = createTransaction(amount, from, to)

        if(!transaction.validate()){
            transaction.discard()
            return transaction
        }

        transaction.save()
        updateBalancesInAccounts(amount, from, to)
        notifyAccountHolders(transaction)

        return transaction
    }

    private Transaction createTransaction(Money amount, Account from, Account to){
        return new Transaction(
                from: from,
                to: to,
                amount: amount
        )
    }

    private void updateBalancesInAccounts(Money amount, Account from, Account to){
        from.decrease(amount)
        to.increase(amount)

        from.save()
        to.save()
    }

    private void notifyAccountHolders(Transaction transaction){
        notificationService.sendConfirmationEmailToAccountHolders(transaction)
    }
}
