package com.onlineShop.Security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.onlineShop.controller.entity.UserInfo;
import com.onlineShop.repository.UserInfoRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class UserInfoService implements UserDetailsService {
	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userInfo = userInfoRepository.findByuserName(username);
		log.info("++++++++++++++++++++++++++=" + userInfo);
		return userInfo.map(UserInfoDetails::new)
				.orElseThrow(() -> new UsernameNotFoundException("User not found" + username));
	}

	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		log.info("++++++++++++++++++++++++++++++++", userInfo.getPassword());
		userInfoRepository.save(userInfo);
		log.info("++++++++++++++++++++++++++++++", userInfo);
		return "User added successfully";
	}

	public List<UserInfo> getAllUser() {
		log.info("++++++++++++++++++++++++going in the get method+++++++");
		return userInfoRepository.findAll();
	}

	public UserInfo getUser(Integer id) {
		log.info("++++++++++++++++++++++++++++++++", userInfoRepository.findById(id).toString());
		return userInfoRepository.findById(id).get();
	}
}
