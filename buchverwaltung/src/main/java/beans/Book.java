package beans;

import java.util.LinkedHashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@RequestScoped
public class Book {
	
	private String author;
	private String name;
	private String publishDate;
	private String price;
	private String[] emailadresses;
	private String language = "de";
	private static LinkedHashMap<String, String> languages;
	private String specialmessage;
	
	static {
		languages = new LinkedHashMap<>();
		languages.put("Deutsch", "de");
		languages.put("Englisch", "en");
		languages.put("Französisch", "fr");
		languages.put("Koreanisch", "kr");
	}
	
	
	public String save() {
		return "index";
	}
	
	public void saveListener(ActionEvent e) {
		System.out.println("Benachrichtigungen an: " + java.util.Arrays.toString(this.emailadresses));
		
	}
	
	public void emailAdressChanged(ValueChangeEvent e) {
		System.out.println("Adressen haben sich geaendert " + java.util.Arrays.toString((String[])e.getNewValue()));
	}
	
	public void emailAdressChangedAjax(AjaxBehaviorEvent e) {
		if(this.emailadresses.length > 1) {
			this.specialmessage = "Zu viele Emails ausgewählt.";
		}else {
			this.specialmessage = "";
		}
	}
	
	
	/*GETTER SETTER*/
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public String[] getEmailadresses() {
		return emailadresses;
	}

	public void setEmailadresses(String[] emailadresses) {
		this.emailadresses = emailadresses;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public LinkedHashMap<String, String> getLanguages() {
		return languages;
	}

	public String getSpecialmessage() {
		return specialmessage;
	}

	public void setSpecialmessage(String specialmessage) {
		this.specialmessage = specialmessage;
	}
	
	

}
