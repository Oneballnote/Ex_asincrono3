
public class Item implements Comparable<Item>{
    public String name;
    public int weight;
    public int value;

    public Item(String name, int weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    public String getName() {return name;}

    public int getWeight() {return weight;}

    public int getValue() {return value;}

    @Override
    public int compareTo(Item other) {
        return Integer.compare(this.value, other.value);
    }
    
}
