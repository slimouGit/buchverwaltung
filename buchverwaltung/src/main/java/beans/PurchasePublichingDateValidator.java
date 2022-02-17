package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PurchasePublichingDateValidator {

	public String validiereVeroeffentlichungsUndKaufdatum(Book book) {
		String message = "";
		if (null != book.getPublishDate() && null != book.getPurchaseDate()) {
			System.out.println("Ver�ffentlichungsdatum " + book.getPublishDate());
			System.out.println("Kaufdatum " + book.getPurchaseDate());
			if(book.getPurchaseDate().isBefore(book.getPublishDate())){
				message="Kaufdatum kann nicht vor dem Erscheinungsdatum liegen";
				System.out.print(message);
			}
		}
		return message;
	}

}
