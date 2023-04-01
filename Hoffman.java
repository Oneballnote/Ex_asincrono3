package Ex_asincrono3;

import java.util.HashMap;
import java.util.Map;

public class Hoffman {
    
    public static Map<Character, Integer> conteo(String frase)
    {
        Map<Character, Integer> letter_Count_Map = new HashMap<>();

        for(int i = 0; i < frase.length(); i++)
        {
            char letter = frase.charAt(i); 
            if(letter_Count_Map.containsKey(letter))
            {
                letter_Count_Map.put(letter, letter_Count_Map.get(letter) + 1);

            }else
            {
                letter_Count_Map.put(letter, 1);
            }
        }
        
        return letter_Count_Map;
    }
}
