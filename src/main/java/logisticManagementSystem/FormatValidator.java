package logisticManagementSystem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatValidator {

    public boolean lockerNameValid(String checking) {
        String pattern = "^[a-zA-Z]{4}[0-9]{3}$";
        return validate(pattern,checking);
    }

    public boolean menuChoiceValid(String checking) {
        String pattern = "^[0-9]$";
        return validate(pattern,checking);
    }
    private boolean validate(String regex, String checking){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(checking);
        return matcher.find();
    }
}
