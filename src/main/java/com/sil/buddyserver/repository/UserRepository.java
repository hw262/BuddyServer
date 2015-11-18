package com.sil.buddyserver.repository;

import com.sil.buddyserver.domain.entity.User;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Han Wang
 */
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmailAndPassword(String email, String password);

    public User findUserByUsername(String username);

    public User findUserByEmail(String email);


}
