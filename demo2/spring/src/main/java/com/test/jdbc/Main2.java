package com.test.jdbc;

import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.object.MappingSqlQueryWithParameters;
import org.springframework.jdbc.object.SqlFunction;
import org.springframework.jdbc.support.lob.LobCreator;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zhang_minzhong on 2017/7/10.
 */
public class Main2 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        //printList(jdbcTemplate);
        //printResultSetExtractor(jdbcTemplate);
        //printUseRowMapper(jdbcTemplate);
    }

    private static void printUseRowMapper(JdbcTemplate jdbcTemplate) {
        List<User> userList = jdbcTemplate.query("select * from user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            }
        });
        for(User user:userList){
            System.out.println("id="+user.getId()+",username="+user.getUserName()+",password="+user.getPassword());
        }
    }

    private static void printResultSetExtractor(JdbcTemplate jdbcTemplate) {
        List<User> users = jdbcTemplate.query("select * from user", new ResultSetExtractor<List<User>>() {
            @Override
            public List<User> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                List<User> list = new ArrayList<User>();
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setUserName(resultSet.getString("username"));
                    user.setPassword(resultSet.getString("password"));
                    list.add(user);
                }
                return list;
            }
        });
        for(User user:users){
            System.out.println("id="+user.getId()+",username="+user.getUserName()+",password="+user.getPassword());
        }
    }

    public static void printList(JdbcTemplate jdbcTemplate){
        String userName = jdbcTemplate.queryForObject("SELECT username FROM user WHERE id=1", String.class);
        System.out.println(userName);
        List<Map<String,Object>> list = jdbcTemplate.queryForList("SELECT * FROM USER");
        for(Map<String,Object> map:list){
            System.out.print("id = " + map.get("id")+" , ");
            System.out.print("username = " + map.get("username") + " , ");
            System.out.print("password = " + map.get("password"));
            System.out.println();
        }
    }
}
