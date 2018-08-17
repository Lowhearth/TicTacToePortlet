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
	        "mvc.command.name=/addMove"
	    },
	    service = MVCActionCommand.class
	)
	public class addMove extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		// TODO Auto-generated method stub
		String i = (String) actionRequest.getParameter("theMove");
		if(i !=null) {
			int index = Integer.parseInt(i);
			Board board = (Board) actionRequest.getPortletSession().getAttribute("board");
			board.setSquare(index, board.turn);
			System.out.println("setting moveent");
			if(board.winner != "Z") {
				System.out.println("winner found" + board.winner);
				actionRequest.setAttribute("board", board);
				actionRequest.setAttribute("winner", board.winner );

			}
			else{
				actionRequest.setAttribute("board", board);
			}
					}
	}
	    // implement your action
	}