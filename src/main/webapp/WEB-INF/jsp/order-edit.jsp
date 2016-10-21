<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
	<form id="orderEditForm" class="orderForm" method="post">
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
	            <td><input class="easyui-textbox" type="text" name="ordercnt" data-options="required:true" style="width: 280px;"></input></td>
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
	            <td><input class="easyui-textbox" type="text" name="investmentdate" data-options="required:true" style="width: 280px;"></input></td>
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
	            <td><input class="easyui-textbox" type="text" name="rewardmonths" data-options="required:true" style="width: 280px;"></input></td>
	        </tr>
	        <tr>
	            <td>额外分红天数:</td>
	            <td><input class="easyui-textbox" type="text" name="extradays" style="width: 280px;"></input></td>
	        </tr>
	        
	    </table>
	    
	    <input type="hidden" name='orderid'>
		<input type="hidden" name='bonus'>
		<input type="hidden" name='reward'>
		<input type="hidden" name='rewarddays'>
		<input type="hidden" name='daysalready'>
		<input type="hidden" name='createdate'>
		<input type="hidden" name='updatedate'>
		<input type="hidden" name='orderstatus'>
		
	</form>
	
	
	<div style="padding:5px">
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
	    <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
	</div>
</div>


<script type="text/javascript">

	/* var itemEditEditor ;
	$(function(){
		//实例化编辑器
		itemEditEditor = TAOTAO.createEditor("#itemeEditForm [name=desc]");
	}); */
	
	function submitForm(){
		if(!$('#orderEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		
		/* $("#itemeEditForm [name=price]").val(eval($("#itemeEditForm [name=priceView]").val()) * 1000);
		itemEditEditor.sync(); */
		
		/* var paramJson = [];
		$("#itemeEditForm .params li").each(function(i,e){
			var trs = $(e).find("tr");
			var group = trs.eq(0).text();
			var ps = [];
			for(var i = 1;i<trs.length;i++){
				var tr = trs.eq(i);
				ps.push({
					"k" : $.trim(tr.find("td").eq(0).find("span").text()),
					"v" : $.trim(tr.find("input").val())
				});
			}
			paramJson.push({
				"group" : group,
				"params": ps
			});
		}); 
		paramJson = JSON.stringify(paramJson);
		
		$("#itemeEditForm [name=itemParams]").val(paramJson); */
		
		/* $.post("/order/update",$("#orderEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改商品成功!','info',function(){
					$("#orderEditWindow").window('close');
					$("#orderList").datagrid("reload");
				});
			}
		}); */
		var parm = {};
	     $('#orderEditForm').serializeArray().forEach(function(item,i){
	      parm[item.name] = item.value;
	     })
	     console.log(parm);
		$.ajax({
            type: 'POST',
            url: '/order/update',
            data: JSON.stringify(parm),
            dataType: 'json',
            contentType: 'application/json', 
            timeout: 30000,
            success: function (data) {
            	if(data.status == 200){
    				$.messager.alert('提示','订单修改成功!');
    			}
            	$('#orderEditForm').form('reset');
            },
            error: function (xhr, type) {
                console.log('Ajax error');
            }
        })
		
	}
	
	function clearForm(){
		$('#orderEditForm').form('reset');
	}
	
</script>
