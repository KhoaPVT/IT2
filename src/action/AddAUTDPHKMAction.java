package action;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.ValidateData;
import form.AUTDPHKMForm;
import model.bean.AUTDPHKM;
import model.bean.AUTMFOPM;
import model.bo.AUTDPHKMBO;


public class AddAUTDPHKMAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		AUTDPHKMForm autDPHKMForm = (AUTDPHKMForm) form;
		AUTDPHKMBO autDPHKMBO = new AUTDPHKMBO();
		ActionErrors actionErrors = new ActionErrors();
		ArrayList<AUTMFOPM> combo = autDPHKMBO.getCombo();
		autDPHKMForm.setCombo(combo);
		int submit = 0;
		if (autDPHKMForm.getSubmit() == null) {
			submit = 0;
		} else {
			submit = autDPHKMForm.getSubmit().getBytes("UTF-8").length;
		}
		//validate du lieu
		if (submit == 9) {	
			ArrayList<Integer> empty1 = new ArrayList<Integer>();
			ArrayList<Integer> empty2 = new ArrayList<Integer>();
			int d1 = 0;
			int d2 = 0;
			int d3 = 0;
			int d4 = 0;
			int d5 = 0;
			int d = 0;
			for (int i=0;i<10;i++) {
				if (ValidateData.isEmptyString(autDPHKMForm.getdPHKM_KKCD(i)) && (!ValidateData.isEmptyString(autDPHKMForm.getdPHKM_SSCD(i)) 
						|| !ValidateData.isEmptyString(autDPHKMForm.getdPHKM_FORM(i)) || !ValidateData.isEmptyString(autDPHKMForm.getdPHKM_DEPO(i))
						|| !ValidateData.isEmptyString(autDPHKMForm.getdPHKM_PART(i)) || !ValidateData.isEmptyString(autDPHKMForm.getdPHKM_SYCD(i)))) {
					empty1.add(i);
					d1++;
				}
				if (ValidateData.isEmptyString(autDPHKMForm.getdPHKM_DEPO(i)) && (!ValidateData.isEmptyString(autDPHKMForm.getdPHKM_SSCD(i)) 
						|| !ValidateData.isEmptyString(autDPHKMForm.getdPHKM_FORM(i)) || !ValidateData.isEmptyString(autDPHKMForm.getdPHKM_KKCD(i))
						|| !ValidateData.isEmptyString(autDPHKMForm.getdPHKM_PART(i)) || !ValidateData.isEmptyString(autDPHKMForm.getdPHKM_SYCD(i)))) {
					empty2.add(i);
					d2++;
				}
				if (ValidateData.isEmptyString(autDPHKMForm.getdPHKM_KKCD(i)) && ValidateData.isEmptyString(autDPHKMForm.getdPHKM_DEPO(i))) {
					d++;
				}
				if (!ValidateData.isEmptyString(autDPHKMForm.getdPHKM_DEPO(i)) && (!autDPHKMBO.isDPHKM_DEPO_exist(autDPHKMForm.getdPHKM_DEPO(i)))) {
					d3++;
				}
				if (!ValidateData.isEmptyString(autDPHKMForm.getdPHKM_PART(i)) && (!autDPHKMBO.isDPHKM_PART_exist(autDPHKMForm.getdPHKM_PART(i)))) {
					d4++;
				}
				if ((!ValidateData.isEmptyString(autDPHKMForm.getdPHKM_KKCD(i)) && !ValidateData.isEmptyString(autDPHKMForm.getdPHKM_DEPO(i))&&(autDPHKMForm.getdPHKM_SSCD(i)!=null||autDPHKMForm.getdPHKM_FORM(i)!=null||autDPHKMForm.getdPHKM_PART(i)!=null||autDPHKMForm.getdPHKM_SYCD(i)!=null)) 
						&& (autDPHKMBO.isAUTDPHKM_exist(autDPHKMForm.getdPHKM_KKCD(i), autDPHKMForm.getdPHKM_SSCD(i), autDPHKMForm.getdPHKM_FORM(i), autDPHKMForm.getdPHKM_DEPO(i), autDPHKMForm.getdPHKM_PART(i), autDPHKMForm.getdPHKM_SYCD(i)))) {
					d5++;
				}
			}
			
			if (d > 0) {
				actionErrors.add("error", new ActionMessage("error.batBuoc.trong"));
			}
			if(d1 > 0){
				String vt1 = Arrays.toString(empty1.toArray()); 
				actionErrors.add("error1", new ActionMessage("error.dPHKM_KKCD.trong"));
			}
			if(d2 > 0){
				String vt2 = Arrays.toString(empty2.toArray()); 
				actionErrors.add("error2", new ActionMessage("error.dPHKM_DEPO.trong"));
			}
			if(d3 > 0){
				actionErrors.add("error3", new ActionMessage("error.dPHKM_DEPO.notexist"));
			}
			if(d4 > 0){
				actionErrors.add("error4", new ActionMessage("error.dPHKM_PART.notexist"));
			}
			if(d5 > 0){
				actionErrors.add("error5", new ActionMessage("error.autDPHKM.exist"));
			}
			saveErrors(request, actionErrors);
			if(actionErrors.size()>0){
				//chuyen ve trang Add AUTDPHKM va hien thi loi
				return mapping.findForward("error");
			}
			
		}
		
		if (submit == 15) {
			for (int i=0;i<11;i++) {
				autDPHKMForm.setdPHKM_KKCD(i, "");
				autDPHKMForm.setdPHKM_SSCD(i, "");
				autDPHKMForm.settOKIM_RYAK(i, "");
				autDPHKMForm.setdPHKM_FORM(i, "");
				autDPHKMForm.setdPHKM_DEPO(i, "");
				autDPHKMForm.setdPHKM_PART(i, "");
				autDPHKMForm.setdPHKM_SYCD(i, "");
				autDPHKMForm.setmFOPM_NAME(i, "");
			}
		}
		
		if (submit == 10) {
			return mapping.findForward("cancel");
		}
		
		if (submit == 9) {
			String dPHKM_KKCD;
			String dPHKM_SSCD;
			String dPHKM_FORM;
			String dPHKM_DEPO;
			String dPHKM_PART;
			String dPHKM_SYCD;
			int add = 0;
			for (int i=1;i<11;i++) {
				dPHKM_KKCD = autDPHKMForm.getdPHKM_KKCD(i);
				dPHKM_SSCD = autDPHKMForm.getdPHKM_SSCD(i);
				dPHKM_FORM = autDPHKMForm.getdPHKM_FORM(i);
				dPHKM_DEPO = autDPHKMForm.getdPHKM_DEPO(i);
				dPHKM_PART = autDPHKMForm.getdPHKM_PART(i);
				dPHKM_SYCD = autDPHKMForm.getdPHKM_SYCD(i);
				
				AUTDPHKM autDPHKM = new AUTDPHKM(dPHKM_KKCD, dPHKM_SSCD, dPHKM_FORM, dPHKM_DEPO, dPHKM_PART, dPHKM_SYCD);
				///autDPHKMBO.addAUTDPHKM(autDPHKM);
				if (autDPHKMBO.addAUTDPHKM(autDPHKM)) {
					add++;
				}
			}
			if(add > 0){
				actionErrors.add("success", new ActionMessage("success.autDPHKM.addNew"));
				saveErrors(request, actionErrors);
				for (int i=0;i<11;i++) {
					autDPHKMForm.setdPHKM_KKCD(i, "");
					autDPHKMForm.setdPHKM_SSCD(i, "");
					autDPHKMForm.settOKIM_RYAK(i, "");
					autDPHKMForm.setdPHKM_FORM(i, "");
					autDPHKMForm.setdPHKM_DEPO(i, "");
					autDPHKMForm.setdPHKM_PART(i, "");
					autDPHKMForm.setdPHKM_SYCD(i, "");
					autDPHKMForm.setmFOPM_NAME(i, "");
				}
			}
			return mapping.findForward("addSuccess");
		} else return mapping.findForward("addAUTDPHKM");
	}
}
