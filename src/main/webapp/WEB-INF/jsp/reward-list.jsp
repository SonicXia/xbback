<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="rewardList" title="分红列表" iconCls="icon-save" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/money/moneyList',method:'get',pageSize:10,toolbar:toolbar">
    <thead>
        <tr>
        	<!-- 搜索栏 -->
        	<!-- id名称要与其他tab页的搜索栏id避免冲突，不然会造成搜索结果相互干扰的情况 -->
        	<div id="tb" style="padding:3px">
				<span>姓名：</span>
				<input id="reward_name" style="line-height:20px;border:1px solid #ccc">
				<span>手机号：</span>
				<input id="reward_mobile" style="line-height:20px;border:1px solid #ccc">
				<span>日期：</span>
				<input id="reward_releasedate" class="easyui-datebox">
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" plain="true" onclick="doSearch()">查询</a>
			</div>       	
        	<th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'name',width:60">姓名</th>
            <th data-options="field:'mobile',width:80">手机号</th>
            <th data-options="field:'reward',width:60,align:'right'">分红金额</th>
            <th data-options="field:'releasedate',width:75">发放日期</th>
            <th data-options="field:'isrewardrelease',width:70,align:'right',formatter:TAOTAO.formatIsReleased">是否已发放</th>           
        </tr>
    </thead>
</table>


<script>
  	/* 搜索栏事件 */
	function doSearch(){
		$('#rewardList').datagrid('load',{
			name: $('#reward_name').val(),
			mobile: $('#reward_mobile').val(),
			releasedate: $('#reward_releasedate').datebox('getValue')
		});
	}
    
    function getSelectionsMobiles(){
    	var rewardList = $("#rewardList");
    	var sels = rewardList.datagrid("getSelections");
    	var mobiles = [];
    	for(var i in sels){
    		mobiles.push(sels[i].mobile);	//sels[i].mobile要对应订单编号的field值
    	}
    	mobiles = mobiles.join(",");
    	return mobiles;
    }
    
    function getSelectionsRewards(){
    	var rewardList = $("#rewardList");
    	var sels = rewardList.datagrid("getSelections");
    	var rewards = [];
    	for(var i in sels){
    		rewards.push(sels[i].reward);	//sels[i].mobile要对应订单编号的field值
    	}
    	rewards = rewards.join(",");
    	return rewards;
    }
    
    var toolbar = [{
        text:'完成',
        iconCls:'icon-ok',
        handler:function(){
        	var mobiles = getSelectionsMobiles('#rewardList');
        	var rewards = getSelectionsRewards('#rewardList');
        	if(mobiles.length == 0){
        		$.messager.alert('提示','未选中分红条目!');
        		return ;
        	}
        	$.messager.confirm('确认','确定发放手机号为 '+mobiles+' 的分红吗？',function(r){
        	    if (r){
        	    	var params = {"mobiles":mobiles,"rewards":rewards};
                	$.post("/money/distributeReward",params, function(data){
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