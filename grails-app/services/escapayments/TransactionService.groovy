package escapayments

import grails.transaction.Transactional
import org.joda.money.Money

@Transactional
class TransactionService {

    def transferAmountFromAccountToAnotherAccount(Money amount, Account from, Account to) {

    }
}
