package com.yihaomen.mybatis.inter;

import com.yihaomen.mybatis.model.Article;
import com.yihaomen.mybatis.model.User;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zhang_minzhong on 2017/8/6.
 */
public interface IUserOperation {
    public User selectUserByID(int id);
    public List<HashMap<String,Object>> selectUsers(String username);
    public void addUser(User user);
    public List<Article> getUserArticles(int id);
}
