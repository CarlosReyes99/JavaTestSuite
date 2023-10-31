public class PasswordUtil {

    public enum SecurityLevel{
        WEAK, MEDIUM, STRONG
    }
    public static SecurityLevel assesPassword(String password){

        if(password != null){
            if (password.length()<=8 || password.matches("[a-zA-Z]+")){
                System.out.println("Nivel bajo, menos de 8 letras o solo tiene letras");
                return SecurityLevel.WEAK;
            }
            if (password.matches("[Aa-zZ, 0-9]*")){
                System.out.println("Entramos en nivel de seguridad medio");
                return SecurityLevel.MEDIUM;
            }
            if ((password.length() >=12) && (password.matches("[a-zA-Z0-9., \\W+]*")) ){
                System.out.println("Entramos a nivel de seguridad alto");
                return SecurityLevel.STRONG;
            }
        }

        return SecurityLevel.STRONG;
    }


}
