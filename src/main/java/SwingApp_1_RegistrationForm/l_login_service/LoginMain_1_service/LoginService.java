package l_login_service.LoginMain_1_service;

import java.util.HashMap;
import java.util.Map;

public class LoginService {
    private Map<String, String> loginToPasswordMap = new HashMap<>();



    public LoginService () {
        loginToPasswordMap.put("login1", "test1");
        loginToPasswordMap.put("login2", "test123");
        loginToPasswordMap.put("login3", "testtest");
        loginToPasswordMap.put("login4", "login4");
    }

    public Alerts loginCheck (String login, String password){
        if (login==null| password==null| login.isEmpty()|password.isEmpty()) {
            return Alerts.EMPTY_LOGIN_OR_PASSWORD;
        }
        //if(!loginToPasswordMap){}
    return Alerts.SUCCESSFULLY_LOGGED_IN;
    }
    public Alerts registerCheck (String login, String password, String password2) {

        return Alerts.SUCCESSFULLY_REGISTERED;
    }

}
