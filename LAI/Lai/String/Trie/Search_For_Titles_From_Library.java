package Lai.String.Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
* To execute Java, please define "static void main" on a class
* named Solution.
*
* If you need more classes, simply define them inline.
*
* Given a flat file of book metadata, write a Library class that parses the book data and provides an API that lets you search for all books containing a word.
*
* API:
*
* Library
* - <constructor>(input) -> returns a Library object
* - search(word) -> returns all books that contain the word anywhere in the title, author, or description fields. Only matches *whole* words.
* E.g. Searching for "My" or "book" would match a book containing "My book", but searching for "My b" or "boo" would *not* match.
*/

public class Search_For_Titles_From_Library {

	public static void main(String[] args) {
//		Library library = new Library("TITLE: Hitchhiker's Guide to the Galaxy\n" + "AUTHOR: Douglas Adams\n");	
		Library library = new Library("" + "TITLE: Hitchhiker's Guide to the Galaxy\n" + "AUTHOR: Douglas Adams\n"
				+ "DESCRIPTION: Seconds before the Earth is demolished to make way for a galactic freeway,\n"
				+ "Arthur Dent is plucked off the planet by his friend Ford Prefect, a researcher for the\n"
				+ "revised edition of The Hitchhiker's Guide to the Galaxy who, for the last fifteen years,\n"
				+ "has been posing as an out-of-work actor.\n" + "\n" + "TITLE: Dune\n" + "AUTHOR: Frank Herbert\n"
				+ "DESCRIPTION: The troubles begin when stewardship of Arrakis is transferred by the\n"
				+ "Emperor from the Harkonnen Noble House to House Atreides. The Harkonnens don't want to\n"
				+ "give up their privilege, though, and through sabotage and treachery they cast young\n"
				+ "Duke Paul Atreides out into the planet's harsh environment to die. There he falls in\n"
				+ "with the Fremen, a tribe of desert dwellers who become the basis of the army with which \n"
				+ "he will reclaim what's rightfully his. Paul Atreides, though, is far more than just a\n"
				+ "usurped duke. He might be the end product of a very long-term genetic experiment\n"
				+ "designed to breed a super human; he might be a messiah. His struggle is at the center\n"
				+ "of a nexus of powerful people and events, and the repercussions will be felt throughout\n"
				+ "the Imperium.\n" + "\n" + "TITLE: A Song Of Ice And Fire Series\n" + "AUTHOR: George R.R. Martin\n"
				+ "DESCRIPTION: As the Seven Kingdoms face a generation-long winter, the noble Stark family\n"
				+ "confronts the poisonous plots of the rival Lannisters, the emergence of the\n"
				+ "White Walkers, the arrival of barbarian hordes, and other threats.\n");

		List<String> first_results = library.search("Arrakis");
		System.out.println(first_results.contains("Dune"));

		List<String> second_results = library.search("R.R.");
		System.out.println(second_results.contains("A Song Of Ice And Fire Series"));

		List<String> third_results = library.search("c");
		System.out.println(third_results.contains("Hitchhiker's Guide to the Galaxy"));

		List<String> fourth_results = library.search("the");
		System.out.println(fourth_results.size() == 3);
		System.out.println(fourth_results.contains("Dune"));
		System.out.println(fourth_results.contains("A Song Of Ice And Fire Series"));
		System.out.println(fourth_results.contains("Hitchhiker's Guide to the Galaxy"));
	}

	static class Book {
		String title;//PK
		String author;
		String description;
		Book(){
			
		}
		Book(String title, String author, String description) {
			this.title = title;
			this.author = author;
			this.description = description;
		}
	}

	static class TrieNode {
		Map<Character, TrieNode> children;
		boolean isWord;
		List<String> titles;
		TrieNode() {
			this.children = new HashMap<>();
			this.titles = new ArrayList<>();
		}

	}

	static class Library {
		TrieNode root;
		Map<String, List<String>> keyToTitle = new HashMap<String, List<String>>();
		List<Book> books = new ArrayList<>();

		public Library(String lib) {
//			String[] books = lib.split("\n\n");
//			for (String book : books) {
//				Book curBook = initBook(book);
//				buildIndex(curBook);
//			}
			root = new TrieNode();
			String title = "Hitchhiker's Guide to the c Galaxy ";//PK
			String author = "Douglas Adams";
			String description = "Seconds before the Earth is demolished to make way for a galactic freeway";
			Book book =new Book(title, author, description); 
			books.add(book);
			add(book);
			title = "Dune";//PK
			author = "Frank c Herbert";
			description = "The troubles begin when stewardship of Arrakis is transferred by the";
			book =new Book(title, author, description); 
			books.add(book);
			add(book);
			title = "A Song Of Ice And Fire Series";//PK
			author = "George R.R. Martin";
			description = "As the Seven Kingdoms c face a generation-long winter, the noble Stark family";
			book =new Book(title, author, description); 
			books.add(book);
			add(book);			
		}

		private void buildIndex(Book curBook) {
			// TODO Auto-generated method stub

		}
		public void add(Book book) {
			if(book == null) {
				return;
			}
			add(book.title, book);
			add(book.author, book);
			add(book.description, book);
		}
		public void add(String strs, Book book) {
			if(strs == null || strs.length() == 0) {
				return;
			}
			String[] arr = strs.split(" ");
			
			for(String str : arr) {
				TrieNode curr = root;
				for(int i = 0; i < str.length(); i++) {
					TrieNode next = curr.children.get(str.charAt(i));
					if(next == null) {
						next = new TrieNode();
						curr.children.put(str.charAt(i), next);
					}					
					curr = next;					
				}	
				curr.isWord = true;
				curr.titles.add(book.title);
			}
			
		}

		public List<String> search(String keyword) {
			List<String> titles = new ArrayList<>();
			if (keyword == null || keyword.length() == 0) {
				return titles;
			}
			TrieNode curr = root;
			for(int i = 0; i < keyword.length(); i++) {
				TrieNode next = curr.children.get(keyword.charAt(i));
				if(next == null) {
					next = new TrieNode();
					curr.children.put(keyword.charAt(i), next);
				}
//				curr.children.put(keyword.charAt(i), next);
				curr = next;					
			}	
			if(curr.isWord) {
				return curr.titles;	
			}else {
				return titles;
			}
			
		}

		private Book initBook(String book) {
			Book curBook = new Book();
			String[] keyFields = book.split("\n");
			boolean descStarted = false;
			StringBuilder descSb = new StringBuilder();
			for (String keyField : keyFields) {
				if (keyField.toLowerCase().startsWith("title")) {
					curBook.title = keyField.substring(keyField.toLowerCase().indexOf("title") + "title".length() + 1)
							.trim();
				} else if (keyField.toLowerCase().startsWith("author")) {
				}
			}
			return curBook;
		}
	}
}
