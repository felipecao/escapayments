package escapayments

import grails.plugin.mail.MailMessageBuilder
import org.springframework.mail.MailMessage

/**
 * Created by felipe on 1/27/16.
 */
class MailMessageParser {
    static MailMessage parseWithRequest(def closure){
        MailMessageBuilder builder = new MailMessageBuilder(null, new ConfigObject())
        if(closure) {
            closure.setDelegate(builder)
            closure.setResolveStrategy(Closure.DELEGATE_FIRST)
            closure.call()
        }
        builder.finishMessage()
    }
}
