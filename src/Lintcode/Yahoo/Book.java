package Lintcode.Yahoo;

import java.util.Date;
import java.util.List;

import org.supercsv.cellprocessor.FmtDate;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;

public class Book {

//}
//
//
//class Book {
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private Date published;
    private double price;
    List<Book> book;
 
    public Book() {
        // this empty constructor is required
    }
    CellProcessor[] processors = new CellProcessor[] {
            new NotNull(), // ISBN
            new NotNull(), // title
            new NotNull(), // author
            new NotNull(), // publisher
            new FmtDate("MM/dd/yyyy"), // published date
            new ParseDouble() // price
    };
 
    public Book(String isbn, String title, String author, String publisher,
            Date published, double price, List<Book> book) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.published = published;
        this.price = price;
        this.book = book;
    }

	public String getBn() {
		return isbn;
	}

	public void setBn(String bn) {
		this.isbn = bn;
	}

	public CellProcessor[] getProcessors() {
		return processors;
	}

	public void setProcessors(CellProcessor[] processors) {
		this.processors = processors;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublished() {
		return published;
	}

	public void setPublished(Date published) {
		this.published = published;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}
 
    // getters and setters
    
    
}


