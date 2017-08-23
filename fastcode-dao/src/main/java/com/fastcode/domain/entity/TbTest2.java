package com.fastcode.domain.entity;

import javax.persistence.*;

@Table(name = "tb_test2")
public class TbTest2 {
    @Id
    private Integer id;

    @Column(name = "userName")
    private String username;

    private String age;

    private String udesc;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return userName
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return udesc
     */
    public String getUdesc() {
        return udesc;
    }

    /**
     * @param udesc
     */
    public void setUdesc(String udesc) {
        this.udesc = udesc;
    }
}