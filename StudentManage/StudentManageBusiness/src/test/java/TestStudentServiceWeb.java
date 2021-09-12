import com.business.web.StudentServiceWeb;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-4-7
 * Time: 下午9:44
 * To change this template use File | Settings | File Templates.
 */
public class TestStudentServiceWeb {

    private static ClassPathXmlApplicationContext ctx;
    private static StudentServiceWeb studentServiceWeb;
    static {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentServiceWeb = (StudentServiceWeb) ctx.getBean("studentServiceWeb");
    }
    @Test
    public void testgetStudents(){

         String s =  studentServiceWeb.getStudents();
        System.out.println(s);
    }
    @Test
    public void testaddStudent(){
         //String s = studentServiceWeb.addStudent("aaa","汉族",'男',"1990-01-01",4,"15555555555","湖北省武汉市","新生");
        // System.out.println(s);
    }
}
