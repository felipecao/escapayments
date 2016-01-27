package escapayments

import org.joda.money.Money

/**
 * Created by felipe on 1/26/16.
 */
class TestInputs {

    static Account buildFromAccount(){
        return new Account(name: "from", email: "from@account.com").save(failOnError: true)
    }

    static Account buildToAccount(){
        return new Account(name: "to", email: "to@account.com").save(failOnError: true)
    }
}
