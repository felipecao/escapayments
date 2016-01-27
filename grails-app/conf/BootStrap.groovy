import escapayments.Account
import escapayments.Pounds
import escapayments.Transaction
import org.joda.money.Money

class BootStrap {

    def transactionService

    def init = { servletContext ->
        if(0 == Account.count()){

            Account defaultAccount1 = new Account(
                    name: "default account 1",
                    email: "felipe.carvalho@gmail.com"
            )

            Account defaultAccount2 = new Account(
                    name: "default account 2",
                    email: "felipe.carvalho@gmail.com"
            )

            Account defaultAccount3 = new Account(
                    name: "default account 3",
                    email: "felipe.carvalho@gmail.com"
            )

            defaultAccount1.save(failOnError: true)
            defaultAccount2.save(failOnError: true)
            defaultAccount3.save(failOnError: true)

            transactionService.transferAmountFromAccountToAnotherAccount(
                    Pounds.amount(100),
                    defaultAccount1,
                    defaultAccount3)
        }
    }

    def destroy = {
    }
}
