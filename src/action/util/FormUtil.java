
package action.util;

import java.util.Calendar;
import java.util.Date;

import action.form.ReserveListForm;

public class FormUtil {
    
    public static ReserveListForm getInitForm(Date date,int building){
        //ReserveListFormの初期化をおこなう
        Calendar cal = Calendar.getInstance();
        
        cal.setTime(date);
        
        ReserveListForm rForm = new ReserveListForm();
        rForm.setYear(cal.get(Calendar.YEAR));
        rForm.setMonth(cal.get(Calendar.MONTH)+1);
        rForm.setDay(cal.get(Calendar.DATE));
        rForm.setBuilding(building);
        
        return rForm;
    }
    
}
