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
import com.hcss.bean.BankTO;
import com.hcss.bean.EducationTO;
import com.hcss.delegate.UserPersonalDelegate;
import com.hcss.utill.UtilConstants;

/**
 * MyEclipse Struts Creation date: 09-05-2012
 * 
 * XDoclet definition:
 * 
 * @struts.action path="/viewUpdateBankAction" name="BankTO" scope="request"
 *                validate="true"
 * @struts.action-forward name="failure" path="/Status.jsp"
 * @struts.action-forward name="success" path="/UpdateBankDetails.jsp"
 */
public class ViewUpdateBankAction extends Action {
	/*
	 * Generated Methods
	 */

	/**
	 * Method execute
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		int bankid = Integer.parseInt(request.getParameter("bankid"));
			BankTO bankTO = null;
		try {
			bankTO = new UserPersonalDelegate().updateViewBankDetails(bankid);
			if (bankTO != null) {
				request.setAttribute("bankTO", bankTO);
				request
						.setAttribute("status",
								UtilConstants._VIEW_BANK_DETAILS);
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