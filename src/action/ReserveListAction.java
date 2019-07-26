package action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.BuildingLogic;
import logic.RangeLogic;
import logic.ReserveLogic;
import model.Building;
import model.Range;
import model.Reservation;
import model.Room;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import action.form.ReserveListForm;
import action.viewhelper.RoomReservedInfo;

public class ReserveListAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ReserveListForm rForm = (ReserveListForm) form;

        //表示するビル番号
        int bId = rForm.getBuilding();

        //表示する日付
        Calendar cal = Calendar.getInstance();
        cal.set(rForm.getYear(), rForm.getMonth() - 1, rForm.getDay());

        //1)表示領域の取得
        RangeLogic rLogic = new RangeLogic();
        Range[] rInfo = rLogic.getAllRanges(getServlet().getServletContext());

        //部屋の一覧を取得
        BuildingLogic bLogic = new BuildingLogic();
        Building[] bds = bLogic
                .getAllBuilding(getServlet().getServletContext());
        Room[] rooms = getRooms(bds, bId);

        //予約を検索する
        ReserveLogic logic = new ReserveLogic();
        List<RoomReservedInfo> rList = new ArrayList<RoomReservedInfo>();

        //2)部屋の数だけ、RoomReservedInfoを作成する
        for (int i = 0; i < rooms.length; i++) {
            Reservation[] reserveds = logic.findReserves(rooms[i], cal
                    .getTime());
            RoomReservedInfo info = new RoomReservedInfo(rooms[i], cal
                    .getTime(), rInfo.length);
            info.setReservedList(reserveds);
            rList.add(info);
        }

        request.setAttribute("roomReserveList", rList);

        return mapping.findForward("list");
    }

    private Room[] getRooms(Building[] bdgs, int bdgId) {

        for (int i = 0; i < bdgs.length; i++) {
            if (bdgs[i].getId() == bdgId) {
                return bdgs[i].getAllRooms();
            }
        }

        return null;
    }

}