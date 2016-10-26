<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="bonusList" title="奖励列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/reward/rewardOrderList',method:'get',pageSize:10,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'name',width:60">姓名</th>
            <th data-options="field:'mobile',width:80">手机号</th>
            <th data-options="field:'bonus',width:60,align:'right'">今日奖励</th>
            <th data-options="field:'releasedate',width:75">发放日期</th>
            <th data-options="field:'isbonusrelease',width:70,align:'right',formatter:TAOTAO.formatIsReleased">是否已发放</th>           
        </tr>
    </thead>
</table>


<script>

    function getSelectionsMobiles(){
    	var userList = $("#bonusList");
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
        	var mobiles = getSelectionsMobiles('#bonusList');
        	if(mobiles.length == 0){
        		$.messager.alert('提示','未选中奖励条目!');
        		return ;
        	}
        	$.messager.confirm('确认','确定发放手机号为 '+mobiles+' 的奖励吗？',function(r){
        	    if (r){
        	    	var params = {"mobiles":mobiles};
                	$.post("/reward/distributeBonus",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','发放奖励成功!',undefined,function(){
            					$("#bonusList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>