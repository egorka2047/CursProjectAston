package org.apache.maven.archetypes.classes;

import org.apache.maven.archetypes.sort.strategySort.UserSortWithStrategy;
import java.util.*;

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

        /** Предварительно валидными считаем любое введенное значение, состоящее из букв (в дальнейшем обсудим) **/
        public User.UserBuilder setName(String name) {
            boolean flag = true;
            for (int i = 0; i < name.trim().length(); i++) {
                if (!Character.isLetter(name.charAt(i))) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                User.this.name = name.trim();
            else {
                System.out.println("The entered value does not satisfy the following conditions:\n"
                        + "Name should contain only letters\n"
                        + "------------------------------------------------------------\n"
                        + "Enter the correct name manually:");
                setName(new Scanner(System.in).next());
            }
            return this;
        }

        /** Валидными считаем любое введенное значение со следующими доменными именами на конце:
        @gmail.com, @yandex.ru, @mail.ru, @bk.ru, @live.com, @rambler.ru **/
        public User.UserBuilder setEmail(String email) {
            Set<String> domainSet = Set.of("gmail.com", "@yandex.ru", "@mail.ru", "@bk.ru", "@live.com", "@rambler.ru");
            boolean flag = false;
                for (String domain : domainSet) {
                    if (email.trim().endsWith(domain)) {
                        flag = true;
                        break;
                    }
                }
            if (flag)
                User.this.email = email.trim();
             else {
                    System.out.println("The entered value does not satisfy the following conditions:\n"
                            + "Email should end with @gmail.com, @yandex.ru, @mail.ru, @bk.ru, @live.com, @rambler.ru\n"
                            + "------------------------------------------------------------\n"
                            + "Enter the correct email manually:");
                    setEmail(new Scanner(System.in).next());
                }
                return this;
        }

        /** Валидными считаем любое введенное значение, c количеством символов от 5 до 10 включительно **/
        public User.UserBuilder setPassword(String password) {
            if (password.trim().length() >= 5 && password.trim().length() <= 10)
                User.this.password = password.trim();
            else {
                System.out.println("The entered value does not satisfy the following conditions:\n"
                        + "Password length should contain from 5 to 10 characters inclusive\n"
                        + "------------------------------------------------------------\n"
                        + "Enter the correct password manually:");
                setPassword(new Scanner(System.in).next());
            }
            return this;
        }

        public User build() {
            return User.this;
        }

    }
}