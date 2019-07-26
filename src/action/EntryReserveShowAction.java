package action;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.ReserveLogic;
import model.Reservation;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import action.form.ReserveDetailForm;

public class EntryReserveShowAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ReserveDetailForm eForm = (ReserveDetailForm) form;

		//1)更新・削除の場合
		if (eForm.getStatus() == 1) {
			int rId = eForm.getReserveId();

			ReserveLogic logic = new ReserveLogic();
			Reservation r = logic.findReserve(rId);

			//ReserveDetailFormに値を設定する
			eForm.setContent(r.getContent());
			eForm.setPerson(r.getPerson());
			eForm.setRoomId(r.getRoom().getRoomId());

			eForm.setStartRange(r.getStart());
			eForm.setEndRange(r.getEnd());

			Calendar cal = Calendar.getInstance();
			cal.setTime(r.getDate());
			eForm.setYear(cal.get(Calendar.YEAR));
			eForm.setMonth(cal.get(Calendar.MONTH) + 1);
			eForm.setDay(cal.get(Calendar.DATE));
		}

		return mapping.findForward("entry");
	}
}