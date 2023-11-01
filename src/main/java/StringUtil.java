public class StringUtil {

    public static String repeat(String msj, int num){
        StringBuilder result= new StringBuilder();
        if(num<0){
            throw new IllegalArgumentException("negative times not allowed");
        }
        for (int i = 0; i < num; i++) {
            result.append(msj);
        }
        
        
        return result.toString();
    }

    public static boolean isEmpty(String str) {
        if(str.trim().isEmpty()){
            return true;
        }else {
            return false;
        }


    }

}
