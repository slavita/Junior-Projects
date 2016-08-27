package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;

/** Создаёт управляемый бин с именем, указанным в
 *  аттрибуте name. Если имя бина не указано,
 *  то по умолчанию ему будет присвоено имя класса */
@ManagedBean
/** Бин живёт до тех пор, пока существует HTTP
 *  запрос-ответ. Он создаётся во время выполнения
 *  HTTP – запроса и уничтожается, когда HTTP – ответ,
 *  ассоциированный с данным запросом завершается. */
@RequestScoped
public class Hello implements Serializable {
    private String message = "default";
    private String message2;
    private int count;
    private IntegerPair pair;


    public Hello() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage2() {
        return message2;
    }

    public void setMessage2(String message2) {
        this.message2 = message2;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public IntegerPair getPair() {
        return pair;
    }

    public void setPair(IntegerPair pair) {
        this.pair = pair;
    }


}
