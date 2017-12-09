package util.validate;

public class Validate {
    public static boolean validateEmpty(String data){
        if(data==null||"".equals(data)){
            return false;
        }
        return true;
    }
}
