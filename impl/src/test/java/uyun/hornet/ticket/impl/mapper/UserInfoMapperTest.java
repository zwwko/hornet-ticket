package uyun.hornet.ticket.impl.mapper;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import uyun.hornet.ticket.api.entity.UserInfo;

/**
 * UserInfoMapper Tester.
 *
 * @author <tt>
 * @version 1.0
 * @since <pre>五月 23, 2018</pre>
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserInfoMapperTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private UserInfoMapper userInfoMapper;

    @Before
    public void before() throws Exception {
        MockitoAnnotations.initMocks(this);
        userInfoMapper.insert(new UserInfo(1, "andy", "password1", "Andy"));
        userInfoMapper.insert(new UserInfo(2, "carl", "password2", "Carl"));
        userInfoMapper.insert(new UserInfo(3, "bruce", "password3", "Bruce"));
        userInfoMapper.insert(new UserInfo(4, "dolly", "password4", "Dolly"));
    }

    @After
    public void after() throws Exception {
        userInfoMapper.deleteByPrimaryKey(1);
        userInfoMapper.deleteByPrimaryKey(2);
        userInfoMapper.deleteByPrimaryKey(3);
        userInfoMapper.deleteByPrimaryKey(4);
    }

    @Test
    public void test01Insert() {
        userInfoMapper.insert(new UserInfo(11, "andy", "password1", "Andy"));
        Assert.assertEquals(5, userInfoMapper.selectAll().size());
    }

} 
