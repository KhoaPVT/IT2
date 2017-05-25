package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.AUTDPHKMForm;
import model.bo.AUTDPHKMBO;

public class Ajax extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		AUTDPHKMForm autDPHKMForm = (AUTDPHKMForm) form;
		AUTDPHKMBO autDPHKMBO = new AUTDPHKMBO();
		PrintWriter out = response.getWriter();
		int id = autDPHKMForm.getId();
		String refer = autDPHKMForm.getdPHKM_DEPO(id);
		String result = autDPHKMBO.refer(refer);
		System.out.println(result);
	    out.println(result);
	    out.flush();
	    return null;
	}
}
