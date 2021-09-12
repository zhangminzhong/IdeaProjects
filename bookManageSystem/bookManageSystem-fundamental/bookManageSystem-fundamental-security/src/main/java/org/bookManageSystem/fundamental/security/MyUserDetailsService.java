package org.bookManageSystem.fundamental.security;

import org.bookManageSystem.fundamental.logger.FundamentalLogger;
import org.bookManageSystem.fundamental.security.entity.User;
import org.bookManageSystem.fundamental.security.entity.UserAuthority;
import org.bookManageSystem.fundamental.security.service.UserAuthorityService;
import org.bookManageSystem.fundamental.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xiaozhujun
 * Date: 14-3-16
 * Time: 下午6:42
 * To change this template use File | Settings | File Templates.
 */
public class MyUserDetailsService implements UserDetailsService {

    private static FundamentalLogger logger = FundamentalLogger.getLogger(MyUserDetailsService.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserAuthorityService userAuthorityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByName(username);
        if(user!=null){
            MyUserDetail userDetails = new MyUserDetail();
            userDetails.setUserName(username);
            userDetails.setPassword(user.getPassword());//这里可以从数据库取
            userDetails.setId(user.getId());
            userDetails.setAppId(user.getAppId());
            userDetails.setAuthorities(getUserAuthority(username));
            return userDetails;
        }
        return null;

    }

    //获取用户的授权角色列表
    private List<GrantedAuthority> getUserAuthority(String userName){
        List<UserAuthority> authorityList = userAuthorityService.findByUserName(userName);
        if(authorityList==null) return null;
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(UserAuthority userAuthority:authorityList){
            authorities.add(new GrantedAuthorityImpl(userAuthority.getAuthorityName()));
        }
        return authorities;
    }
}
