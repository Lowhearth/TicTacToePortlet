package com.tictactoe;

import com.ticktacktoe.constants.TicTacToePortletKeys;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author me
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TicTacToePortletKeys.TicTacToe,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TicTacToePortlet extends MVCPortlet {
	
	
	
	
	
	public void doView(RenderRequest renderRequest,
            RenderResponse renderResponse)
     throws IOException,
            PortletException{
			Board board = (Board) renderRequest.getPortletSession().getAttribute("board");
			if(board == null) {
				Board newBoard = new Board();
				renderRequest.getPortletSession().setAttribute("board", newBoard);
				renderRequest.setAttribute("board", newBoard);
			}
			else {
				renderRequest.setAttribute("board", board);
			}
			
			System.out.println("doview");
			include("/view.jsp", renderRequest, renderResponse);
		
	}

	
	
}