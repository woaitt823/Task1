import com.tt.User;
import com.tt.UserMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserMapperTest {
    private ApplicationContext applicationContext;
    @Before
    public void setup() throws Exception{
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @Test
    public void testFindUserById()throws Exception{
        UserMapper userMapper=(UserMapper)applicationContext.getBean("userMapper");
        User user = userMapper.findUserById(1);
        System.out.println(user.getId()+":"+user.getUsername());
    }
}
