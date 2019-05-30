package com.chenhao.springbootsecurity.SecuritySupport;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<SimpleGrantedAuthority> authorities1 = new ArrayList<>();
        List<SimpleGrantedAuthority> authorities2 = new ArrayList<>();
        authorities1.add(new SimpleGrantedAuthority("viewBook"));
        authorities2.add(new SimpleGrantedAuthority("addBook"));
//        System.out.println("username:"+s);
        if("user".equals(s)){
            return new User(s,"123456",authorities1);
        }else if("admin".equals(s)){
            return new User(s,"123456",authorities2);
        }
        return null;
    }
}
