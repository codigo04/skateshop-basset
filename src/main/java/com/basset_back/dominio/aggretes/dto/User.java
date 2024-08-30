package com.basset_back.dominio.aggretes.dto;

import java.util.HashSet;
import java.util.Set;

public class User {
    private Long userId;
    private String name;
    private String lastname;
    private String gmail;
    private String password;
    private  String typeDoc;
    private String numberDoc;
    Set<Role> assginedRoles = new HashSet<>();



    public User(UserBuilder userBuilder) {
        this.userId = userBuilder.userId;
        this.name = userBuilder.name;
        this.lastname = userBuilder.lastname;
        this.gmail = userBuilder.gmail;
        this.password = userBuilder.password;
        this.typeDoc = userBuilder.typeDoc;
        this.numberDoc = userBuilder.numberDoc;
        this.assginedRoles = userBuilder.assginedRoles;
    }

    public User() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeDoc() {
        return typeDoc;
    }

    public void setTypeDoc(String typeDoc) {
        this.typeDoc = typeDoc;
    }

    public String getNumberDoc() {
        return numberDoc;
    }

    public void setNumberDoc(String numberDoc) {
        this.numberDoc = numberDoc;
    }

    public Set<Role> getAssginedRoles() {
        return assginedRoles;
    }

    public void setAssginedRoles(Set<Role> assginedRoles) {
        this.assginedRoles = assginedRoles;
    }

    public static class UserBuilder{
        private Long userId;
        private String name;
        private String lastname;
        private String gmail;
        private String password;
        private  String typeDoc;
        private String numberDoc;
        Set<Role> assginedRoles = new HashSet<>();

        public UserBuilder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public UserBuilder gmail(String gmail) {
            this.gmail = gmail;
            return this;
        }


        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder typeDoc(String typeDoc) {
            this.typeDoc = typeDoc;
            return this;
        }

        public UserBuilder numberDoc(String numberDoc) {
            this.numberDoc = numberDoc;
            return this;
        }

        public UserBuilder assginedRoles(Set<Role> assginedRoles) {
            this.assginedRoles = assginedRoles;
            return  this;
        }

        public User build() {

            return new User(this);
        }


    }



}
