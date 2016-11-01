<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="userList" title="代理列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/user/list',method:'get',pageSize:10,toolbar:toolbar">
    <thead>
        <tr>
        	<!-- 搜索栏 -->
        	<!-- id名称要与其他tab页的搜索栏id避免冲突，不然会造成搜索结果相互干扰的情况 -->
        	<div id="tb" style="padding:3px">
				<span>姓名：</span>
				<input id="user_name" style="line-height:20px;border:1px solid #ccc">
				<span>手机号：</span>
				<input id="user_mobile" style="line-height:20px;border:1px solid #ccc">
				<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" plain="true" onclick="doSearch()">查询</a>
			</div>    	
        	<th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'name',width:60">姓名</th>
            <th data-options="field:'mobile',width:80">手机号</th>
            <th data-options="field:'cardid',width:120">身份证号</th>
            <th data-options="field:'totalcnt',width:60,align:'right'">总投单数</th>
            <th data-options="field:'referralcnt',width:70,align:'right'">已推荐人数</th>
            <th data-options="field:'referrer',width:80,align:'right'">推荐人姓名</th>
            <th data-options="field:'referrermobile',width:80">推荐人手机号</th>
            <th data-options="field:'teamid',width:60,align:'right'">所属团队</th>           
            <th data-options="field:'createdate',width:130,align:'center',formatter:TAOTAO.formatDateTime">创建时间</th>
            <th data-options="field:'updatedate',width:130,align:'center',formatter:TAOTAO.formatDateTime">更新时间</th>
            <th data-options="field:'isactive',width:60,align:'right',formatter:TAOTAO.formatIsActiveStatus">代理状态</th>
            <th data-options="field:'isblacklist',width:70,align:'right',formatter:TAOTAO.formatIsBlackListStatus">黑名单状态</th>
        </tr>
    </thead>
</table>


<script>
	/* 搜索栏事件 */
	function doSearch(){
		$('#userList').datagrid('load',{
			name: $('#user_name').val(),
			mobile: $('#user_mobile').val()
		});
	}

    function getSelectionsIds(){
    	var userList = $("#userList");
    	var sels = userList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].name);	//sels[i].orderid要对应订单编号的field值
    	}
    	ids = ids.join(",");
    	return ids;
    }
	
	function getSelectionsMobiles(){
    	var userList = $("#userList");
    	var sels = userList.datagrid("getSelections");
    	var mobiles = [];
    	for(var i in sels){
    		mobiles.push(sels[i].mobile);	//sels[i].mobiles要对应订单编号的field值
    	}
    	mobiles = mobiles.join(",");
    	return mobiles;
    }
    
    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
        	$(".tree-title:contains('新增代理')").parent().click();
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','必须选择一个代理才能编辑!');
        		return ;
        	}
        	if(ids.indexOf(',') > 0){
        		$.messager.alert('提示','只能选择一个代理!');
        		return ;
        	}
        	
        	TT.createWindow({
    			url : "/user-edit",
    			onLoad : function(){
    				var data = $("#userList").datagrid("getSelections")[0];
    				$("#userEditForm").form("load",data);
    			}
    		});  
        	
        	
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var mobiles = getSelectionsMobiles('#userList');	//这里需要修改getSelectionsMobiles()，返回值定义为手机号
        	if(mobiles.length == 0){
        		$.messager.alert('提示','未选中代理!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除手机号为 '+mobiles+' 的代理吗？',function(r){
        	    if (r){
        	    	var params = {"mobiles":mobiles};
                	$.post("/user/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除代理成功!',undefined,function(){
            					$("#userList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>