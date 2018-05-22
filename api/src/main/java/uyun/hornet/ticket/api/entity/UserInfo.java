package uyun.hornet.ticket.api.entity;

/**
 * 用户信息
 *
 * @author zhouww
 * @version 1.2
 * @Copyright 2011-2018 uyun
 */
public class UserInfo {
    /**
     * 主键ID
     */
    private long id;

    /**
     * 登录名
     */
    private String loginname;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名
     */
    private String name;

    public UserInfo(long id, String loginname, String password, String name) {
        this.id = id;
        this.loginname = loginname;
        this.name = name;
        this.password = password;
    }

    public UserInfo(String loginname, String name) {
        this.loginname = loginname;
        this.name = name;
    }
    public UserInfo() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
