package action;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.ReserveLogic;
import model.Reservation;
import model.Room;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.LookupDispatchAction;

import action.form.ReserveDetailForm;
import action.form.ReserveListForm;
import action.util.FormUtil;

public class EntryReserveAction extends LookupDispatchAction {

    protected Map getKeyMethodMap() {
        Map<String,String> map = new HashMap<String,String>();
        map.put("action.update", "update");
        map.put("action.delete", "delete");
        map.put("action.entry", "entry");
        return map;
    }

    public ActionForward update(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //updateボタンが押された場合の処理

        ReserveDetailForm eForm = (ReserveDetailForm) form;

        //1)FormからReservationを作成
        Reservation r = toReserved(eForm);

        //2)開始時間と終了時間のチェック
        if (!checkEntry(r)) {
            return checkErrorForward(request, mapping);
        }

        ReserveLogic logic = new ReserveLogic();

        //予約の更新
        logic.updateReserve(r);

        //次画面へ引継ぎ
        ReserveListForm rForm = FormUtil.getInitForm(getDate(eForm), eForm.getBuilding());
        request.setAttribute("ReserverdForm", rForm);

        return mapping.findForward("rList");
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //deleteボタンが押された場合の処理

        ReserveDetailForm eForm = (ReserveDetailForm) form;
        int reserveId = eForm.getReserveId();

        //予約の削除
        ReserveLogic logic = new ReserveLogic();
        logic.deleteReserve(reserveId);

        //次画面へ引継ぎ
        ReserveListForm rForm = FormUtil.getInitForm(getDate(eForm), eForm.getBuilding());
        request.setAttribute("ReserverdForm", rForm);
        
        return mapping.findForward("rList");
    }

    public ActionForward entry(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //entryボタンが押された場合の処理

        ReserveDetailForm eForm = (ReserveDetailForm) form;
        Reservation r = toReserved(eForm);

        if (!checkEntry(r)) {
            return checkErrorForward(request, mapping);
        }

        //予約の登録
        ReserveLogic logic = new ReserveLogic();
        logic.entryReserve(r);

        //次画面へ引継ぎ
        ReserveListForm rForm = FormUtil.getInitForm(getDate(eForm), eForm.getBuilding());
        request.setAttribute("ReserverdForm", rForm);

        return mapping.findForward("rList");
    }

    private ActionForward checkErrorForward(HttpServletRequest request,
            ActionMapping mapping) {

        //エラーメッセージの登録
        ActionMessages errors = new ActionMessages();
        errors.add("start", new ActionMessage("error.startbig"));
        saveErrors(request, errors);

        return mapping.findForward("error");
    }

    private boolean checkEntry(Reservation r) {
        //開始時間は終了時間よりも早いこと
        if (r.getStart() >= r.getEnd()) {
            return false;
        }
        return true;
    }

    private Reservation toReserved(ReserveDetailForm eForm) {

        //ReserveDetailFormの値をReservationに変換する
        Reservation r = new Reservation();

        r.setReserveId(eForm.getReserveId());
        r.setPerson(eForm.getPerson());
        r.setDate(getDate(eForm));

        //3)ダミーの部屋インスタンスを作成
        Room room = new Room();
        room.setRoomId(eForm.getRoomId());
        r.setRoom(room);

        r.setStart(eForm.getStartRange());
        r.setEnd(eForm.getEndRange());
        r.setContent(eForm.getContent());

        return r;
    }
    
    private Date getDate(ReserveDetailForm eForm) {
        //Dateに変換する箇所は複数箇所あるので共通化
        Calendar cal = Calendar.getInstance();
        int year = eForm.getYear();
        int month = eForm.getMonth();
        int day = eForm.getDay();
        cal.set(year, month - 1, day);
        Date date = cal.getTime();

        return date;
    }

}