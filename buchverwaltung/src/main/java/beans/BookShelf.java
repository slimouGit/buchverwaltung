package beans;
	
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
	
@ManagedBean
@SessionScoped

public class BookShelf implements Serializable{

           private static final long serialVersionUID = 1L;
           private static final ArrayList<Book> books; 
           private Book inedit;
           private ArrayList<Book> rawBooks;

           static{
               books = new ArrayList<Book>();
               Book book1 = new Book();
               book1.setAuthor("Johann Wolfgang von Goethe");
               book1.setName("Faust");
               book1.setLanguage("de");
               book1.setPublishDate(LocalDate.of(2020,01,01));
               book1.setPurchaseDate(LocalDate.of(2019,01,01));
               book1.setPrice(5.00);
               books.add(book1);
	
               Book book2 = new Book();
               book2.setAuthor("William Shakespeare");
               book2.setName("Romeo und Julia");
               book2.setLanguage("en");
               book2.setPublishDate(LocalDate.of(2020,01,01));
               book2.setPurchaseDate(LocalDate.of(2019,01,01));
               book2.setPrice(8.49);
               books.add(book2);

               Book book3 = new Book();
               book3.setAuthor("Stephen King");
               book3.setName("Es - It");
               book3.setLanguage("en");
               book3.setPublishDate(LocalDate.of(2020,01,01));
               book3.setPurchaseDate(LocalDate.of(2019,01,01));
               book3.setPrice(14.99);
               books.add(book3);
           };

           transient
           private DataModel<Book> booksDataModel;
           
           public DataModel<Book> getBooks() {
        	   if (booksDataModel == null) {
        		   this.rawBooks = new  ArrayList<Book>();
        		   this.rawBooks.addAll(books);        	   
        		   booksDataModel = new ListDataModel<Book>(this.rawBooks);
        	   }

        	   return booksDataModel;
           }           
           
           
           public String prepareNewBook() {
        	   this.inedit = new Book();
        	   return "create";
           }
           
           public String prepareBookEdit(Book book) {
        	   this.inedit = book;
        	   return "update";
           }
           
           public String deleteBook(Book book) {
        	   this.rawBooks.remove(book);
        	   this.booksDataModel = new ListDataModel<Book>(this.rawBooks);
        	   return "index.xhtml?faces-redirect=true";
           }
           
           public String saveBook() {
        	   if(!this.rawBooks.contains(inedit)) {
        		   this.rawBooks.add(inedit);
        		   this.booksDataModel = new ListDataModel<Book>(this.rawBooks);
        	   }
        	   inedit = null;
        	   
        	   return "index";
           }



		public Book getInedit() {
			return inedit;
		}



		public void setInedit(Book inedit) {
			this.inedit = inedit;
		}
           
           
           
           
}