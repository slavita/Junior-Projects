package bean;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

@FacesValidator("HelloMessageValidator")
public class HelloValidator implements javax.faces.validator.Validator {
    public void validate(FacesContext facesContext,
                         UIComponent uiComponent,
                         Object o) throws ValidatorException {
        String message = o.toString();
        if (message.startsWith("abc")) {
            FacesMessage msg = new FacesMessage(
                    "Hello.message validation failed.",
                    "I don't like starting from 'abc'.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}
