<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
  /**
  * @Class Name : sqlHelper.jsp
  * @Description : Sql Helper 화면
  * @Modification Information
  *
  *   수정일         수정자                   수정내용
  *  -------    --------    ---------------------------
  *  2018.12.09            최초 생성
  *
  */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sql Helper</title>
</head>
<body>
	<h2>SQL Helper</h2>
	<span>DB 정보</span>
	
	<p>user</p> <input type="text" id="txtUser" name="txtUser" value=""  size="50" />
	<p>password</p> <input type="text" id="txtPwd" name="txtPwd" value=""  size="50" />
	<p>url</p> <input type="text" id="txtUrl" name="txtUrl" value="jdbc:oracle:thin:@localhost:1521:orcl"  size="50" />
	<button id="btnConnection">Connection</button>
	<ul id="ulTableList">
		<li id="liTableList"></li>
	</ul>
</body>
<script type="text/javaScript" language="javascript">
var _page = null;
$(document).ready(function(){
	_page = new fn_page();
	_page.initialize();
});
function fn_page(){
	this.initialize = function(){
		this.initializeEvents();
	};
	
	this.initializeEvents = function(){
		
		
		// Db Connection
		$("#btnConnection").on('click', function() {
			_page.dbConnection();
		});
	};
	
	this.dbConnection = function(){
		
		var user = $("#txtUser").val();
		var pwd = $("#txtPwd").val();
		var url = $("#txtUrl").val();
		
	    $.ajax({

	        type : 'GET',
	        url : "/sqlHelper.do",
	        data : {
	        	USER : user, 
	        	PWD : pwd,
	        	URL : url
	        },
	        success : function (data) {
	                     
	        }


	    });

	};
	
}
	
</script>
</html>

