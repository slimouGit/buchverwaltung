package beans;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("vornameNachnameValidator")
public class VornameNachnameValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		if(!(((String) value).split(" ").length >= 2)) {
			FacesMessage message = new FacesMessage("Vorname und Nachname angeben","Vorname und Nachname angeben");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			
			throw new ValidatorException(message);
		}

	}

}
