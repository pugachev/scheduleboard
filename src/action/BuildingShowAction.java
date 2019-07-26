package action;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.BuildingLogic;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import action.form.ReserveListForm;
import action.util.FormUtil;

public class BuildingShowAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //1)ビル一覧の取り出し
        BuildingLogic logic = new BuildingLogic();
        logic.getAllBuilding(getServlet().getServletContext());

        //2)ReserveListFormの初期化
        Calendar cal = Calendar.getInstance();
        ReserveListForm rForm = FormUtil.getInitForm(cal.getTime(), 1);
        request.setAttribute("ShowReserveListForm", rForm);

        return mapping.findForward("list");
    }

}