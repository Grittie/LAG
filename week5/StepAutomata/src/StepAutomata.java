import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class StepAutomata {
    public static void main(String[] args) {
        // Define the regular expression
        String regex = "((2|4)(32|34)*6((2|32|34)(32|34)*6)*9|(2|4)(32|34)*6((2|32|34)(32|34)*6)*9((32|34)+6((2|32|34)(32|34)*6)*9)*)";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Test strings
        String[] testStrings = {
                "2326323469",
                "4234346",
                "246",
                "32346",
                "4693469",
                "269",
                "2469",
                "23234692346",
                "2432469",
                "232346969",
        };

        // Match each test string against the pattern
        for (String testString : testStrings) {
            Matcher matcher = pattern.matcher(testString);
            boolean isMatch = matcher.matches();
            System.out.println(testString + ": " + (isMatch ? "Valid" : "Invalid"));
        }
    }
}