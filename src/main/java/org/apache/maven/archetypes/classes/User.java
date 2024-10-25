package org.apache.maven.archetypes.classes;

import org.apache.maven.archetypes.sort.strategySort.UserSortWithStrategy;
import org.apache.maven.archetypes.validators.UserValidator;

public class User extends AbstractModel<User> {
    {
        this.sortWithStrategy = new UserSortWithStrategy();
    }
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

    /** Созданиие объекта UserBuilder (при создании объекта User) **/
    public static UserBuilder newUserBuilder() {
        return new User().new UserBuilder();
    }

    /** Получение объекта UserBuilder на объекте User (для редактирования объекта User через UserBuilder **/
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

    /** Для простоты визуального восприятия сравнение String полей реализовано как сравнение длин этих строк **/
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
            User.this.name = UserValidator.userNameValidate(name);
            return this;
        }

        public User.UserBuilder setEmail(String email) {
            User.this.email = UserValidator.userEmailValidate(email);
            return this;
        }

        public User.UserBuilder setPassword(String password) {
            User.this.password = UserValidator.passwordValidate(password);
            return this;
        }

        public User build() {
            return User.this;
        }
    }
}