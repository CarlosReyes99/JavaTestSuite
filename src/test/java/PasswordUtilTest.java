import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordUtilTest {

    @Test
    public void weak_when_has_less_8_letters() {
        assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assesPassword("admin"));
    }
    @Test
    public void weak_when_has_only_letters() {
        assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assesPassword("mitosurip"));
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