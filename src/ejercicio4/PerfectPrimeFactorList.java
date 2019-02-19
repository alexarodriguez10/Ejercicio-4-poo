
package ejercicio4;

/**
 *
 * @author Alexa rodriguez y Laura roldan 
 * 
 */
import java.util.Scanner;

public class PerfectPrimeFactorList {
    
    public static void main(String[] args)
    {
        System.out.print("Introduzca el límite superior (entero positivo): ");
        Scanner in = new Scanner(System.in);
        if ( ! in.hasNextInt()) {
            System.out.println("El límite superior no es válido. Inténtalo de nuevo.");
            return;
        }
        int limitesuperior = in.nextInt();
        
        PerfectPrimeFactorList aPerfectPrimeFactorList = new PerfectPrimeFactorList();
        
        System.out.println(aPerfectPrimeFactorList.isProductOfPrimeFactors(30));
        System.out.println(aPerfectPrimeFactorList.isProductOfPrimeFactors(20));
        
        aPerfectPrimeFactorList.printPerfectPrimeFactors(limitesuperior);
    }
    
    private boolean isPrime(int posInt)
    {
        for (int i = 2; i <= Math.sqrt(posInt); i++)
        {
            if (posInt%i != 0) {
                continue;
            }
            return false;
        }
        return true;
    }
    
    private boolean isProductOfPrimeFactors(int posInt)
    {
        int prod = 1;
        for (int i = 2; i < posInt; i++) {
            prod *= isPrime(i) && (posInt%i == 0) ? i : 1;
        }
        return (prod == posInt);
    }
    
    private void printPerfectPrimeFactors(int limitesuperior)
    {
        System.out.println("Estos números son iguales al producto de factores primos.: ");
        
        int countProductOfPrimeFactors = 0;
        for (int i = 1; i <= limitesuperior; i++) {
            if (! isProductOfPrimeFactors(i)) {
                continue;
            }
            System.out.printf("%1$d ", i);
            countProductOfPrimeFactors++;
            
        }
        
        System.out.printf("\n[%1$d números encontrados (%2$.2f%%)]\n",
         countProductOfPrimeFactors, ((double) 100 * countProductOfPrimeFactors/limitesuperior));
    }
    
}
