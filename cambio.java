import java.util.Arrays;

class cambio {

	public static void main(String[] args) {
		int[] denominaciones = {1, 4, 6};
		int cantidad = 12;
		cambio(cantidad, denominaciones);
	}
	
	public static void cambio(int n, int[] denominaciones) {
	    int[] sol = new int[n+1];
	    Arrays.fill(sol, Integer.MAX_VALUE);
	    sol[0] = 0;
	    
	    for (int d : denominaciones) {
	        for (int i = d; i <= n; i++) {
	            sol[i] = Math.min(sol[i], sol[i-d]+1);
	        }
	    }
	    
	    System.out.println("Cantidad mínima de monedas: " + sol[n]);
	    
	    System.out.print("Monedas utilizadas: ");
	    for (int i = n; i > 0;) {
	        for (int d : denominaciones) {
	            if (i - d >= 0 && sol[i-d] == sol[i]-1) {
	                System.out.print(d + " ");
	                i -= d;
	                break;
	            }
	        }
	    }
	}
}
