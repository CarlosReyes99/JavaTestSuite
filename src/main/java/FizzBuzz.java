public class FizzBuzz {

    private static String value="";


    /*Si el número es divisible por 3, retorna “Fizz”
    Si el número es divisible por 5, retorna “Buzz”
    Si el número es divisible por 3 y por 5, retorna “FizzBuzz”*/
    public static String getValue(int number) {

        if(number % 3 ==0 && number % 5==0){
            value ="FizzBuzz";
        } else if (number % 3==0) {
            value = "Fizz";

        }else if(number % 5==0){
            value= "Buzz";
        }
        System.out.println(value);
        return value;

    }
}
