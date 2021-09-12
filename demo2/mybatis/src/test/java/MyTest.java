import com.yihaomen.mybatis.inter.IUserOperation;
import com.yihaomen.mybatis.model.Article;
import com.yihaomen.mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by zhang_minzhong on 2017/8/6.
 */
public class MyTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    static {
        try {
            reader = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

    @Test
    public  void test1() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = session.selectOne("com.yihaomen.mybatis.models.UserMapper.selectUserByID",11);
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
        }finally {
            session.close();
        }
    }

    @Test
    public void test2(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation = session.getMapper(IUserOperation.class);
            User user = userOperation.selectUserByID(11);
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
        }finally {
            session.close();
        }
    }

    @Test
    public void test3(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            /*List<User> users = userOperation.selectUsers("aa");
            for(User user:users){
                System.out.println(user.getId()+":"+user.getUsername()+":"+user.getPassword());
            }*/
            List<HashMap<String,Object>> list = userOperation.selectUsers("aa");
            for(int i=0;i<list.size();i++){
                HashMap<String,Object> map = list.get(i);
                Iterator<Map.Entry<String,Object>> iterator = map.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry<String,Object> entry = iterator.next();
                    System.out.print(entry.getKey() + ":" + entry.getValue()+" ");
                }
                System.out.println();
            }
        } finally {
            session.close();
        }
    }

    @Test
    public void test4(){
        User user = new User();
        user.setUsername("王五");
        user.setPassword("123");
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation = session.getMapper(IUserOperation.class);
            userOperation.addUser(user);
            System.out.println("递增字段：id="+user.getId());
            session.commit();
        }finally {
            session.close();
        }
    }

    @Test
    public void test5(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            List<Article> articles = userOperation.getUserArticles(1);
            for(Article article:articles){
                System.out.println(article.getTitle()+":"+article.getContent()+
                        ":作者是:"+article.getUser().getUsername()+":密码:"+
                        article.getUser().getPassword());
            }
        } finally {
            session.close();
        }
    }
}
