package utils.datamaker;

import java.util.Arrays;

/**
 * Created by Karol Pokomeda on 2017-04-23.
 */
public class TestDataGenerator {
    public static void main(String[] args){
        int[] result = DataType.CONST.generate(50, true);
        System.out.println(Arrays.toString(result));
    }
}
