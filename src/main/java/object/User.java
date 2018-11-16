package object;

public class User {
    private int id;
    private String userName;
    private String passWord;
    private String address;
    private String phone;

    public User (int id, String userName, String passWord, String address, String phone){
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.address = address;
        this.phone = phone;
    }

    public void setId(int id) { this.id = id; }

    public int getId() { return id; }

    public void setUserName(String username) {
        this.userName = username;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassWord(String password) {
        this.passWord = password;
    }

    public String getPassWord() {
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
