package Lintcode.Array.Interval;

/* dafdfa /* dafd *. 1point3acres.com/jsdd;afkdas
/* afadd // adfad */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RocketFuel_Racer_Rater_1 {

    public static void main(String[] args) {
        
        Racer r1 = new Racer(2L,100L,200L);        
        Racer r2 = new Racer(3L, 110L, 190L);
        Racer r3 = new Racer(4L, 105L, 145L);
        Racer r4 = new Racer(1L, 90L, 150L);
        Racer r5 = new Racer(5L, 102L, 198L);
        
        
        Racer[] racers = new Racer[]{r1, r2, r3,r4,r5};
        
        Racer[] racersByStartTime = racers.clone();
        Arrays.sort(racersByStartTime, new Comparator<Racer>(){
            @Override
            public int compare(Racer r1, Racer r2) {
                return r1._start.compareTo(r2._start);
            }            
        });
        
        Racer[] racersByEndTime = racers.clone();
        Arrays.sort(racersByEndTime, new Comparator<Racer>(){
            @Override
            public int compare(Racer r1, Racer r2) {
                return r1._end.compareTo(r2._end);
            }            
        });
        
        
        List<Racer> buildingRacersByStartTime = new ArrayList<Racer>();
        buildingRacersByStartTime.add(racersByEndTime[0]);
        for(int i = 1;i<racersByEndTime.length; ++i)
        {
            Racer racer = racersByEndTime[i];         
            //前面有几匹马已经到达终点
            int lenBeforeInsersion = buildingRacersByStartTime.size();
            //在所有已经到达的马匹里面，根据start时间，当前racer排在第几位
            int whereToInsert = GetInsertLocation(buildingRacersByStartTime, racer);
            //如下不行，因为list是动态的，每次搜索，结果可能不同
//            int whereToInsert = Collections.binarySearch(buildingRacersByStartTime, racer, new Comparator<Racer>(){
//                @Override
//                public int compare(Racer r1, Racer r2) {
//                    return r1._start.compareTo(r2._start);
//                }            
//            });
            whereToInsert = whereToInsert == -1 ? 0 : whereToInsert;
            //相减即是得分
            racer._score = lenBeforeInsersion - whereToInsert;
            buildingRacersByStartTime.add(whereToInsert, racer);
        }
        
        Racer[] racersByScore = racers.clone();
        Arrays.sort(racersByScore, new Comparator<Racer>(){
            @Override
            public int compare(Racer r1, Racer r2) {
                int t = r1._score - r2._score;
                if(t!=0)
                    return t;
                return r1._id.compareTo(r2._id);
            }            
        });
        
        System.out.println("=====input====");
        for(Racer r : racers)
            System.out.println(r._id+","+r._start+","+r._end);
        System.out.println("=====racers by start time====");
        for(Racer r : racersByStartTime)
            System.out.println(r._id+","+r._start+","+r._end);
        System.out.println("=====racers by end time====");
        for(Racer r : racersByEndTime)
            System.out.println(r._id+","+r._start+","+r._end);
        System.out.println("=====racers by score====");
        for(Racer r : racersByScore)
            System.out.println(r._id+",score:"+ r._score +","+r._start+","+r._end);
    }

    /**
     * return where to insert the racer while dynamically constructing the racer list in start time order
     */
    private static int GetInsertLocation(List<Racer> constructingRacersInStartTimeOrder, Racer r)
    {    
        int iLeft = 0;
        int iRight = constructingRacersInStartTimeOrder.size() - 1;
        while(iLeft <= iRight)
        {
            int iMid = (iLeft+iRight)/2;
            if(r._start == constructingRacersInStartTimeOrder.get(iMid)._start)
                return iMid;
            if(r._start < constructingRacersInStartTimeOrder.get(iMid)._start)
                iRight = iMid -1;
            else
                iLeft = iMid +1;
        }        
        return iLeft;
    }

}
class Racer {
    Long _id;
    Long _start;
    Long _end;
    int _score;
    
    public Racer(Long id, Long start, Long end)
    {
        _id = id;
        _start = start;
        _end = end;
    }    
}

/*
Problem Statement:
 
At the Intergalactic Space Race, spaceships from across the galaxy compete to determine which ship is the fastest. 
To score the race, the Intergalactic Space Race Association (ISRA) uses the following algorithm:
 
Each spaceship S is given a score equal to the number of other spaceships who both started after and finished before S.
 
Note that lower scores indicate a faster spaceship. The ISRA likes this system because it does not penalize fast ships that were slowed down 
because they were stuck behind a slow spaceship. Additionally, the algorithm does not reward fast spaceships who passed many slow competitors 
in comparison to fast spaceships who race when there are not so many slow competitors on the track to pass.
 
The ISRA has hired you to implement this scoring algorithm. Given the log of spaceships with their start and end times, 
your task is to output the score for each spaceship.
 
Input Format
 
The first line of input will contain the number of spaceships competing. After that, there will be one line per spaceship, in the following format:
 
spaceshipId startTime endTime
 
Notes on input:
•	The number of  spaceships will be an integer from 0 to 70,000
•	spaceshipId will be an integer in the range [0, 10^9]
•	startTime and endTime are both integers that satisfy 0 <= startTime < endTime <= 10^18
•	spaceshipId is distinct
•	start and end times (taken as a whole) will not contain any duplicate elements. If a racer has a start time of x, 
then no other start or end time will also equal x.
•	The fields are space delimited
 
Output Format
 
Given the input, your task is to output a score for each spaceshipId in the following format:
 
spaceshipId score
 
with score as defined above. The output lines should be sorted in ascending order of score with ties broken by sorting by spaceshipId, 
also in ascending order. The sorting can be accomplished with a simple sort at the end.
 
Directions:
Please design a solution that is o(n2) (that is "little-o," i.e. strictly less than O(n2)). 
Brute force solutions that are not o(n2) will not be fast enough and fail some of the harder test cases.
 
One way you may achieve o(n2) time is to utilize a data structure with X buckets, where X is some number (perhaps some function of input size). 
Each of the buckets is initially empty and defined by a start and end time.  
Eventually, each bucket will contain spaceships whose start times fall between the bucket’s start and end time.  
The bucket boundaries should be chosen such that the buckets will ultimately contain the same number of spaceships. 
With this framework, you can iterate over the spaceships in end time order and as you iterate over each spaceship, 
fill in the bucketed data structure such that you can use it to quickly count the number of competitors that finished before and started after that spaceship.
 
You may ignore the above hint and use a different algorithm if you prefer.
 
Sample Input and Output
 
Input:
5
2 100 200
3 110 190
4 105 145
1 90 150
5 102 198
 
Output:
3 0
4 0
1 1
5 2
2 3
 
Note that in the above example spaceship 3 has a score of 0 because no one starts after spaceship 3 
(a drawback to this scoring system is the last spaceship always has a score of 0). 
Spaceship 4 also has a score of 0 because the only racer who starts after spaceship 4's start time (spaceship 3) has a later finish time. 
Spaceship 3 is listed ahead of spaceship 4 despite having a slower time because spaceship 3's id is lower. At the other end, 
spaceship 2 has a score of 3 because spaceships 3, 4, and 5 start after spaceship 2 and finish before spaceship 2 finished.

 * */

