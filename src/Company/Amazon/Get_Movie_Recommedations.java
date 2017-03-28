package Company.Amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**

Movie Recommendation

There is a network of similar movies which are attributed by a unique identifier and a rating. 
Each movie in the network is related to one or more movies in the network through a direct connection.

Design a way to find the N highest rated movies for a given movie in the network of related movies. 
The original movie should not be considered as a potential recommendation. If the number of requested movies 
is greater than the total number of movies, then output all the related movies.

Input
The input to the function/method consists of two arguments - 
movie, representing the node of the original movie in the movie network and 
N, an integer representing the number of requested movies.

Output
Return a list containing the nodes of the N highest rated movies.

Constraints
0 ¡Ü N

Note
The order of movies in the output list does not matter.

Examples
The Movie network is as given below:

        A(1.2)
        /     \ 
      /         \
B(3.6)    C(2.4) 
     \          / 
       \      / 
       D(4.8)

Example1: 
Input:
movie = A 
N = 2

Output:
B, D

Explanation:
In the given network, the movies D and B have the highest rating. 
The distance from A to D does not matter; the highest rated movies in the network should be returned regardless of the distance. 
The movies to be returned are either B, D or D, B as the order of the movies in the output does not matter.

Example2:
Input:
movie = A 
N = 10

Output:
B, C, D.

Explanation:
Although 10 movies are requested, but only 3 related movies are available. So, the output is B, C, D.

Helper Description
The following class is used to represent a movie :
 
 class Movie{
 
 }

 *
 *
 */
public class Get_Movie_Recommedations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();

		Movie movie1 = new Movie(1, 1.2f);//A
		Movie movie2 = new Movie(2, 3.6f);//B
		Movie movie3 = new Movie(3, 2.4f);//C
		Movie movie4 = new Movie(4, 4.8f);//D
		movie1.getSimilarMovies().add(movie2);
		movie1.getSimilarMovies().add(movie3);
		
		movie2.getSimilarMovies().add(movie1);
		movie2.getSimilarMovies().add(movie4);
		
		movie3.getSimilarMovies().add(movie1);
		movie3.getSimilarMovies().add(movie4);
		
		movie4.getSimilarMovies().add(movie2);
		movie4.getSimilarMovies().add(movie3);

		Set<Movie> set = getMovieRecommendations (movie4, 3);
		for(Movie m : set){
			System.out.println(""+m.getId() +", "+ m.getRating());	
		}
		
	}

	public static Set<Movie> getMovieRecommendations (Movie movie, int N) 
	{
		// WRITE YOUR CODE HERE
		Set<Movie> set = new HashSet<>();
		Set<Movie> visited = new HashSet<>();
		if(movie == null || N <=0 ) return set;
		Queue<Movie> pq = new PriorityQueue<>((Movie m1, Movie m2) -> { 
		    float val1 = m1.getRating();
		    float val2 = m2.getRating();
		    if(val1 == val2){
		        return 0;
		    }else if(val1 > val2){
		        return 1;
		    }else{
		        return -1;
		    }
		} );
		Queue<Movie> queue = new LinkedList<>();
		queue.offer(movie);
		visited.add(movie);
		while(!queue.isEmpty()){
		    int size = queue.size();
		    for(int i = 0; i < size; i++){
		        Movie temp = queue.poll();
		        if(!temp.equals(movie)){
    		        if(pq.size() < N){
    		                pq.offer(temp);
    		        }else if(temp.getRating() > pq.peek().getRating()){
    		                pq.poll();
    		                pq.offer(temp);
    		        }
		        }
		        for(Movie m : temp.getSimilarMovies()){
		        	if(!visited.contains(m)){
		        		queue.offer(m);
		        		visited.add(m);
		        	}
		        }
		    }
		}
		set.addAll(pq);
		return set;
	}
	
	static class Movie {
	    private int movieId;
	    private float rating;
	    private ArrayList<Movie> similarMovies = new ArrayList<Movie>();

	    /**
	    * Intializes this instance with given movieId and rating.
	    */
	    public Movie(int movieId, float rating){
	    	this.movieId = movieId;
	    	this.rating = rating;
	    };

	    /**
	    * @returns an integer representing the id for this movie.
	    */
	    public int getId(){
	    	return movieId;
	    };

	    /**
	    * @returns a rating for this movie.
	    */
	    public float getRating(){
	    	return rating;
	    };

	    /**
	    * Add given movie to the list of similar movies.
	    */
	    public void addSimilarMovie(Movie movie){
	    	similarMovies.add(movie);
	    };

	    /**
	    * @returns a list of similar movies for this movie.
	    */
	    public List<Movie> getSimilarMovies(){
	    	return similarMovies;
	    }

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + movieId;
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
			Movie other = (Movie) obj;
			if (movieId != other.movieId)
				return false;
			return true;
		};
	    
	    
	}	
}
