import java.util.HashMap;

class SolutionMCCC {
    public int minimumCardPickup(int[] cards) {
        int minCards = cards.length+1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<cards.length;i++){
           if(map.containsKey(cards[i])){
                minCards = Math.min(minCards,i - map.get(cards[i])+1);
            }
           map.put(cards[i],i);

        }
/*
        for(int i = 0;i<cards.length;i++){
            int lastIndex = map.get(cards[i]);
            if(lastIndex!=i){
                minCards = Math.min(minCards,lastIndex-i+1);
            }
        }*/
        return minCards;
    }
}
public class MinimumConcecutiveCards {
}
