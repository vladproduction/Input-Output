package vladproduction.com.lombok_use;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@Data  //we don`t need to create getters&setters
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Student {

    private int id;
    private String firstName;
    private String email;

}
