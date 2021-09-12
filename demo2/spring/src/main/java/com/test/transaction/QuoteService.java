package com.test.transaction;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhang_minzhong on 2017/7/12.
 */
public class QuoteService implements IQuoteService {
    private JdbcTemplate jdbcTemplate;
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Quote getQuote() {
        return getJdbcTemplate().queryForObject("", new RowMapper<Quote>() {
            @Override
            public Quote mapRow(ResultSet resultSet, int i) throws SQLException {
                Quote quote = new Quote();
                //...
                return quote;
            }
        });
    }

    @Override
    public Quote getQuoteByDateTime(Date dateTime) {
        throw new NotImplementedException();
    }

    @Override
    public void saveQuote(Quote quote) {
        throw new NotImplementedException();
    }

    @Override
    public void updateQuote(Quote quote) {
        throw new NotImplementedException();
    }

    @Override
    public void deleteQuote(Quote quote) {
        throw new NotImplementedException();
    }
}
