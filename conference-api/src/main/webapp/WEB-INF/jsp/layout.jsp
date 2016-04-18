<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Conference</title>
	</head>
	<body>
		<tiles:insertAttribute name="header" />
		<div style="width: 500px; margin: auto;">
			<section>
				<tiles:insertAttribute name="body" />
			</section>
		</div>
		<tiles:insertAttribute name="footer" />
	</body>
</html>