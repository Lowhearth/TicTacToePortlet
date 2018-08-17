package com.tictactoe;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.ticktacktoe.constants.TicTacToePortletKeys;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + TicTacToePortletKeys.TicTacToe,
	        "mvc.command.name=/restartGame"
	    },
	    service = MVCActionCommand.class
	)
	public class restartGame extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		
		
		actionRequest.getPortletSession().removeAttribute("board");
		actionRequest.getPortletSession().removeAttribute("winner");
		
		
	}
	
}
