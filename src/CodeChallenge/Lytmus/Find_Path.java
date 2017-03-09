package CodeChallenge.Lytmus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Find_Path {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> lines = new ArrayList<String>();
		lines.add("A E");
		/*
		 * lines.add("A : B D"); lines.add("B : C D"); lines.add("D : C");
		 */

		lines.add("A : B C D");
		lines.add("B : C");
		lines.add("C : E");
		lines.add("D : B");

		List<String> paths = new ArrayList<String>();
		paths = parseLines(lines);

		for (String str : paths)
		{
			System.out.println(str);
		}

	}

	static List<String> parseLines(List<String> lines)
	{
		if (lines == null){
			return null;
		}
		if (lines.isEmpty()){
			return new ArrayList<String>();
		}
		String srcDes = lines.get(0);
		char src = srcDes.split(" ")[0].charAt(0);
		char des = srcDes.split(" ")[1].charAt(0);
		Map<Character, LinkedList<Character>> graphMap = new HashMap<Character, LinkedList<Character>>();
		for (int i = 1; i < lines.size(); i++){
			LinkedList<Character> nodeList = new LinkedList<Character>();
			String line = lines.get(i);
			String[] arr = line.split(":");
			char key = arr[0].charAt(0);
			arr = arr[1].split(" ");
			for (int j = 1; j < arr.length; j++){
				nodeList.addLast(arr[j].charAt(0));
			}
			graphMap.put(key, nodeList);
		}
		System.out.println("adjMap: "+graphMap);
		if (!graphMap.containsKey(src)){
			return new ArrayList<String>();
		}

		LinkedList<Character> visited = new LinkedList<Character>();
		visited.add(src);
		List<String> paths = new ArrayList<String>();
		dfs(graphMap, visited, des, paths);
		return paths;
	}


	static void dfs(Map<Character, LinkedList<Character>> graphMap, LinkedList<Character> visited, Character end,
			List<String> paths)
	{

		if (!graphMap.containsKey(visited.getLast())){
			return;
		}

		LinkedList<Character> nodes = graphMap.get(visited.getLast());
		for (Character node : nodes){
			if (visited.contains(node)){
				continue;
			}
			if (node.equals(end)){
				visited.add(node);
				printPath(visited, paths);//printPath
				visited.removeLast();
				break;
			}
		}
		for (Character node : nodes){
			if (visited.contains(node) || node.equals(end)){
				continue;
			}
			visited.addLast(node);
			dfs(graphMap, visited, end, paths);
			visited.removeLast();
		}
	}

	private static void printPath(LinkedList<Character> visited, List<String> paths)
	{
		StringBuffer output = new StringBuffer("");
		for (Character node : visited){
			output.append(node + " ");
		}
		paths.add(output.toString());
	}

}
