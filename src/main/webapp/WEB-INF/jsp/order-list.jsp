<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="orderList" title="订单列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/order/list',method:'get',pageSize:10,toolbar:toolbar">
    <thead>
        <tr>
        	<!-- 搜索栏 -->
        	<!-- id名称要与其他tab页的搜索栏id避免冲突，不然会造成搜索结果相互干扰的情况 -->
        	<div id="tb" style="padding:3px">
				<span>姓名：</span>
				<input id="order_name" style="line-height:20px;border:1px solid #ccc">
				<span>手机号：</span>
				<input id="order_mobile" style="line-height:20px;border:1px solid #ccc">
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" plain="true" onclick="doSearch()">查询</a>
			</div>    	
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'orderid',width:110">订单编号</th>
            <th data-options="field:'name',width:60">姓名</th>
            <th data-options="field:'mobile',width:80">手机号</th>
            <th data-options="field:'ordercnt',width:45,align:'right'">投单数</th>
            <th data-options="field:'price',width:55,align:'right'">每单金额</th>
            <th data-options="field:'amount',width:70,align:'right'">投单总金额</th>
            <th data-options="field:'investmentdate',width:70">投单日期</th>
            <th data-options="field:'address',width:260">收货地址</th>
            <th data-options="field:'remark',width:115">备注</th>
            <th data-options="field:'rewardmonths',width:55,align:'right'">分红月数</th>
            <th data-options="field:'extradays',width:80,align:'right'">额外分红天数</th>
            <th data-options="field:'rewarddays',width:70,align:'right'">总分红天数</th>
            <th data-options="field:'createdate',width:120,align:'center',formatter:TAOTAO.formatDateTime">创建时间</th>
            <th data-options="field:'updatedate',width:120,align:'center',formatter:TAOTAO.formatDateTime">更新时间</th>
            <th data-options="field:'orderstatus',width:55,align:'center',formatter:TAOTAO.formatItemStatus">订单状态</th>
        </tr>
    </thead>
</table>

<script>

	function doSearch(){
		$('#orderList').datagrid('load',{
			name: $('#order_name').val(),
			mobile: $('#order_mobile').val()
		});
	}

    function getSelectionsIds(){
    	var orderList = $("#orderList");
    	var sels = orderList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].orderid);	//sels[i].orderid要对应订单编号的field值
    	}
    	ids = ids.join(",");
    	return ids;
    }
    
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	$(".tree-title:contains('新增订单')").parent().click();
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个订单才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个订单!');
        		return ;
        	}
        	
        	TT.createWindow({
    			url : "/order-edit",
    			onLoad : function(){
    				var data = $("#orderList").datagrid("getSelections")[0];
    				console.log(data);
    				$("#orderEditForm").form("load",data);
    			}
    		});  
        	
        	
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds('#orderList');
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中订单!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的订单吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/order/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除订单成功!',undefined,function(){
            					$("#orderList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>