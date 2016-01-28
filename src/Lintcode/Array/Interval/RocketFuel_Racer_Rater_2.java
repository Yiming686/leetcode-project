package Lintcode.Array.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RocketFuel_Racer_Rater_2 {

    public static void main(String[] args) {
        
        SpaceShip r1 = new SpaceShip(2L,100L,200L);        
        SpaceShip r2 = new SpaceShip(3L, 110L, 190L);
        SpaceShip r3 = new SpaceShip(4L, 105L, 145L);
        SpaceShip r4 = new SpaceShip(1L, 90L, 150L);
        SpaceShip r5 = new SpaceShip(5L, 102L, 198L);
        
        
        SpaceShip[] spaceShips = new SpaceShip[]{r1, r2, r3,r4,r5};
        
        SpaceShip[] spaceShipsSortByStartTime = spaceShips.clone();
        Arrays.sort(spaceShipsSortByStartTime, new Comparator<SpaceShip>(){
            @Override
            public int compare(SpaceShip ss1, SpaceShip ss2) {
                return ss1.startTime.compareTo(ss2.startTime);
            }            
        });
        
        SpaceShip[] spaceShipsByEndTime = spaceShips.clone();
        Arrays.sort(spaceShipsByEndTime, new Comparator<SpaceShip>(){
            @Override
            public int compare(SpaceShip ss1, SpaceShip ss2) {
                return ss1.endTime.compareTo(ss2.endTime);
            }            
        });
        
        
        List<SpaceShip> listByStartTime = new ArrayList<SpaceShip>();
        listByStartTime.add(spaceShipsByEndTime[0]);
        for(int i = 1;i<spaceShipsByEndTime.length; ++i)
        {
            SpaceShip ss = spaceShipsByEndTime[i];         
            int numBeforeEndTime = listByStartTime.size();
            int indexToInsert = getIndexToInsert(listByStartTime, ss);
            ss.score = numBeforeEndTime - indexToInsert;
            listByStartTime.add(indexToInsert, ss);
        }
        
        SpaceShip[] spaceShipsByScore = spaceShips.clone();
        Arrays.sort(spaceShipsByScore, new Comparator<SpaceShip>(){
            @Override
            public int compare(SpaceShip ss1, SpaceShip ss2) {
                int t = ss1.score - ss2.score;
                if(t!=0)
                    return t;
                return ss1.id.compareTo(ss2.id);
            }            
        });
        
        System.out.println("=====input====");
        for(SpaceShip r : spaceShips)
            System.out.println(r.id+","+r.startTime+","+r.endTime);
        System.out.println("=====racers by start time====");
        for(SpaceShip r : spaceShipsSortByStartTime)
            System.out.println(r.id+","+r.startTime+","+r.endTime);
        System.out.println("=====racers by end time====");
        for(SpaceShip r : spaceShipsByEndTime)
            System.out.println(r.id+","+r.startTime+","+r.endTime);
        System.out.println("=====racers by score====");
        for(SpaceShip r : spaceShipsByScore)
            System.out.println(r.id+",score:"+ r.score +","+r.startTime+","+r.endTime);
        System.out.println("=====racers by Id and score====");
        
        for(SpaceShip ss : spaceShipsByScore)
            System.out.println(ss.id+" "+ ss.score);

    }
    

    /**
     * return where to insert the racer while dynamically constructing the racer list in start time order
     */
    private static int getIndexToInsert(List<SpaceShip> listByStartTime, SpaceShip ss)
    {    
        int left = 0;
        int right = listByStartTime.size() - 1;
        while(left<=right)
        {
            int mid = (left+right)/2;
            if(ss.startTime == listByStartTime.get(mid).startTime)
                return mid;
            if(ss.startTime < listByStartTime.get(mid).startTime)
                right = mid -1;
            else
                left = mid +1;
        }        
        return left;
    }

}
class SpaceShip {
	
    Long id;
    Long startTime;
    Long endTime;
    int score;
    
    public SpaceShip(Long id, Long startTime, Long endTime)
    {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }    
}

