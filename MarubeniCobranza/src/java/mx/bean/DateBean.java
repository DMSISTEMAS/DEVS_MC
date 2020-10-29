package mx.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class DateBean
        implements Serializable {

    private final Date currentDate = new Date();
    Calendar fecha = Calendar.getInstance();
    int año = this.fecha.get(1);
    int mes = this.fecha.get(2);
    private final String range = "2019:2026";

    public Date getCurrentDate() {
        return this.currentDate;
    }

    public String getRange() {
        return "2019:2026";
    }

    public int getMes() {
        return this.mes;
    }
}
