package com.rony.creditinfix.security;

import com.rony.creditinfix.entity.auth.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthUser {

    private Long id;
    private String username;
    private String email;
    private String password;
    private String role;
    private String status;
    private String mobileNo;

    public AuthUser(User user) {
        this.setId(user.getId());
        this.setUsername(user.getUsername().toLowerCase());
        this.setEmail(user.getEmail());
        if (user.getRole() != null) {
            this.setRole(user.getRole().getName());
        }
        this.setPassword(user.getPassword());
        this.setStatus(user.getStatus());
    }


    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
        /*// set role name
        if (this.getRole() != null) {
            authorityList.add(new AuthorizationAdapter(this.getRole()));
        }

        // set right name
        if (this.getRights() != null) {
            for (String right : this.getRights()) {
                authorityList.add(new AuthorizationAdapter(right));
            }
        }*/
        return authorityList;
    }


    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

}
