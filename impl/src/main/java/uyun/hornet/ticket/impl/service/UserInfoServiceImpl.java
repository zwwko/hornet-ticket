package uyun.hornet.ticket.impl.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uyun.hornet.ticket.api.service.UserInfoService;
import uyun.hornet.ticket.impl.logic.UserInfoLogic;

import javax.annotation.Resource;

/**
 * 发布服务
 */
@Service(protocol = {"dubbo"}, version = "0.0.1")
public class UserInfoServiceImpl implements UserInfoService {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Resource
    private UserInfoLogic userInfoLogic;

}
