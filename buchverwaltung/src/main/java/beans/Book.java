package beans;

import java.time.LocalDate;
import java.util.LinkedHashMap;

import javax.annotation.PostConstruct;
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
	private LocalDate publishDate;
	private Double price;
	private String[] emailadresses;
	private String language = "de";
	private LinkedHashMap<String, String> languages;
	private String specialmessage;
	
	private LinkedHashMap<String, String> emails;
	private String[] selectedEmails; 
	
	@PostConstruct
    public void init() {
		emails = new LinkedHashMap<>();
		emails.put("Abteilung 1", "abteilung1@mycompany.com");
		emails.put("Abteilung 2", "abteilung2@mycompany.com");
		emails.put("Abteilung 3", "abteilung3@mycompany.com");
		
		languages = new LinkedHashMap<>();
		languages.put("Deutsch", "de");
		languages.put("Englisch", "en");
		languages.put("Französisch", "fr");
		languages.put("Koreanisch", "kr");
	}	
	
	public String save() {
		return "create";
	}
	
	public void saveListener(ActionEvent e) {
		System.out.println("Benachrichtigungen an: " + java.util.Arrays.toString(this.selectedEmails));
		
	}
	
	public void emailAdressChanged(ValueChangeEvent e) {
		System.out.println("Adressen haben sich geaendert " + java.util.Arrays.toString((String[])e.getNewValue()));
	}
	
	public void emailAdressChangedAjax(AjaxBehaviorEvent e) {
		if(this.selectedEmails.length > 1) {
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
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
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

	public LinkedHashMap<String, String> getEmails() {
		return emails;
	}

	public String[] getSelectedEmails() {
		return selectedEmails;
	}

	public void setSelectedEmails(String[] selectedEmails) {
		this.selectedEmails = selectedEmails;
	}	
	

}
