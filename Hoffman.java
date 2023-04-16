package Ex_asincrono3;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    char symbol;
    int frequency;
    Node left;
    Node right;

    public Node(char symbol, int frequency) {
        this.symbol = symbol;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Node other) {
        return this.frequency - other.frequency;
    }
}

public class Hoffman {

    public static void main(String[] args) 
    {

        String originalString = "hello world";
        String encoding = "";
        Node root_huffman_Tree = buildHuffmanTree(originalString);
        Map<Character, String> encodingMap = new HashMap<>();

        encodeSymbols(root_huffman_Tree, encoding, encodingMap);
        
        String encodedString = encodeString(originalString, encodingMap);
        String decodedString = decodeString(encodedString, root_huffman_Tree);
        
        System.out.println("Original String: " + originalString);
        System.out.println("Encoded String: " + encodedString);
        System.out.println("Decoded String: " + decodedString);
        
        if (originalString.equals(decodedString))
            System.out.println("Decoding successful!");
        else 
            System.out.println("Decoding failed.");
        
    }
    

    public static Node buildHuffmanTree(String s) 
    {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) 
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (char c : frequencyMap.keySet()) 
            pq.offer(new Node(c, frequencyMap.get(c)));
        

        while (pq.size() > 1) 
        {
            Node p = pq.poll();
            Node q = pq.poll();
            Node n = new Node('\0', p.frequency + q.frequency);
            n.left = p;
            n.right = q;
            pq.offer(n);
        }

        Node root = pq.poll();


        return root;
    }

    private static void encodeSymbols(Node node, String encoding , Map<Character, String> encodingMap) {
        
        if (node.left == null && node.right == null) 
            encodingMap.put(node.symbol, encoding);
        else 
        {
            encodeSymbols(node.left, encoding + "0", encodingMap);
            encodeSymbols(node.right, encoding + "1", encodingMap);
        }
    }

    public static String encodeString(String s, Map<Character, String> encodingMap) 
    {
        StringBuilder encodedString = new StringBuilder();

        for (char c : s.toCharArray()) 
            encodedString.append(encodingMap.get(c));
        

        return encodedString.toString();
    }

    public static String decodeString(String encodedString, Node root) 
    {
        StringBuilder decodedString = new StringBuilder();
        Node node = root;

        for (int i = 0; i < encodedString.length(); i++) 
        {
            char bit = encodedString.charAt(i);

            if (bit == '0') 
                node = node.left;
            else 
                node = node.right;
            
            if (node.left == null && node.right == null) 
            {
                decodedString.append(node.symbol);
                node = root;
            }
        }

        return decodedString.toString();
    }


}
