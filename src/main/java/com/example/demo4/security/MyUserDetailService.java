//package com.example.demo4.security;
//
//import com.example.demo4.author.MyAuthorFailHandler;
//import com.example.demo4.entity.MyUser;
//import com.example.demo4.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//
//@Configuration
//public class MyUserDetailService implements UserDetailsService {
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Autowired
//    UserRepository userRepository;
//
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//        // 模拟一个用户，替代数据库获取逻辑
//        com.example.demo4.entity.User dbUser= userRepository.getUserByName(username);
//        if (dbUser == null) {
//            throw  new UsernameNotFoundException("用户名或密码错误");
//        }
//        MyUser user = new MyUser();
//        user.setUserName(username);
//        user.setPassword(this.passwordEncoder.encode(dbUser.getPassword()));
//        // 输出加密后的密码
//        System.out.println(user.getPassword());
//        return new User(username, user.getPassword(), user.isEnabled(),
//                user.isAccountNonExpired(), user.isCredentialsNonExpired(),
//                user.isAccountNonLocked(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
//    }
//}
