<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="rewardList" title="订单列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/reward/rewardOrderList',method:'get',pageSize:10,toolbar:toolbar">
    <thead>
        <tr>
        	
        	
        	<th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'name',width:60">姓名</th>
            <th data-options="field:'mobile',width:80">手机号</th>
            <th data-options="field:'todayReward',width:90,align:'right'">今日分红金额</th>
            
            <!-- <th data-options="field:'updatedate',width:120,align:'center',formatter:TAOTAO.formatDateTime">更新时间</th> -->
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
    
    var toolbar = [{
        text:'完成',
        iconCls:'icon-ok',
        handler:function(){
        	var ids = getSelectionsIds('#rewardList');
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中分红条目!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的订单吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/order/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除订单成功!',undefined,function(){
            					$("#rewardList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>