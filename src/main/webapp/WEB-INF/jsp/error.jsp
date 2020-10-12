<%@ include file="common/header.jspf"%>
<div class="container">
	<c:choose>
		<c:when test="${not empty error}">
			<script>
			 var message = "${error}";
        alert(message);
			</script>
		
		</c:when>
	</c:choose>
</div>