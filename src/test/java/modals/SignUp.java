package modals;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
@Builder
@Getter
public class SignUp {

private String name;
private String lastName;
private String phone;
private String email;
private String password;

}
