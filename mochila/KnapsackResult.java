import java.util.List;

public class KnapsackResult {
    public List<Item> selectedItems; //Cambie el tipo a una lista para guardar directamente el objeto y no desperdiciar espacio
    public int totalValue;

    public KnapsackResult(List<Item> selectedItems, int totalValue) {
        this.selectedItems = selectedItems;
        this.totalValue = totalValue;
    }
}
