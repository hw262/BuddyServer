package com.sil.buddyserver.model.factory;

import com.sil.buddyserver.domain.entity.User;
import com.sil.buddyserver.model.security.CurrentUser;
import org.springframework.security.core.authority.AuthorityUtils;

public class UserFactory {

    public static CurrentUser create(User user) {
        return new CurrentUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList(user.getAuthorities())
        );
    }

}
