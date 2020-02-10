package SwingApp_1_RegistrationForm;
public enum Alerts {
    //login alerts
    SUCCESSFULLY_LOGGED_IN("Successfully logged in"),
    WRONG_LOGIN_OR_PASSWORD("Wrong login or password"),
    EMPTY_LOGIN_OR_PASSWORD("Empty Login or password"),
    //registration alerts
    SUCCESSFULLY_REGISTERED("Successfully registered"),
    USER_ALREADY_EXIST("Username already exist"),
    PROVIDED_PASSWORDS_ARE_DIFFERENT("Provided passwords are different"),
    PASSWORD_DOES_NOT_MEET_THE_REQUIREMENTS("Password does not meet the requirements");

    String alertEN;
    Alerts(String alertEN) {
        this.alertEN=alertEN;
    }
}
