package mainatm;

import java.util.HashMap;

class LoginAuthintication {

    HashMap userDictionary;

    public LoginAuthintication() {
        // users information ...............
        userDictionary = new HashMap();
        userDictionary.put("Maryam", "8282");
    }

    public boolean validation(String userName, String cardNumber) {
        boolean validationResult = false;
        String fetchedPassword = (String) userDictionary.get(userName);
        if (fetchedPassword != null) {
            validationResult = fetchedPassword.equals(cardNumber);
        }
        return validationResult;
    }

}
