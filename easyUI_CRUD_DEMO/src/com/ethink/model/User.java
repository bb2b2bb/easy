package com.ethink.model;

/**
 * @author Yule_Liu
 * @version V 1.0.0
 * @description
 * @date 2020/2/19 10:42
 */
public class User {
    private int id;
    private String name;
    private String age;
    private String email;

    public User(String name, String age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public User() {

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
