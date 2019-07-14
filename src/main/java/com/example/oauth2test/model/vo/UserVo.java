package com.example.oauth2test.model.vo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.*;

/**
 * @author lucky_yh
 * desc:实现org.springframework.security.core.userdetails.UserDetails接口，自定义security下的用户信息
 * 2019/7/3 14:39
 */
public class UserVo implements UserDetails {
    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;
    private final String password;
    private final String username;
    //拥有的权限列表
    private final Set<GrantedAuthority> authorities;
    //账号是否过期
    private final boolean accountNonExpired;
    //账号是否锁定
    private final boolean accountNonLocked;

    //凭证是否已经过期
    private final boolean credentialsNonExpired;

    private final boolean enable;

    public UserVo(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this(username, password, authorities, true, true, true, true);
    }

    public UserVo(String username, String password, Collection<? extends GrantedAuthority> authorities, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enable) {
        this.password = password;
        this.username = username;
        this.authorities = Collections.unmodifiableSet(sortAuthorities(authorities));
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enable = enable;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }

    private static SortedSet<GrantedAuthority> sortAuthorities(Collection<? extends GrantedAuthority> authorities) {
        Assert.notNull(authorities, "Cannot pass a null GrantedAuthority collection");
        SortedSet<GrantedAuthority> sortedAuthorities = new TreeSet<>(
                new AuthorityComparator()
        );
        Iterator var2 = authorities.iterator();

        while (var2.hasNext()) {
            GrantedAuthority grantedAuthority = (GrantedAuthority) var2.next();
            Assert.notNull(grantedAuthority, "GrantedAuthority list cannot contain any null elements");
            sortedAuthorities.add(grantedAuthority);
        }

        return sortedAuthorities;
    }


    private static class AuthorityComparator implements Comparator<GrantedAuthority>,
            Serializable {
        private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

        public int compare(GrantedAuthority g1, GrantedAuthority g2) {
            // Neither should ever be null as each entry is checked before adding it to
            // the set.
            // If the authority is null, it is a custom authority and should precede
            // others.
            if (g2.getAuthority() == null) {
                return -1;
            }

            if (g1.getAuthority() == null) {
                return 1;
            }

            return g1.getAuthority().compareTo(g2.getAuthority());
        }
    }
}

