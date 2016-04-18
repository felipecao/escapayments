package adapter.booking

import transport.QuoteRequest
import transport.QuoteResponse

/**
 * Created by felipe on 2/10/16.
 */
class BookingAdapter {

    def httpService

    private final String BASE_URL = "http://www.booking.com/searchresults.html?" +
            "sid=6a99598883725760fc583b1b89aac0ac;" +
            "dcid=12;" +
            "checkin_monthday=17" +
            "&checkin_year_month=2016-2" +
            "&checkout_monthday=18" +
            "&checkout_year_month=2016-2" +
            "&class_interval=1" +
            "&csflt=%7B%7D" +
            "&dest_id=-1746443" +
            "&dest_type=city" +
            "&dtdisc=0" +
            "&group_adults=2" +
            "&group_children=0" +
            "&highlighted_hotels=62665&hlrd=" +
            "0&hyb_red=0&inac=0&label_click=undef&nha_red=0&no_rooms=1&offset=0&offset_unavail=1&redirected_from_city=0&redirected_from_landmark=0&redirected_from_region=0&review_score_group=empty&room1=A%2CA&sb_price_type=total&score_min=0&si=ai%2Cco%2Cci%2Cre%2Cdi&src=index&ss=Hotel%20Adlon%20Kempinski%20Berlin%2C%20Berlin%2C%20Berlin%20Federal%20State%2C%20Germany&ss_all=0&ss_raw=hotel%20adlon%2C%20berlin&ssafas=2&ssb=empty&sshis=0&"

    List<QuoteResponse> findPrices(QuoteRequest request) {

    }


}

