package pl.coderslab.spring01hibernatekrajeew06.ut.tddz2;

import java.util.ArrayList;
import java.util.List;

public class Factors {
    public static List<Integer> generatePrimeFactors(int n){
        List<Integer> result = new ArrayList<>();
        result.add(1);

        for(int i = 2; i<=n/2; i++){
            if (n % i == 0){
                result.add(i);
            }
        }

        result.add(n);

        return result;
    }
}
