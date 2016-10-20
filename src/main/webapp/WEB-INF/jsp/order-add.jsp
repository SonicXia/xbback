<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="itemAddForm" class="itemForm" method="post">
	    <table cellpadding="10">
	        
	        <tr>
	            <td>姓名:</td>
	            <td><input class="easyui-textbox" type="text" name="name" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>手机号:</td>
	            <td><input class="easyui-textbox" type="text" name="mobile" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>投单数:</td>
	            <td><input class="easyui-textbox" type="text" name="orderCnt" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>每单金额:</td>
	            <td><input class="easyui-textbox" type="text" name="price" data-options="required:true,precision:2" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>投单总金额:</td>
	            <td><input class="easyui-textbox" type="text" name="amount" data-options="required:true,precision:2" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>投单日期:</td>
	            <td><input class="easyui-textbox" type="text" name="investmentDate" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>收货地址:</td>
	            <td><input class="easyui-textbox" name="address" data-options="multiline:true,validType:'length[0,150]',required:true" style="height:40px;width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>备注:</td>
	            <td><input class="easyui-textbox" name="remark" data-options="multiline:true,validType:'length[0,150]'" style="height:60px;width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>分红月数:</td>
	            <td><input class="easyui-textbox" type="text" name="rewardMonths" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>额外分红天数:</td>
	            <td><input class="easyui-textbox" type="text" name="extraDays" style="width: 280px;"></input></td>
	        </tr>
	        
	    </table>
	    
	    <input type="hidden" value="" name='orderId'>
		<input type="hidden" value="" name='bonus'>
		<input type="hidden" value="" name='reward'>
		<input type="hidden" value="" name='rewardDays'>
		<input type="hidden" value="" name='daysAlready'>
		<input type="hidden" value="" name='createDate'>
		<input type="hidden" value="" name='updateDate'>
		<input type="hidden" value="" name='orderStatus'>
	</form>
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
</div>
<script type="text/javascript">
	
	//提交表单
	function submitForm(){
		//有效性验证
		if(!$('#itemAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		var parm = {};
	     $('#itemAddForm').serializeArray().forEach(function(item,i){
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
	        
	}
	
	function clearForm(){
		$('#itemAddForm').form('reset');
		itemAddEditor.html('');
	}
</script>
