package uyun.hornet.ticket.impl.logic;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import uyun.hornet.ticket.api.entity.UserInfo;
import uyun.hornet.ticket.impl.mapper.UserInfoMapper;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoLogic {
    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * 保存用户信息
     *
     * @param userInfo
     * @return UserInfo
     */
    public int save(UserInfo userInfo) {
        return userInfoMapper.insert(userInfo);
    }

    /**
     * 删除用户信息
     *
     * @return UserInfo
     */
    public int delete(long userInfoId) {
        return userInfoMapper.deleteByPrimaryKey(userInfoId);
    }

    /**
     * 更新用户信息
     *
     * @return UserInfo
     */
    public int update(UserInfo userInfo) {
        return userInfoMapper.updateByPrimaryKey(userInfo);
    }

    /**
     * 根据id获取用户信息
     *
     * @param userInfoId
     * @return UserInfo
     */
    public UserInfo findById(long userInfoId) {
        return userInfoMapper.selectByPrimaryKey(userInfoId);
    }

    /**
     * 查询所有用户信息
     *
     * @return List<UserInfo>
     */
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }

    /**
     * 分页查询
     *
     * @param pageInfo
     * @param userInfo
     * @return
     */
    public PageInfo<UserInfo> findPage(PageInfo pageInfo, UserInfo userInfo) {
        //设置分页
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getSize());
        Example example = new Example(UserInfo.class);
        //排序 id asc
        example.setOrderByClause(pageInfo.getOrderBy());
        Example.Criteria criteria = example.createCriteria();
        String name = userInfo.getName();
        String loginname = userInfo.getLoginname();
        if (!StringUtils.isEmpty(name)) {
            criteria.andLike("name", "%" + name + "%");
        }
        if (!StringUtils.isEmpty(loginname)) {
            criteria.andLike("loginname", "%" + loginname + "%");
        }
        List<UserInfo> list = userInfoMapper.selectByExample(criteria);

        return new PageInfo<>(list);
    }


}