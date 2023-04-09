package com.example.demo.domain;

import javax.persistence.*;

// DB의 table 역할을 한다.
@Entity
public class Member {

    // Id 어노테이션을 통해 pk 설정
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
