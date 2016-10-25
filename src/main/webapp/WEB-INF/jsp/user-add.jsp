<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="userAddForm" class="userForm" method="post">
	    <table cellpadding="10">
	        
	        <tr>
	            <td>姓名:</td>
	            <td><input class="easyui-textbox" type="text" name="name" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>身份证号:</td>
	            <td><input class="easyui-textbox" type="text" name="cardid" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>手机号:</td>
	            <td><input class="easyui-textbox" type="text" name="mobile" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>推荐人姓名:</td>
	            <td><input class="easyui-textbox" type="text" name="referrer" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>推荐人手机号:</td>
	            <td><input class="easyui-textbox" type="text" name="referrermobile" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>所属团队id:</td>
	            <td><input class="easyui-textbox" type="text" name="teamid" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        
	        
	    </table>
	    
	    <input type="hidden" value="" name='password'>
		<input type="hidden" value="" name='email'>		
		<input type="hidden" value="" name='totalCnt'>
		<input type="hidden" value="" name='isActive'>
		<input type="hidden" value="" name='isBlackList'>
		<input type="hidden" value="" name='referralCnt'>
		<input type="hidden" value="" name='createDate'>
		<input type="hidden" value="" name='updatedate'>
		
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
		if(!$('#userAddForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		var parm = {};
	     $('#userAddForm').serializeArray().forEach(function(item,i){
	      parm[item.name] = item.value;
	     })
	     console.log(parm);
		 $.ajax({
	            type: 'POST',
	            url: '/user/save',
	            data: JSON.stringify(parm),
	            dataType: 'json',
	            contentType: 'application/json', 
	            timeout: 30000,
	            success: function (data) {
	            	if(data.status == 200){
	    				$.messager.alert('提示','新增订单成功!');
	    			}
	            	$('#userAddForm').form('reset');
	        		/* itemAddEditor.html(''); */
	            },
	            error: function (xhr, type) {
	                console.log('Ajax error');
	            }
	        })
	        
	}
	
	function clearForm(){
		$('#userAddForm').form('reset');
		itemAddEditor.html('');
	}
</script>
