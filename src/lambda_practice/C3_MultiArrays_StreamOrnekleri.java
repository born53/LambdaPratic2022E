package lambda_practice;
//multi arrayleri cevirirken flapMap kullaniriz yapilis sekli iki turludur
//1) lamda kullanarak
// Arrays.stream(arr).flatMap(t->Arrays.stream(t))
//2) method ile
// Arrays.stream(arr).flatMap(Arrays::stream)
// BU SEKLIDE ARTIK TUM STREAM METHODLARI KULLANILABILIR

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class C3_MultiArrays_StreamOrnekleri {
    public static void main(String[] args) {
        String arr[][] = {
                {"Elma", "Muz"},
                {"Portakal", "Cilek", "Limon"},
                {"Havuc","Erik"}
        };

        System.out.println("listele(arr) = " + listele(arr));
        doubleYaz(arr);
        System.out.println("EleriListeYaz(arr) = " + EleriListeYaz(arr));
        kBitenlereYildiz(arr);
    }
    // S1 : tum elemanlari list yapalim
    public static List<String>listele( String [][] str){
        return Arrays.stream(str).
                flatMap(t-> Arrays.stream(t)).collect(Collectors.toList());
    }
    // S2: E ile baslayan elemanlari double (elmaelma) olarak yazdiralim
    public static void doubleYaz(String[][] str){
        Arrays.stream(str).
                flatMap(t-> Arrays.stream(t)).
                filter(t-> t.toLowerCase().startsWith("e")).
                map(t-> t+t).forEach(t-> System.out.println(t));
    }
    // S3: E ile baslayan elemanlari liste olarak yazdiralim
    public static List<String> EleriListeYaz(String[][] str){
        return Arrays.stream(str).
                flatMap(t-> Arrays.stream(t)).
                filter(t-> t.toLowerCase().startsWith("e")).
                collect(Collectors.toList());
    }
    //S4 : k ile bitenlerin sonuna '*' ekleyelim
    public static void kBitenlereYildiz(String [][] arr){
        System.out.println();
        Arrays.stream(arr).flatMap(t-> Arrays.stream(t)).
                filter(t-> t.endsWith("k")).map(t-> t+ "*").
                forEach(t-> System.out.print(t + " "));
    }
}













