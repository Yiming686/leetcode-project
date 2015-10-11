package JavaBasics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java_Test {
	static class Position {
		  final int x, y;
		  public Position(final int x, final int y) {
		    this.x = x;
		    this.y = y;
		  }
		}
		 
		static boolean pathExists(int[][] puzzle, Position start, Position end) {
		  // your code goes here
			  // i just like x to be row, and y to be col
		    
		    if(puzzle==null || puzzle.length==0 || puzzle[0]==null || puzzle[0].length==0 || start==null || end==null){
		        return false;// or throw exception
		    }
		    return goNeigber(puzzle,start.y,start.x,end.y,end.x);
		    
		  // your code goes here
		}

		public static boolean goNeigber(int[][] puzzle,int row,int col,int endRow,int endCol){
		    if(row<0 || row>=puzzle.length || col<0 || col>=puzzle[0].length || puzzle[row][col]==1){
		        return false;
		    }
		    if(row==endRow && col==endCol){
		        return true;
		    }
		    puzzle[row][col] = 1;
		    if( goNeigber(puzzle,row+1,col,endRow,endCol) || 
		    goNeigber(puzzle,row-1,col,endRow,endCol) || 
		    goNeigber(puzzle,row,col+1,endRow,endCol) || 
		    goNeigber(puzzle,row,col-1,endRow,endCol) ){
		        return true;
		    }
		    puzzle[row][col] = 0;
		    return false;
		}

		// public Position reversePosition(Position position){
//		     return new Position(position.y,position.x); 
		// }



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] puzzle1 = {{0, 0, 1, 0, 1}, {0, 0, 0, 0, 0},{0, 1, 1, 1, 1},{0, 1, 1, 0, 0}};
		Position start = new Position(0, 0);
		Position end   = new Position(4, 3);
		System.out.println("(4,1), (0,3):"+pathExists(puzzle1,  start,  end));
		int[][] puzzle2= {{0, 0, 1, 1, 1},{0, 1, 0, 0, 0},{1, 1, 1, 1, 1},{0, 0, 0, 0, 1}};
		 start = new Position(0, 0);
		 end   = new Position(1, 2);
		 System.out.println("(0,0), (1,2):"+pathExists(puzzle1,  start,  end));
		int[][] puzzle3= {{0, 0, 1, 1, 1},{0, 1, 0, 0, 0},{0, 1, 1, 1, 1}};
		 start = new Position(0, 0);
		 end   = new Position(2, 1);
		 System.out.println("(0,0), (2,1):"+pathExists(puzzle3,  start,  end));
	}
	
	class Item {
	    String itemId;
	    int quantitySold;
	}
	public static String find(List<Item> items, int i) {
	    if(items==null ){
	        return "";// or throw exception
	    }
	    Map<String,Item> map = new HashMap();
	    
	    for(Item each:items){
	        String itemId = each.itemId;
	        if(map.containsKey(itemId)){
	            Item cur = map.get(itemId);
	            cur.quantitySold = cur.quantitySold+each.quantitySold;
	            map.put(itemId,cur);
	        }else{
	            map.put(itemId,each);
	        }
	    }
//	    Collections.sort
	    List<Item> list = new ArrayList<Item>();
	    list.addAll(map.values());
		Collections.sort(list, new Comparator<Item>(){

			@Override
			public int compare(Item o1, Item o2) {
				// TODO Auto-generated method stub
				return o1.quantitySold - o2.quantitySold;
			}
			
		});
		return list.get(list.size() - i).itemId;
		
	}

}
