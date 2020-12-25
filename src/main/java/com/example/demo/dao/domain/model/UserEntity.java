package com.example.demo.dao.domain.model;

import com.example.demo.dao.domain.base.BaseEntity;
import com.example.demo.dao.domain.schema.enums.Role;
import com.example.demo.dao.domain.schema.jsonb.UserData;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usr")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity extends BaseEntity {

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private Role role;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private UserData userData;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private Set<BillEntity> bills;

}
