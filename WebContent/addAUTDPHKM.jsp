<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link
	href="http://cdn.datatables.net/plug-ins/a5734b29083/integration/bootstrap/3/dataTables.bootstrap.css"
	rel="stylesheet">
<link
	href="http://cdn.datatables.net/responsive/1.0.1/css/dataTables.responsive.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css" />
<link rel="stylesheet" href="css/mystyle.css" />
<style type="text/css">
	#bb::after{
		content: '(*)';
		color: red;
	}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="form-group">
		<html:form action="/addAUTDPHKM" method="post">	
			<div class="header">
				<h5 style="float: left; padding-left: 15px;">AUTA822</h5>
				<h5 style="float: right; padding-right: 15px;">2017/05/11</h5>
				<h5 style="text-align: center; padding-top: 13px;">新ﾃﾞﾎﾟ変換マスター登録</h5>
			</div>
			<div class="error" style="width: 1140px; height:auto; border-style: solid; border-color: #999999; border-width: 1px; padding-top: 10px; padding-bottom: 10px; padding-left: 15px;">
				
				<html:errors property="error" />
				<html:errors property="error1" />
				<html:errors property="error2" />
				<html:errors property="error3" />
				<html:errors property="error4" />
				<html:errors property="error5" />
				<html:errors property="success" />
				
			</div>
			<strong style="color: #FF6600; padding-left: 15px; font-size: 20px;">10件項目を入力できます。</strong>
					<table id="myTable" class="table table-striped" style="border: 1px solid #f3f3f4;">
					<thead>
						<tr><center>
					    	<th></th>
					        <th id="bb">メーカー</th>
					        <th>ＳＳ</th>
					        <th>ＳＳ名</th>
					        <th>搬入場所</th>
					        <th id="bb">出荷デポ</th>
					        <th>出荷デポ名</th>
					        <th>メーカ品番</th>
					        <th>車種</th>
					        </center>
					    </tr>
					</thead>
					<tbody>
						<logic:iterate name="autDPHKMForm" property="number" id="num">
			           	<tr>
			            	<td>
			                	<bean:write name="num"/>
							</td>
			                <td>
			                	<html:select property="dPHKM_KKCD[${num}]" styleClass="form-control" style="border-radius: 3px; height: 30px; width: 170px;">
									<option value="">Please select...</option>
									<html:optionsCollection name="autDPHKMForm" property="combo" label="mFOPM_TRCD" value="mFOPM_TRCD" />
								</html:select>					
			                </td>
			                <td>
			                	<html:text property="dPHKM_SSCD[${num}]" style="width: 50px;"></html:text>
			                </td>
			                <td>
			                	<html:text property="tOKIM_RYAK[${num}]" readonly="true" style="width: 100px;"></html:text>
			                </td>
			                <td>
			                	<html:text property="dPHKM_FORM[${num}]" style="width: 130px;"></html:text>
			                </td>
			                <td>
			                	<html:text styleId="dPHKM_DEPO${num}" property="dPHKM_DEPO[${num}]" style="width: 50px; padding-top: 0px;"></html:text>   
			                	<input type="button" id="${num}" value="参照" class="btn btn-info" style="height: 30px; width: 50px; background-color: #FF6600; border-color: #FF6600; color: #FFF"></a>
			                	<script type="text/javascript">
									$("#${num}").click(function(){
								        // Get value from input element on the page
								        var text = $("#dPHKM_DEPO${num}").val();
								        // Send data to 
									    $.get('/IT2/addAjaxAUTDPHKM.do', {"id": ${num}, "dPHKM_DEPO[${num}]": text},
									    	function(result){
									    	// Display the returned data in browser
								            $("#mFOPM_NAME"+${num}).val(result);
									    });
								   	});
								</script>
			                </td>
			                <td>		          
			                	<html:text styleId="mFOPM_NAME${num}" property="mFOPM_NAME[${num}]" readonly="true" style="width: 150px;"></html:text>
			                </td>
			                <td>
			                	<html:text property="dPHKM_PART[${num}]" style="width: 180px;"></html:text>
			                </td>
			                <td>
			                	<html:text property="dPHKM_SYCD[${num}]" style="width: 50px;"></html:text>
			                </td>
			            </tr>
			            </logic:iterate>			            
					</tbody>
					</table>
			<div style="float: right;">
			<html:submit property="submit" style="padding:6px 35px; background-color: #FF6600; border-color: #FF6600;" styleClass="btn btn-info" value="登録(N)"/>


			<html:submit property="submit" style="padding:6px 30px; background-color: #FF6600; border-color: #FF6600;" styleClass="btn btn-info" value="クリアー(R)"/>


			<html:submit property="submit" style="padding:6px 30px; background-color: #FF6600; border-color: #FF6600;" styleClass="btn btn-info" value="戻る(K) "/>
			</div>
		</html:form>
	</div>
</body>