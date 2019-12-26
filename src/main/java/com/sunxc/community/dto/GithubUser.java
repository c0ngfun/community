package com.sunxc.community.dto;

/**
 * @projectname:community
 * @classname:GithubUser
 * @description:TODO
 * @auhtor: sunxc
 * @date: 2019/12/26-14:52
 * @version: 1.0
 */
public class GithubUser {
    private String name;
    private  Long id;
    private String bio;

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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
