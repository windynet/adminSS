package site.fish119.adminss.secruity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import site.fish119.adminss.domain.SysUser;

import java.util.Collection;
import java.util.Date;

public class UserDetailsImple implements UserDetails {
    private final Long id;
    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;
    private final Date lastPasswordResetDate;

    public UserDetailsImple(Long id, String username, String password,
                            Collection<? extends GrantedAuthority> authorities, Date lastPasswordResetDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public UserDetailsImple(SysUser user){
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.authorities = user.getRoles();
        this.lastPasswordResetDate = user.getLastPasswordResetDate();
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

    // 账户是否未过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 账户是否未锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 密码是否未过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 账户是否激活
    @Override
    public boolean isEnabled() {
        return true;
    }

    // 自定义，返回上次密码重置日期
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }
}