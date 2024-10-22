package org.apache.maven.archetypes.classes;

public class User implements Comparable<User>, AbstractModel<User>  {
    private String name;
    private String email;
    private String password;
    private User() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public static UserBuilder newUserBuilder() {
        return new User().new UserBuilder();
    }

    public UserBuilder toUserBuilder() {
        return this.new UserBuilder();
    }

    @Override
    public String toString() {
        return "User - "
                + "name: " + name
                + ", email: " + email
                + ", password: " + password;
    }

    /* Для простоты визуального восприятия сравнение String полей пока что реализовано как сравнение длин этих строк */

    @Override
    public int compareTo(User o) {
        int result = this.name.length() - o.name.length();
        if (result == 0)
            result = this.email.length() - o.email.length();
        if (result == 0)
            result = this.password.length() - o.password.length();
        return result;
    }

    public class UserBuilder {
        private UserBuilder() {}

        public User.UserBuilder setName(String name) {
            User.this.name = name;
            return this;
        }

        public User.UserBuilder setEmail(String email) {
            User.this.email = email;
            return this;
        }

        public User.UserBuilder setPassword(String password) {
            User.this.password = password;
            return this;
        }

        public User build() {
            return User.this;
        }

    }
}
