package bean;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.faces.validator.ValidatorException;

/** @FacesConverter сообщает приложению что
 * этот класс будет конвертером с именем: IntegerPairConverter */
@FacesConverter("IntegerPairConverter")
public class IntegerPairConverter implements Converter{
    /** @FacesContext содержит всю информацию о состоянии запроса*/
    /** @UIComponent class для всех компонентов пользовательского интерфейса
     *  Набор UIComponent экземпляров, организуются в компонентное дерево */
    public Object getAsObject(FacesContext facesContext,
                              UIComponent uiComponent,
                              String str) {
        try {
            int fst = Integer.parseInt(str.substring(0, str.indexOf(".")));
            int snd = Integer.parseInt(str.substring(str.indexOf(".") + 1, str.length()));
            return new IntegerPair(fst, snd);
        } catch (RuntimeException e) {
            FacesMessage msg = new FacesMessage(
                    "Bad IntegerPair.",
                    "IntegerPair must have format '123.456'.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(msg);
        }
    }

    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        IntegerPair pair = (IntegerPair) o;
        return pair.getFst() + "." + pair.getSnd();

    }
}
