<%@ include file="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:actionURL name="/addMove" var="click" />
<portlet:actionURL name="/restartGame" var="restart" />

<div>
	<aui:form action="${click}" method="post">
		<aui:input type="hidden" name="theMove" id="myMove" />
	</aui:form>
	<div style ="display:flex;flex-wrap: wrap;">
	<c:forEach items="${board.getBoard()}" var="element" varStatus="Index">
		<c:choose>
			<c:when test="${Index.index == 3 }">
				</div>
				<div style ="display:flex;flex-wrap: wrap;">
			</c:when>
			<c:when test="${Index.index == 6 }">
			  </div>
				<div style ="display:flex;flex-wrap: wrap;">
			</c:when>
		</c:choose>
		<div style="border-style: solid; height:80px; width:80px; text-align: center; vertical-align: middle;line-height: 80px; font-size: 50px; " 
			onClick='clicked(this)' id="${Index.index}">${element}
			</div>
		
	</c:forEach>
	</div>
	<script> var clicked = (e) => { 
		document.getElementById("<portlet:namespace />myMove").value = e.id;
		document.getElementById("<portlet:namespace />fm").submit();
		}
	</script>
	<div>
	<%
		String winner= (String) renderRequest.getAttribute("winner");
		if( winner != null){
			out.write(winner+  " Wins");
		}
	%>
	</div>
	<a href="${restart}"> RESTART </a>
	



</div>