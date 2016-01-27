package pages

import geb.Module
import geb.Page

/**
 * Created by felipe on 1/27/16.
 */
class AccountsList extends Page {

    static url = "account/index"

    static at = {
        title ==~ /Account List/
    }

    static content = {
        accountTable { $("div.content table", 0) }
        accountRow { module AccountRow, accountRows[it] }
        accountRows(required: false) { accountTable.find("tbody").find("tr") }
    }

}

class AccountRow extends Module {
    static content = {
        cell { $("td", it) }
        cellText { cell(it).text() }
        cellHrefText{ cell(it).find('a').text() }
        name { cellText(1) }
        email { cellText(2) }
        balance { cellText(3) }
//        showLink(to: ShowPage) { cell(0).find("a") }
    }
}
