package com.test.transaction;

import java.util.Date;

/**
 * Created by zhang_minzhong on 2017/7/12.
 */
public interface IQuoteService {
    Quote getQuote();
    Quote getQuoteByDateTime(Date dateTime);
    void saveQuote(Quote quote);
    void updateQuote(Quote quote);
    void deleteQuote(Quote quote);
}
