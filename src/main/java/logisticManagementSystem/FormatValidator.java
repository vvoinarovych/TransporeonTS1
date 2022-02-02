package logisticManagementSystem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatValidator {

    private boolean validate(String regex, String checking) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(checking);
        return !matcher.find();
    }

    public boolean lockerNameValid(String checking) {
        String pattern = "^[a-zA-Z]{4}[0-9]{3}$";
        return validate(pattern, checking);
    }

    public boolean menuChoiceValid(String checking) {
        String pattern = "^[0-9]$";
        return validate(pattern, checking);
    }

    public boolean lockerIdValid(String checking) {
        String pattern = "^[A-Z]{3}\\-[0-9]{2}$";
        return validate(pattern, checking);
    }

    public boolean lockerAddressStreetValid(String checking) {
        String pattern = "^[A-Z][a-z]{1,10}$";
        return validate(pattern, checking);
    }

    public boolean lockerPostalCodeValid(String checking) {
        String pattern = "^[0-9]{2}\\-[0-9]{3}$";
        return validate(pattern, checking);
    }

    public boolean parcelWeightValid(String checking) {
        String pattern = "^[0-9]{1,5}(\\.[0-9]{1,2})?$";
        return validate(pattern, checking);
    }

    public boolean nameValid(String checking) {
        String pattern = "^[A-Z][a-z]{1,10} [A-Z][a-z]{1,10}$";
        return validate(pattern, checking);
    }

    public boolean parcelIdValid(String checking) {
        String pattern = "[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}";
        return validate(pattern, checking);
    }
}
