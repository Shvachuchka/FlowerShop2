import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Sasha on 10.11.2016.
 */
public class Bouquet {

    private List<Flower> flowerList = new ArrayList<>();

    public Bouquet(List<Flower> flowerList) {
        this.flowerList = flowerList;
    }

    public Bouquet() {
    }

    private List<Bouquet> bouquetList = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

// Create a bouquet

    public void makeBouquet() throws IOException {

        List<Flower> flowerList = new ArrayList<>();
        System.out.println("Введіть кількісь квітів в букеті");
        String fl = reader.readLine();
        int number = Integer.parseInt(fl);
        flowerList.add(new Flower("Rose", "red",30,30, freshFlower.FRESH_FLOWER));
        flowerList.add(new Flower("Tulip", "yellow",20,15,freshFlower.FRESH_FLOWER));
        flowerList.add(new Flower("Chamomile", "white",35,20,freshFlower.FRESH_FLOWER));
        flowerList.add(new Flower("Chamomile", "white",35,20,freshFlower.DEAD));
        flowerList.add(new Flower("Lily","pink",30,25,freshFlower.NOT_FRESH_FLOWER));
        flowerList.add(new Flower("Narcissus","white",20,20,freshFlower.FRESH_FLOWER));
        flowerList.add(new Flower("Rose", "red",30,30,freshFlower.DEAD));
        flowerList.add(new Flower("Rose", "white",30,30,freshFlower.FRESH_FLOWER));
        flowerList.add(new Flower("Lily", "pink",30,25,freshFlower.NOT_FRESH_FLOWER));
        flowerList.add(new Flower("Narcissus","white",20,20 ,freshFlower.DEAD));
        flowerList.add(new Flower("Lily","pink",30,25,freshFlower.FRESH_FLOWER));
        flowerList.add(new Flower("Tulip","yellow",20,15,freshFlower.FRESH_FLOWER));
        flowerList.add(new Flower("Rose","red",30,30,freshFlower.NOT_FRESH_FLOWER));

        for (int i = 1; i <= number; i++) {
            flowerList.add(new Flower());
        }
        bouquetList.add(new Bouquet(flowerList));
    }

//Print all Bouquet

    public void printBouquet() {
        bouquetList.forEach(System.out::println);
    }
//Find Name Flower
    public void findNameFlower() throws IOException {
        List<Flower> flowerList = new ArrayList<>();
        for (Bouquet bouquet : bouquetList) {
            flowerList = bouquet.getFlowerList();
        }
        System.out.println("Введіть назву квітки");
        String nameFlower = reader.readLine();
        for (Flower flower : flowerList){
            if(flower.getNameFlower().equals(nameFlower)){
                System.out.println(flower);
            } else {
                System.out.println("Такої квітки немає в букеті");
                break;
            }
        }
    }

    //Find Color Flower
    public void findColorFlower() throws IOException {
        List<Flower> flowerList = new ArrayList<>();
        for (Bouquet bouquet : bouquetList) {
            flowerList = bouquet.getFlowerList();
        }
        System.out.println("Введіть колір квітки");
        String colorFlower = reader.readLine();
        for (Flower flower : flowerList){
            if(flower.getColorFlower().equals(colorFlower)){
                System.out.println(flower);
            } else {
                System.out.println("Такої квітки немає в букеті");
                break;
            }
        }
    }

    //Print white Chamomile

    public void white_Chamomile() throws IOException {

        List<Flower> flowerList = new ArrayList<>();

        for (Bouquet bouquet: bouquetList){
            flowerList = bouquet.getFlowerList();
        }
        System.out.println("Виводимо білі ромашки ");
        for (Flower flower : flowerList){
            if (flower.getColorFlower()=="white" &&flower.getNameFlower() == "Chamomile" )
            {
                System.out.println(flower);
            }
        }
    }

    //Print any options

    public void any_options() throws IOException {

        List<Flower> flowerList = new ArrayList<>();
        for (Bouquet bouquet: bouquetList){
            flowerList = bouquet.getFlowerList();
        }
        System.out.println("Виводимо параметри квітки ");
        String param = reader.readLine();
        String price = reader.readLine();
        int pr = Integer.parseInt(price);
        for (Flower flower : flowerList){
            flowerList.stream().filter(Flower -> Flower.getFresh_Flower().equals(param)&&Flower.getNameFlower().equals(param) ||
                    Flower.getColorFlower().equals(param)|| Flower.getHeightFlower() == flower.getHeightFlower()).forEach(System.out::println);
        }
    }
    private Scanner sc = new Scanner(System.in);

    public void printConsole() throws IOException {
        System.out.println("Виберіть дію");
        System.out.println("1. Створити букет за кількість квіток");
        System.out.println("2. Знайти квіти за назвою");
        System.out.println("3. Знайти квіти за кольором");
        System.out.println("4. Знайти білі ромашки");
        System.out.println("5. Знайти хоч що-небуть)))");
        System.out.println("6. Вийти з програми");
        String choice = sc.next();
        if(choice.equalsIgnoreCase("0")) {
            return;
        }

        switch (choice) {
            case "0":
                break;
            case "1":
                makeBouquet();
                printBouquet();
                printConsole();
                break;
            case "2":
                findNameFlower();
                printConsole();
                break;
            case "3":
                findColorFlower();
                printConsole();
                break;
            case "4":
                white_Chamomile();
                printConsole();
                break;
            case "5":
                any_options();
                printConsole();
                break;
            default:
                printConsole();
                break;
        }
    }

    public List<Flower> getFlowerList() {
        return flowerList;
    }
}