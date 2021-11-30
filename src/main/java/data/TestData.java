package data;

import net.andreinc.mockneat.MockNeat;

public class TestData {
    public static final String BASEURL = "http://automationpractice.com";
    public static final String EXISTING_USER = "testuser1@mailinator.com";
    public static final String EXISTING_PASS = "automation_practice_pass";

    static MockNeat mock = MockNeat.old();
    public static final String NEW_EMAIL = mock.emails().domain("mailinator.com").val();
    public static final String NEW_FIRSTNAME = mock.names().first().val();
    public static final String NEW_LASTNAME = mock.names().last().val();
    public static final String NEW_ADDRESS1 = "1 The Street";
    public static final String NEW_CITY = mock.cities().us().val();
    public static final String NEW_ZIP = "90210";
    public static final String NEW_STATE = "California";
    public static final String NEW_MOBILE = "0123456789";
    public static final String NEW_PASS = "password";

    public static final String SHIPPING = "2.00";
}
