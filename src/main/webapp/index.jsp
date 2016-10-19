<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>xiaobao</title>
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="css/taotao.css" />
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/common.js"></script>
</head>
<body class="easyui-layout">
	<div style="padding:10px 10px 10px 10px">
	<form id="orderAddForm" class="orderForm" method="post">
		<input type="hidden" value="" name='orderId'>
		<input type="hidden" value="" name='bonus'>
		<input type="hidden" value="" name='reward'>
		<input type="hidden" value="" name='rewardDays'>
		<input type="hidden" value="" name='daysAlready'>
		<input type="hidden" value="" name='createDate'>
		<input type="hidden" value="" name='updateDate'>
		<input type="hidden" value="" name='orderStatus'>
	    <table cellpadding="5">
	        <tr>
	            <td>身份证号:</td>
	            <td><input class="easyui-textbox" type="text" name="cardId" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>姓名:</td>
	            <td><input class="easyui-textbox" type="text" name="name" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>投单数:</td>
	            <td><input class="easyui-textbox" type="text" name="orderCnt" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>每单金额:</td>
	            <td><input class="easyui-textbox" type="text" name="price" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>投单总金额:</td>
	            <td><input class="easyui-textbox" type="text" name="amount" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>投单日期:</td>
	            <td><input class="easyui-textbox" type="text" name="investmentDate" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>收货地址:</td>
	            <td><input class="easyui-textbox" type="text" name="address" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>备注:</td>
	            <td><input class="easyui-textbox" type="text" name="remark" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>分红月数:</td>
	            <td><input class="easyui-textbox" type="text" name="rewardMonths" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>额外分红天数:</td>
	            <td><input class="easyui-textbox" type="text" name="extraDays" style="width: 280px;"></input></td>
	        </tr>

	    </table>
	    
	    <input type="hidden" name="itemParams"/>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
	
	<script type="text/javascript">
	
	//提交表单
	function submitForm(){
		//有效性验证
		if(!$('#orderAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			
			return ;
		}
		//ajax的post方式提交表单
		//$("#orderAddForm").serialize()将表单序列号为key-value形式的字符串
		/* $.post("/order/save",$("#orderAddForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增订单成功!');
			}
		});
		
		
		$.ajax({
			type:'post',
			url: "/order/save",
			contentType: 'application/json', 
			dataType: 'json',
			success: function(data){
			if(data.status == 200){
				$.messager.alert('提示','新增订单成功!');
			}
	      }}); */
		
	      var parm = {};
	      $('#orderAddForm').serializeArray().forEach(function(item,i){
	    	  parm[item.name] = item.value;
	      })
	      console.log(parm);
		 $.ajax({
	            type: 'POST',
	            url: '/order/save',
	            data: JSON.stringify(parm),
	            dataType: 'json',
	            contentType: 'application/json', 
	            timeout: 30000,
	            success: function (data) {
	            	if(data.status == 200){
	    				$.messager.alert('提示','新增订单成功!');
	    			}
	            },
	            error: function (xhr, type) {
	                console.log('Ajax error');
	            }
	        })

		function clearForm(){
			alert("123");
			$('#orderAddForm').form('reset');
			itemAddEditor.html('');
		}
		
		
	}
	
	</script>
	
</div>
</body>
</html>