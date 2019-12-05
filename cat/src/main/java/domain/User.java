//201802104065闫天意
package domain;

import java.io.Serializable;

public class User implements Comparable<Teacher>, Serializable {
    private Integer id;
    private String username;
    private String password;
    private Teacher teacher;

    public User(String username, String password, Teacher teacher) {
        this.username = username;
        this.password = password;
        this.teacher = teacher;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public int compareTo(Teacher o) {
        return 0;
    }
}
