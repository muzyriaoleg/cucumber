package regex;

import com.bookdepository.driver.DriverManager;
import com.epam.pages.ContactPage;

public class RegexValidator {

    //1.Implement boolean method to validate whether String matches regular expression
    public static boolean isRegexMatchString(String regex, String stringToValidate) {
        return stringToValidate.matches(regex);
    }

    public static String getValueByRegex(String targetString, String regex, int group) {
        return targetString.replaceAll(regex, "$" + group).trim();
    }

    public static void main(String[] args) {

        //2.1.	Write regular expression to validate email
        System.out.println("Regex \"^[a-zA-Z0-9.\\-_]{3,25}@[a-zA-z]{3,5}\\.[a-zA-Z]{3,}$\" is matched with the email hello.DUDE21@mail.ups: "
                + isRegexMatchString("^[a-zA-Z0-9.\\-_]{3,25}@[a-zA-z]{3,5}\\.[a-zA-Z]{3,}$", "hello.DUDE21@mail.ups"));
        System.out.println("Regex \"^[a-zA-Z0-9.\\-_]{3,25}@[a-zA-z]{3,5}\\.[a-zA-Z]{3,}$\" is matched with the email NCR@FLT.usmail: "
                + isRegexMatchString("^[a-zA-Z0-9.\\-_]{3,25}@[a-zA-z]{3,5}\\.[a-zA-Z]{3,}$", "NCR@FLT.usmail"));
        System.out.println("Regex \"^[a-zA-Z0-9.\\-_]{3,25}@[a-zA-z]{3,5}\\.[a-zA-Z]{3,}$\" is matched with the email email-email.email1email23@maiL.zzzzzz: "
                + isRegexMatchString("^[a-zA-Z0-9.\\-_]{3,25}@[a-zA-z]{3,5}\\.[a-zA-Z]{3,}$", "email-email.email1email23@maiL.zzzzzz"));
        System.out.println("Regex \"^[a-zA-Z0-9.\\-_]{3,25}@[a-zA-z]{3,5}\\.[a-zA-Z]{3,}$\" is matched with the email it'sNotValid!@ml.ups: "
                + isRegexMatchString("^[a-zA-Z0-9.\\-_]{3,25}@[a-zA-z]{3,5}\\.[a-zA-Z]{3,}$", "it'sNotValid!@ml.ups"));
        System.out.println();

        //2.2.	Write regular expression to validate IP
        System.out.println("Regex \"^(\\d{3}\\.){2}\\d{1,3}\\.\\d{1,3}$\" is matched with the IP 123.233.2.23: "
                + isRegexMatchString("^(\\d{3}\\.){2}\\d{1,3}\\.\\d{1,3}$", "123.233.2.23"));
        System.out.println("Regex \"^(\\d{3}\\.){2}\\d{1,3}\\.\\d{1,3}$\" is matched with the IP 111.222.123.1: "
                + isRegexMatchString("^(\\d{3}\\.){2}\\d{1,3}\\.\\d{1,3}$", "111.222.123.1"));
        System.out.println("Regex \"^(\\d{3}\\.){2}\\d{1,3}\\.\\d{1,3}$\" is matched with the IP 233.122.132.232: "
                + isRegexMatchString("^(\\d{3}\\.){2}\\d{1,3}\\.\\d{1,3}$", "233.122.132.232"));
        System.out.println("Regex \"^(\\d{3}\\.){2}\\d{1,3}\\.\\d{1,3}$\" is matched with the IP 12.323.33.111: "
                + isRegexMatchString("^(\\d{3}\\.){2}\\d{1,3}\\.\\d{1,3}$", "12.323.33.111"));
        System.out.println();

        //2.3.	Write regular expression to validate
        System.out.println("Regex \"^(\\d{4}(\\s)?){3}\\d{4}$\" is matched with the bank card 1234 1234 1234 1234: "
                + isRegexMatchString("^(\\d{4}(\\s)?){3}\\d{4}$", "1234 1234 1234 1234"));
        System.out.println("Regex \"^(\\d{4}(\\s)?){3}\\d{4}$\" is matched with the bank card 1234123413241234: "
                + isRegexMatchString("^(\\d{4}(\\s)?){3}\\d{4}$", "1234123413241234"));
        System.out.println("Regex \"^(\\d{4}(\\s)?){3}\\d{4}$\" is matched with the bank card 1111 1111 1111 1111: "
                + isRegexMatchString("^(\\d{4}(\\s)?){3}\\d{4}$", "1111 1111 1111 1111"));
        System.out.println("Regex \"^(\\d{4}(\\s)?){3}\\d{4}$\" is matched with the bank card 12s1 1111 1111 1111: "
                + isRegexMatchString("^(\\d{4}(\\s)?){3}\\d{4}$", "1211 1111 11s1 1111"));
        System.out.println();

        //4. 4.	Get Epam address elements as text (https://www.epam.com/about/who-we-are/contact) using regex
        DriverManager.setupDriver();
        ContactPage contactPage = new ContactPage(DriverManager.getChromedDriverInstance());
        String address = contactPage.open().getAddress();
        DriverManager.quitDriver();
        String [] addressGroups = address.split("•");
        String [] apartmentsTownStateIndex = addressGroups[1].split(",");
        System.out.println("Street: " +  getValueByRegex(addressGroups[0], "(\\d+\\s)(.*)", 2));
        System.out.println("House: " +  getValueByRegex(addressGroups[0], "(\\d+\\s)(.*)", 1));
        System.out.println("Apartments: " +  getValueByRegex(apartmentsTownStateIndex[0], "(\\w+\\s)(\\d+)", 2));
        System.out.println("Town: " + getValueByRegex(apartmentsTownStateIndex[1], "(\\w)", 1));
        System.out.println("State: " + getValueByRegex(apartmentsTownStateIndex[2], "([A-Z]*\\s)(\\d{5})", 1));
        System.out.println("Index: " + getValueByRegex(apartmentsTownStateIndex[2], "([A-Z]*\\s)(\\d{5})", 2));
        System.out.println("Country: " + getValueByRegex(addressGroups[2], "(\\w+)", 1));

    }
}
