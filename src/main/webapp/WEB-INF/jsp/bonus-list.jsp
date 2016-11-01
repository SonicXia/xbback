<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="bonusList" title="奖励列表" iconCls="icon-save" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/money/moneyList',method:'get',pageSize:10,toolbar:toolbar">
    <thead>
        <tr>
        	<!-- 搜索栏 -->
        	<!-- id名称要与其他tab页的搜索栏id避免冲突，不然会造成搜索结果相互干扰的情况 -->
        	<div id="tb" style="padding:3px">
				<span>姓名：</span>
				<input id="bonus_name" style="line-height:20px;border:1px solid #ccc">
				<span>手机号：</span>
				<input id="bonus_mobile" style="line-height:20px;border:1px solid #ccc">
				<span>日期：</span>
				<input id="bonus_releasedate" class="easyui-datebox">
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" plain="true" onclick="doSearch()">查询</a>
			</div>
        	<th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'name',width:60">姓名</th>
            <th data-options="field:'mobile',width:80">手机号</th>
            <th data-options="field:'bonus',width:60,align:'right'">奖励金额</th>
            <th data-options="field:'releasedate',width:75">发放日期</th>
            <th data-options="field:'isbonusrelease',width:70,align:'right',formatter:TAOTAO.formatIsReleased">是否已发放</th>           
        </tr>
    </thead>
</table>


<script>
	/* 搜索栏事件 */
	function doSearch(){
		$('#bonusList').datagrid('load',{
			name: $('#bonus_name').val(),
			mobile: $('#bonus_mobile').val(),
			releasedate: $('#bonus_releasedate').datebox('getValue')
		});
	}

    function getSelectionsMobiles(){
    	var bonusList = $("#bonusList");
    	var sels = bonusList.datagrid("getSelections");
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
                	$.post("/money/distributeBonus",params, function(data){
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