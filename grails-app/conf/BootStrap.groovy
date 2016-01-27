import escapayments.Account

class BootStrap {

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

            defaultAccount1.save(failOnError: true)
            defaultAccount2.save(failOnError: true)
        }
    }

    def destroy = {
    }
}
