package escapayments

class Account {

    String name
    String email

    static constraints = {
        name blank: false, nullable: false
    }
}
