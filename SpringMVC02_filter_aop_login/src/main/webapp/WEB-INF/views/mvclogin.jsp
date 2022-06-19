<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#loginChk").hide();
	});
	
	function login(){
		let memberid = $("#memberid").val().trim();
		let memberpw = $("#memberpw").val().trim();
		
		/* name, value */
		/* JSON데이터 */
		let loginVal = {
			"memberid" : memberid,
			"memberpw" : memberpw
		};
		
		if(memberid==null || memberid=="" || memberpw==null || memberpw==""){
			alert("ID 및 PW를 확인해 주세요");
		}else{
			$.ajax({
				url:"ajaxlogin.do",
				type:"post",
				data:JSON.stringify(loginVal),
				dataType: "json", //서버에서 반환되는 데이터 형식
				contentType:"application/json",
				success:function(msg){
					if(msg.check == true){
						location.href='list.do';
					}else{
						$("#loginChk").show();
						$("#loginChk").html("ID 혹은 PW가 잘못되었습니다.");
					}
				},
				error:function(){
					alert("통신실패");
				}
			});
		}
		
		
	}
	
</script>
<body>
<!-- form이 없엇 script로 처리한다 -->
	<table>
		<tr>
			<th>ID</th>
			<td><input type="text" id="memberid"></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="password" id="memberpw">
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="login" onclick="login();"></td>
		</tr>
		<tr>
			<td colspan="2" align="center" id="loginChk"></td>
		</tr>
	</table>
</body>
</html>