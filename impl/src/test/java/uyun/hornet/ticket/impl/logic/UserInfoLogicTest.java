package uyun.hornet.ticket.impl.logic;

import com.github.pagehelper.PageInfo;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import uyun.hornet.ticket.api.entity.UserInfo;

/**
 * UserInfoLogic Tester.
 *
 * @author <tt>
 * @version 1.0
 * @since <pre>五月 23, 2018</pre>
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserInfoLogicTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private UserInfoLogic userInfoLogic;

    private UserInfo insertObject = new UserInfo(11, "andy", "password1", "Andy");
    private UserInfo updateObject = new UserInfo(11, "zest", "password1", "zest");

    @Before
    public void before() throws Exception {
        MockitoAnnotations.initMocks(this);
        userInfoLogic.save(new UserInfo(1, "andy", "password1", "Andy"));
        userInfoLogic.save(new UserInfo(2, "carl", "password2", "Carl"));
        userInfoLogic.save(new UserInfo(3, "bruce", "password3", "Bruce"));
        userInfoLogic.save(new UserInfo(4, "dolly", "password4", "Dolly"));
    }

    @After
    public void after() throws Exception {
        userInfoLogic.delete(1);
        userInfoLogic.delete(2);
        userInfoLogic.delete(3);
        userInfoLogic.delete(4);
    }

    /**
     * Method: findAll()
     */
    @Test
    public void test01FindAll() throws Exception {
        Assert.assertTrue(4 == userInfoLogic.findAll().size());
    }

    /**
     * Method: save(UserInfo userInfo)
     */
    @Test
    public void test02Save() throws Exception {
        userInfoLogic.save(insertObject);
        Assert.assertTrue(5 == userInfoLogic.findAll().size());
    }

    /**
     * Method: findById(String userInfoId)
     */
    @Test
    public void test03FindById() throws Exception {
        Assert.assertNotNull(userInfoLogic.findById(11));
    }

    /**
     * Method: update(UserInfo userInfo)
     */
    @Test
    public void test03Update() throws Exception {
        userInfoLogic.update(updateObject);
        Assert.assertEquals(updateObject.getLoginname(), userInfoLogic.findById(insertObject.getId()).getLoginname());
        Assert.assertEquals(updateObject.getName(), userInfoLogic.findById(insertObject.getId()).getName());

    }

    /**
     * Method: queryPage(PageInfo pageInfo, UserInfo userInfo)
     */
    @Test
    public void test04FindPage() throws Exception {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setPageNum(1);
        pageInfo.setPageSize(3);
        pageInfo.setOrderBy("name desc");
        UserInfo userInfo = new UserInfo();
        //查询所有分页，并按名字降序
        UserInfo targetObject = userInfoLogic.findPage(pageInfo, userInfo).getList().get(0);
        Assert.assertTrue(updateObject.getId() == targetObject.getId());

        //根据名字查出唯一
        userInfo.setName(updateObject.getName());
        Assert.assertTrue(1 == userInfoLogic.findPage(pageInfo, userInfo).getList().size());
    }

    /**
     * Method: delete(long userInfoId)
     */
    @Test
    public void test05Delete() throws Exception {
        Assert.assertTrue(5 == userInfoLogic.findAll().size());
        userInfoLogic.delete(insertObject.getId());
        Assert.assertTrue(4 == userInfoLogic.findAll().size());
    }
}
