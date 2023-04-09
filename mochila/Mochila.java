import java.util.ArrayList;
import java.util.List;


public abstract class Mochila implements Comparable <Item> {

	public static void main(String[] args) {
	    int weightLimit = 10;
	    Item[] arr_items = {new Item("item1", 4, 8),
	                    new Item("item2", 3, 5),
	                    new Item("item3", 2, 3),
	                    new Item("item4", 1, 2)};
	    KnapsackResult result = knapsack(weightLimit, arr_items);
		
		System.out.println("list size: " + result.selectedItems.size());
		//El error es que la funcion regresa siempre null e intentas a acceder a atributos que no existen
		//iteramos por la lista para imprimir los nombres de los items seleccionados
	    for (Item item : result.selectedItems) {
			System.out.println("Item: " + item.name);
		}
	    System.out.println("Total value: " + result.totalValue);
		
	}
	
	public static KnapsackResult knapsack(int weightLimit, Item[] arr_items) {
	    int items_length = arr_items.length;
	    int[][] possible_solutions = new int[items_length + 1][weightLimit + 1];
		List<Item> selected_Items = new ArrayList<>(); 

	    for (int i = 0; i <= items_length; i++) {
	        for (int w = 0; w <= weightLimit; w++) {
	            if (i == 0 || w == 0)
	                possible_solutions[i][w] = 0;
	            else if (arr_items[i - 1].weight <= w)
				{
					int currentValue = arr_items[i - 1].value + possible_solutions[i - 1][w - arr_items[i - 1].weight];
					int prevValue = possible_solutions[i - 1][w];

					possible_solutions[i][w] = Math.max(currentValue, prevValue); //me dio toc y asigne los valores 
																				  //avariables para que se entendiera mejor xd
					if (currentValue > prevValue && !selected_Items.contains(arr_items[i - 1])) {
						//agregamos el objeto a la lista
						selected_Items.add(arr_items[i - 1]);
					}
				}
	            else
	                possible_solutions[i][w] = possible_solutions[i - 1][w];
	        	
			}
	    }

		//Aquí ya esta resuelto el problema de la mochila
	    int result = possible_solutions[items_length][weightLimit];

		//El codigo de aqui no afectaba al problema asi que lo borre
		
		//creamos el objeto KnapsackResult que vamos a regresar
		KnapsackResult items_selected = new KnapsackResult(selected_Items, result);

		return items_selected;
		}
	
}
