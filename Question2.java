import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Question1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> apples = new ArrayList<>();
        
        System.out.print("Enter apple weight in gram (-1 to stop): ");
        while (true) {
            int weight = scanner.nextInt();
            if (weight == -1) break;
            apples.add(weight);
        }
        
        Collections.sort(apples, Collections.reverseOrder());
        
        int totalAmount = 100;
        int ramAmount = 50;
        int shamAmount = 30;
        int rahimAmount = 20;
        
        double ramProportion = (double) ramAmount / totalAmount;
        double shamProportion = (double) shamAmount / totalAmount;
        double rahimProportion = (double) rahimAmount / totalAmount;
        
        int ramWeight = (int) Math.round(ramProportion * getTotalWeight(apples));
        int shamWeight = (int) Math.round(shamProportion * getTotalWeight(apples));
        int rahimWeight = (int) Math.round(rahimProportion * getTotalWeight(apples));
        
        List<Integer> ramApples = new ArrayList<>();
        List<Integer> shamApples = new ArrayList<>();
        List<Integer> rahimApples = new ArrayList<>();
        
        distributeApples(apples, ramApples, shamApples, rahimApples, ramWeight, shamWeight, rahimWeight);
        
        System.out.println("Distribution Result:");
        System.out.print("Ram: ");
        for (int apple : ramApples) {
            System.out.print(apple + " ");
        }
        System.out.println();
        
        System.out.print("Sham: ");
        for (int apple : shamApples) {
            System.out.print(apple + " ");
        }
        System.out.println();
        
        System.out.print("Rahim: ");
        for (int apple : rahimApples) {
            System.out.print(apple + " ");
        }
        System.out.println();
    }

    private static int getTotalWeight(List<Integer> apples) {
        int totalWeight = 0;
        for (int weight : apples) {
            totalWeight += weight;
        }
        return totalWeight;
    }
    
    private static void distributeApples(List<Integer> apples, List<Integer> ramApples, List<Integer> shamApples, List<Integer> rahimApples,int ramWeight, int shamWeight, int rahimWeight) {
        for (int weight : apples) {
            if (ramWeight >= weight) {
                ramApples.add(weight);
                ramWeight -= weight;
            } else if (shamWeight >= weight) {
                shamApples.add(weight);
                shamWeight -= weight;
            } else if (rahimWeight >= weight) {
                rahimApples.add(weight);
                rahimWeight -= weight;
            } else if (ramWeight > shamWeight && ramWeight > rahimWeight) {
                ramApples.add(weight);
                ramWeight -= weight;
            } else if (shamWeight > rahimWeight) {
                shamApples.add(weight);
                shamWeight -= weight;
            } else {
                rahimApples.add(weight);
                rahimWeight -= weight;
            }
        }
    }
}
