<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="rewardList" title="分红列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/reward/rewardOrderList',method:'get',pageSize:10,toolbar:toolbar">
    <thead>
        <tr>
        	
        	
        	<th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'name',width:60">姓名</th>
            <th data-options="field:'mobile',width:80">手机号</th>
            <th data-options="field:'reward',width:80,align:'right'">今日分红金额</th>
            <th data-options="field:'releasedate',width:75">发放日期</th>
            <th data-options="field:'isrelease',width:70,align:'right',formatter:TAOTAO.formatIsReleased">是否已发放</th>           
        </tr>
    </thead>
</table>


<script>

    function getSelectionsIds(){
    	var rewardList = $("#rewardList");
    	var sels = rewardList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].name);	//sels[i].orderid要对应订单编号的field值
    	}
    	ids = ids.join(",");
    	return ids;
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
                	$.post("/reward/distribute",params, function(data){
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