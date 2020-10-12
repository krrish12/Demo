<%@ include file="common/header.jspf" %>
	<div class="container" height"100%" overflow="auto">
		<table class="table table-striped" height"150">
			<thead>
				<tr>
					<th>Currency</th>
					<th>Today</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty exRates}">
						<c:forEach items="${exRates}" var="entry">
							<tr>
				 				 <td>${entry.key}</td>
				 				 <td>${entry.value}</td>
				 		 	</tr>
				 		</c:forEach>
				 	</c:when>
				 	<c:otherwise>
				 	</c:otherwise>	
			 	</c:choose>
			</tbody>
		</table>
	</div>