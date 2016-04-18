<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<c:forEach var="speaker" items="${speakers}">
	<article>
		<img src="<c:url value="${speaker.getPhotoUrl()}" ></c:url>" style="width: 100px; height: 100px;"/>
		<div class="content">
			<h3><c:out value="${speaker.getName()}" ></c:out></h3>
			<h4><c:out value="${speaker.getTitle()}"></c:out></h4>
		</div>
	</article>
</c:forEach>