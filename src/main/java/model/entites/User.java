package model.entites;

/**
 * create table user
 * (
 * id       int auto_increment
 * primary key,
 * username varchar(20) not null,
 * password varchar(20) not null,
 * sex      char(2)     not null,
 * email    varchar(20) not null,
 * address  varchar(50) not null
 * );
 *
 * insert into user (username, password, sex, email, address)
 * values ('ziph', '123456', '男', 'mylifes1110@163.com', '河北省')
 *
 * insert into user (username, password, sex, email, address)
 * values ('marry', '123456', '女', 'marry@163.com', '北京市')
 */
public class User {
    private int id;
    private String username;
    private String password;
    private String sex;
    private String email;
    private String address;

    public User() {
    }

    public User(int id, String username, String password, String sex, String email, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}