package Ex_asincrono3;
import java.util.*;
/**
 * Arboles
 */
public class Arboles {
    //Punto 1
    public boolean existsPath(Node root, int x) {
        if (root == null) {
            return false;
        }
    
        return existsPath(root, 0, x);
    }
    
    private boolean existsPath(Node node, int sum, int x) {
        if (node == null) {
            return false;
        }
    
        sum += node.value % 2 == 1 ? 1 : 0;
        
        if (node.left == null && node.right == null) {
            return sum == x;
        }
    
        return existsPath(node.left, sum, x) || existsPath(node.right, sum, x);
    }
    //Punto 2
    public boolean isBST(Node nodo) {
        if (nodo == null) { // Si el árbol está vacío, es un árbol de búsqueda.
            return true;
        }
        if (nodo.left != null && nodo.value < nodo.left.value) { // Si el value del nodo actual es menor que algún value en el subárbol left, no es un árbol de búsqueda.
            return false;
        }
        if (nodo.right != null && nodo.value > nodo.right.value) { // Si el value del nodo actual es mayor que algún value en el subárbol right, no es un árbol de búsqueda.
            return false;
        }
        return isBST(nodo.left) && isBST(nodo.right); // Se aplica la recursión para cada subárbol.
    }
    //Punto 3
    public List<List<Node>> getNodeListPerLevel(Node root) {
        List<List<Node>> node_List = new ArrayList<>();
        if (root == null) {
            return node_List;
        }
    
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
    
        while (!queue.isEmpty()) {
            int level_Size = queue.size();
            List<Node> level_List = new ArrayList<>();
    
            for (int i = 0; i < level_Size; i++) {
                Node curr_Node = queue.poll();
                level_List.add(curr_Node);
    
                if (curr_Node.left != null) {
                    queue.offer(curr_Node.left);
                }
                if (curr_Node.right != null) {
                    queue.offer(curr_Node.right);
                }
            }
    
            node_List.add(level_List);
        }
    
        return node_List;
    }
}