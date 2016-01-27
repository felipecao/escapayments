package specs

import geb.spock.GebReportingSpec
import pages.AccountsList
import spock.lang.Stepwise

/**
 * Created by felipe on 1/27/16.
 */
@Stepwise
class AccountDetailsSpec extends GebReportingSpec {

    def "there are three accounts"(){
        when:
        to AccountsList

        then:
        accountRows.size() == 3
    }

}
