package pe.edu.utp.jsfinputvalidationsample;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "login")
@SessionScoped
public class LoginBean implements Serializable{
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String doValidateInput(){
        //Validaciones

        return "success";
    }
}
