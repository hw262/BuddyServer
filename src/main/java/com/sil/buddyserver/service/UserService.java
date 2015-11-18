/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sil.buddyserver.service;

import com.sil.buddyserver.domain.entity.User;
import com.sil.buddyserver.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Han
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User create(User user) {
		return userRepository.save(user);
	}

	public User findUserById(Long id) {
		return userRepository.findOne(id);
	}

	public User login(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(Long id) {
		userRepository.delete(id);
	}

	public User findUserByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}

        public User findUserByEmail(String email) {
                return userRepository.findUserByEmail(email);
    }

}
