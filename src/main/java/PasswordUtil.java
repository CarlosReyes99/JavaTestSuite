public class PasswordUtil {

    public enum SecurityLevel {
        WEAK, MEDIUM, STRONG
    }

    public static SecurityLevel assesPassword(String password) {

        if (password != null) {
            if (password.length() >= 16) {
                System.out.println("La contraseña debe ser menor a 15 caracteres");
                return null;
            }
            if (password.length() <= 7) {
                System.out.println("La contraseña debe tener por lo menos 8 caracteres");
                return null;
            }
            if (password.contains(" ")) {
                System.out.println("La contraseña contiene espacios, no debe contener espacios");
                return null;
            }
            if (password.matches("^[\\p{L}]+$")) {
                System.out.println("Nivel de seguridad bajo, contiene solo letras");
                return SecurityLevel.WEAK;
            }
            if (password.matches("[Aa-zZ, 0-9]*")) {
                System.out.println("Entramos en nivel de seguridad medio");
                return SecurityLevel.MEDIUM;
            }
            if (password.length() >= 8 && password.matches("^[a-zA-Z0-9\\W]+$") && password.matches(".*[\\W].*")) {
                System.out.println("Entramos a nivel de seguridad alto");
                return SecurityLevel.STRONG;
            }
        }
        return SecurityLevel.STRONG;


    }
}
