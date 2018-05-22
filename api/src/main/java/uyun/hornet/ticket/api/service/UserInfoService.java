package uyun.hornet.ticket.api.service;

import uyun.hornet.ticket.api.entity.UserInfo;

import java.util.List;

/**
 * 用户信息服务接口
 *
 * @author zhouww
 * @version 1.2
 * @Copyright 2011-2018 uyun
 */
public interface UserInfoService {
    int save(UserInfo userInfo);

    /**
     * 删除用户信息
     *
     * @return UserInfo
     */
    int delete(long userInfoId);

    /**
     * 更新用户信息
     *
     * @return UserInfo
     */
    int update(UserInfo userInfo);

    /**
     * 根据id获取用户信息
     *
     * @param userInfoId
     * @return UserInfo
     */
    UserInfo findById(long userInfoId);

    /**
     * 查询所有用户信息
     *
     * @return List<UserInfo>
     */
    List<UserInfo> findAll();

    /**
     * 分页查询
     *
     * @param pageInfo
     * @param userInfo
     * @return
     */
    PageInfo<UserInfo> findPage(PageInfo pageInfo, UserInfo userInfo);

}