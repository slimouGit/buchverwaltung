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

           static{
               books = new ArrayList<Book>();
               Book book1 = new Book();
               book1.setAuthor("Johann Wolfgang von Goethe");
               book1.setName("Faust");
               book1.setLanguage("de");
               book1.setPublishDate(LocalDate.of(2022, 12, 04));
               book1.setPrice(5.00);
               books.add(book1);
	
               Book book2 = new Book();
               book2.setAuthor("William Shakespeare");
               book2.setName("Romeo und Julia");
               book2.setLanguage("en");
               book2.setPublishDate(LocalDate.of(1957, 12, 04));
               book2.setPrice(8.49);
               books.add(book2);

               Book book3 = new Book();
               book3.setAuthor("Stephen King");
               book3.setName("Es - It");
               book3.setLanguage("en");
               book3.setPublishDate(LocalDate.of(1986, 12, 04));
               book3.setPrice(14.99);
               books.add(book3);
           };

           transient
           private DataModel<Book> booksDataModel;
           
           public DataModel<Book> getBooks() {
        	   if (booksDataModel == null)
        		   booksDataModel = new ListDataModel<Book>(books);

        	   return booksDataModel;
           }   
}