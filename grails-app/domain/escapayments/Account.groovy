package escapayments

class Account {

    String name

    static constraints = {
        name blank: false, nullable: false
    }
}
