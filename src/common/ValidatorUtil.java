package common;

public class ValidatorUtil {
    
    /**
     * Verifies that the input numbers are NaturalNumbers (unsigned ints)
     * @param numb any number of numbers to be checked
     */
    public static void validateNaturalNumber(int...numb){
        for(int i = 0;i<numb.length;i++){
            if(numb[i]<0){
                throw new IllegalArgumentException();
            }
        }
    }
}
