/*
 * Generated by MyEclipse Struts
 * Template path: templates/java/JavaClass.vtl
 */
package com.hcss.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.hcss.bean.DrugsTo;
import com.hcss.delegate.UserPersonalDelegate;
import com.hcss.utill.UtilConstants;


public class ViewUpdateDrugAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		int bankid = Integer.parseInt(request.getParameter("did"));
		DrugsTo drugsTO = null;
		try {
			drugsTO = new UserPersonalDelegate().updateViewDrugDetails(bankid);
			if (drugsTO != null) {
				request.setAttribute("drugsTO", drugsTO);
				request
						.setAttribute("status",
								UtilConstants._VIEW_DRUG_DETAILS);
				return mapping.findForward("success");
			} else {
				request.setAttribute("status",
						UtilConstants._VIEW_BANK_DETAILS_FAIL);
				return mapping.findForward("failure");
			}
		} catch (Exception ce) {
			request.setAttribute("status", ce.getMessage());
			return mapping.findForward("failure");
		}
	}
}