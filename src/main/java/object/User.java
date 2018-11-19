package object;

public class User {
    private int id;
    private String userName;
    private String passWord;
    private String fullName;
    private String email;
    private String address;
    private String phone;

    public User (){
        super();
    }

    public User (int id, String userName, String passWord, String fullName, String email, String address, String phone){
        super();
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.fullName = fullName;
        this.email = email;
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

    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getFullName() { return fullName; }

    public void setEmail(String email) { this.email = email; }

    public String getEmail() { return email; }
}
