package JavaBasics;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class HadoopMapReduce {
	
	public static void main(String[] args) {
		List<Posting> list1 = new LinkedList<Posting>();
		list1.add(new Posting(2, 12));
		list1.add(new Posting(13, 73));
		list1.add(new Posting(77, 50));
		map.put("exam", list1);

		List<Posting> list2 = new LinkedList<Posting>();
		list2.add(new Posting(22, 12));
		list2.add(new Posting(23, 73));
		list2.add(new Posting(277, 50));
		map.put("Map", list2);
		List<Posting> list3 = new LinkedList<Posting>();
		list3.add(new Posting(22, 153));
		list3.add(new Posting(10, 63));
		list3.add(new Posting(277, 50));
		map.put("or", list3);
		
//		System.out.println(search("or"));

		System.out.println(search("exam", "Map"));

	}
//	Boolean search, only docid is return
	static Map<String, List<Posting>> map = new HashMap<String, List<Posting>>();
	public static List<Integer> search(String... terms) {
		LinkedList<Integer> result = new LinkedList<Integer>();
		if(terms == null || terms.length == 0) return result; 
		Set<Integer> set1 = new TreeSet<Integer>();
		Set<Integer> set2 = new TreeSet<Integer>();
		for(String term : terms){
			if(term == null || term.isEmpty() == true || !map.containsKey(term)){
				continue;
			}
			List<Posting> list  = map.get(term);
			if(set1.size() == 0){
				for(Posting post : list){
					set1.add(post.getDocid()); 
				}
				System.out.printf("set1:1: %s\n",set1);
				continue;
			}else{
				for(Posting post : list){
					set2.add(post.docid); 
				}
				System.out.printf("set1:2: %s\n",set1);
				System.out.printf("set2:2: %s\n",set2);
				set1.retainAll(set2);
				set2.clear();
				if(set1.size() == 0) break;
				System.out.printf("set1:3: %s\n",set1);
			}
		}
		result.addAll(set1);
		return result;
	}
	static class Posting{
		private Integer docid;
		private Integer frequency;
		
		public Posting(Integer docid, Integer frequency) {
			super();
			this.docid = docid;
			this.frequency = frequency;
		}
		public Integer getDocid() {
			return docid;
		}
		public void setDocid(Integer docid) {
			this.docid = docid;
		}
		public Integer getFrequency() {
			return frequency;
		}
		public void setFrequency(Integer frequency) {
			this.frequency = frequency;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((docid == null) ? 0 : docid.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Posting other = (Posting) obj;
			if (docid == null) {
				if (other.docid != null)
					return false;
			} else if (!docid.equals(other.docid))
				return false;
			return true;
		}
		
	}

	class Tuple{
		String  term;
		Integer frequency;
	}

	static class Result{
		private Integer docid;
	}
}
