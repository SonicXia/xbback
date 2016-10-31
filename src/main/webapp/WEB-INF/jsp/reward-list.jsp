<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="rewardList" title="分红列表" iconCls="icon-save" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/reward/rewardOrderList',method:'get',pageSize:10,toolbar:toolbar">
    <thead>
        <tr>
        	<div id="tb" style="padding:3px">
				<span>姓名：</span>
				<input id="name" style="line-height:26px;border:1px solid #ccc">
				<!-- <span>手机号：</span>
				<input id="mobile" style="line-height:26px;border:1px solid #ccc"> -->
				<a href="#" class="easyui-linkbutton" plain="true" onclick="doSearch()">查询</a>
			</div>
        	
        	<th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'name',width:60">姓名</th>
            <th data-options="field:'mobile',width:80">手机号</th>
            <th data-options="field:'reward',width:60,align:'right'">今日分红</th>
            <th data-options="field:'releasedate',width:75">发放日期</th>
            <th data-options="field:'isrewardrelease',width:70,align:'right',formatter:TAOTAO.formatIsReleased">是否已发放</th>           
        </tr>
    </thead>
</table>


<script>
    
	function doSearch(){
		$('#rewardList').datagrid('load',{
			name: $('#name').val(),
			mobile: $('#mobile').val()
		});
	}
    
    function getSelectionsMobiles(){
    	var userList = $("#rewardList");
    	var sels = userList.datagrid("getSelections");
    	var mobiles = [];
    	for(var i in sels){
    		mobiles.push(sels[i].mobile);	//sels[i].mobile要对应订单编号的field值
    	}
    	mobiles = mobiles.join(",");
    	return mobiles;
    }
    
    var toolbar = [{
        text:'完成',
        iconCls:'icon-ok',
        handler:function(){
        	var mobiles = getSelectionsMobiles('#rewardList');
        	if(mobiles.length == 0){
        		$.messager.alert('提示','未选中分红条目!');
        		return ;
        	}
        	$.messager.confirm('确认','确定发放手机号为 '+mobiles+' 的分红吗？',function(r){
        	    if (r){
        	    	var params = {"mobiles":mobiles};
                	$.post("/reward/distributeReward",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','发放分红成功!',undefined,function(){
            					$("#rewardList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>