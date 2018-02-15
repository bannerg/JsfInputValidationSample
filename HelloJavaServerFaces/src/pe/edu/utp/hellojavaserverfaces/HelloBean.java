package pe.edu.utp.hellojavaserverfaces;
/*Para crear este proyecto seleccionamos CDI, JSF y Java EE, Java WEB*/
//ANOTACIONES IMPORTANTES PARA COMBERTIR A UN MANAGED BEAN

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
//Las anotaciones en JAVA son una manera de reducir codigo, en tiempos de compilacion se transforma en metodos para la
//clase
@Named
@SessionScoped //Cuando identificas un SCOPE a una clase, este tiene que ser -Serializable-
public class HelloBean implements Serializable{
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //  Begin of Metodos agregados
    public String getWelcomeMessage(){
        return isValidName() ? "Welcome " + firstName + " "+ lastName : "";
    }

    public boolean isValidName() {
        return !(firstName.isEmpty() || firstName == null);

    }
    //  End of Metodos agregados
}
