package object;

public class User {
    private String userName;
    private String passWord;
    private String address;
    private String phone;

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassWord(String password) {
        this.passWord = password;
    }

    public String getPassword() {
        return passWord;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }
}
