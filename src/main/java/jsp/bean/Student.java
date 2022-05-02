package jsp.bean;

//bean类设为public
public class Student {
    String name;
    String password;
    String[] interests;

    public Student() {
    }

    //为成员变量设置get和set方法
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String[] getInterests() {
        return interests;
    }
    public void setInterests(String[] interests) {
        this.interests = interests;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
