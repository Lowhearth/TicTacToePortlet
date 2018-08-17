<%@ include file="/init.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<portlet:actionURL name="/addMove" var="click" />
<portlet:actionURL name="/restartGame" var="restart" />

<div style="text-align: center;">
	<aui:form action="${click}" method="post">
		<aui:input type="hidden" name="theMove" id="myMove" />
	</aui:form>
	<div class="row">
		<c:forEach items="${board.getBoard()}" var="element" varStatus="Index">
			<c:choose>
				<c:when test="${Index.index == 3 }">
	</div>
	<div class="row";">
		</c:when>
		<c:when test="${Index.index == 6 }">
	</div>
	<div class="row">
		</c:when>
		</c:choose>
		<div
			style="border-style: solid; height: 80px; width: 80px; text-align: center; vertical-align: middle; line-height: 80px; font-size: 50px;"
			onClick='clicked(this)' id="${Index.index}" class="square">${element}</div>

		</c:forEach>
	</div>
	<script> var clicked = (e) => { 
		document.getElementById("<portlet:namespace />myMove").value = e.id;
		document.getElementById("<portlet:namespace />fm").submit();
		}
	</script>
	<div>
		<%
			String winner = (String) renderRequest.getAttribute("winner");
			if (winner != null) {
				String[] lineCoordinates = (String[]) renderRequest.getAttribute("lineCoordinates");

				out.write(winner + " Wins");
		%>
		<script> 
			document.getElementById(${lineCoordinates[0]}).className = 'winner';
			document.getElementById(${lineCoordinates[1]}).className = 'winner';
			document.getElementById(${lineCoordinates[2]}).className = 'winner';
			
			</script>
		<%
			}
		%>
	</div>
	<a href="${restart}"> RESTART </a>




</div>


<style type="text/css">
.winner {
	background-color: #D3D3D3;
}

.row {
	display: flex;
	flex-wrap: wrap;
	display: flex;
	justify-content: center;
}
.square:hover{
	background-color: #F8F8F8;
}


</style>