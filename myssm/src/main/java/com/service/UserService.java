package com.service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.entity.User;
import com.mapper.UserMapper;
@Service
public class UserService implements UserDetailsService {
	@Autowired
	UserMapper userMapper;

	public  Role ro=new Role();
	
	public List<User> list(String where){
		return userMapper.list(where);
	}
	public List<User> sealist(String where) {
		// TODO Auto-generated method stub
		return userMapper.sealist(where);
	}

	public int total() {
		return userMapper.total();
	}

	
	public void insert(User c) {
		userMapper.insert(c);
		
	}


	public void update(User c) {
		userMapper.update(c);
	}


	public void delete(User c) {
		userMapper.delete(c.getId());
	}


	public User get(int id) {
		// TODO Auto-generated method stub
		return userMapper.get(id);
	}

   public void updatesql(String value) {
		userMapper.updatesql(value);
	}
	public void deletesql(String value) {
		userMapper.deletesql(value);
	}

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println("------9---------------898--");
		System.out.println(ro.getRoleName());
	    User userd=userMapper.findByUsername(s);
        System.out.println("------9---------------898--");
        System.out.println(userd);
        if(userd.getUsername().equals("super")){
        	ro.setRoleName("SUPER_ADMIN");
		}
        else if(userd.getUsername().equals("admin")){
        	ro.setRoleName("ADMIN");
		}else{
        	ro.setRoleName("USER");
		}

        if(userd!=null){
			System.out.println("jjjjjjj");
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			System.out.println(ro.getRoleName());
			System.out.println("kkkkkkk");
				GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+ ro.getRoleName());
				authorities.add(grantedAuthority);


			UserDetails user = new org.springframework.security.core.userdetails.User(userd.getUsername(),userd.getPwd(), authorities);
			System.out.println(userd);

			return user;
        }


        return null;


	}
}