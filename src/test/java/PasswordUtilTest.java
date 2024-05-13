import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilTest {


    @Test
    public void null_when_password_is_too_long() {
        assertEquals(null, PasswordUtil.assesPassword("asdfqwerto1234555"));
    }
    @Test
    public void null_when_password_is_too_short() {
        assertEquals(null, PasswordUtil.assesPassword("1234567"));
    }

    @Test
    public void null_when_password_contains_space_() {
        assertEquals(null, PasswordUtil.assesPassword("1234567 "));
    }

    @Test
    public void weak_when_has_only_letters() {
        assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assesPassword("asdfghjklñqwerp"));
    }

    @Test
    public void medium_when_has_letters_and_numbers() {
        assertEquals(PasswordUtil.SecurityLevel.MEDIUM, PasswordUtil.assesPassword("123asdfg"));
    }
    @Test
    public void strong_when_has_letters_numbers_symbols() {
        assertEquals(PasswordUtil.SecurityLevel.STRONG, PasswordUtil.assesPassword("123asdf!AD##@"));
    }


}