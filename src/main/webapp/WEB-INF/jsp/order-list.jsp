<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="orderList" title="商品列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/order/list',method:'get',pageSize:10,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'orderId',width:60">订单编号</th>
            <th data-options="field:'name',width:200">姓名</th>
            <th data-options="field:'mobile',width:100">手机号</th>
            <th data-options="field:'orderCnt',width:100">投单数</th>
            <th data-options="field:'price',width:70,align:'right',formatter:TAOTAO.formatPrice">每单金额</th>
            <th data-options="field:'amount',width:70,align:'right',formatter:TAOTAO.formatPrice">投单总金额</th>
            <th data-options="field:'investmentDate',width:100">投单日期</th>
            <th data-options="field:'address',width:130">收货地址</th>
            <th data-options="field:'remark',width:130">备注</th>
            <th data-options="field:'rewardMonths',width:60">分红月数</th>
            <th data-options="field:'extraDays',width:60">额外分红天数</th>
            <th data-options="field:'rewardDays',width:60">总分红天数</th>
            <th data-options="field:'createDate',width:130,align:'center',formatter:TAOTAO.formatDateTime">创建时间</th>
            <th data-options="field:'updateDate',width:130,align:'center',formatter:TAOTAO.formatDateTime">更新时间</th>
            <th data-options="field:'orderStatus',width:60,align:'center',formatter:TAOTAO.formatItemStatus">订单状态</th>
        </tr>
    </thead>
</table>
<div id="orderEditWindow" class="easyui-window" title="编辑订单" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/rest/page/item-edit'" style="width:80%;height:80%;padding:10px;">
</div>
<script>

    function getSelectionsIds(){
    	var orderList = $("#orderList");
    	var sels = orderList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
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
        	
        	$("#orderEditWindow").window({
        		onLoad :function(){
        			//回显数据
        			var data = $("#orderList").datagrid("getSelections")[0];
        			data.priceView = TAOTAO.formatPrice(data.price);
        			$("#orderEditForm").form("load",data);
        			
        			// 加载商品描述
        			/* $.getJSON('/rest/item/query/item/desc/'+data.id,function(_data){
        				if(_data.status == 200){
        					//UM.getEditor('itemeEditDescEditor').setContent(_data.data.itemDesc, false);
        					itemEditEditor.html(_data.data.itemDesc);
        				}
        			}); */
        			
        			//加载商品规格
        			$.getJSON('/rest/item/param/item/query/'+data.id,function(_data){
        				if(_data && _data.status == 200 && _data.data && _data.data.paramData){
        					$("#orderEditForm .params").show();
        					$("#orderEditForm [name=itemParams]").val(_data.data.paramData);
        					$("#orderEditForm [name=itemParamId]").val(_data.data.id);
        					
        					//回显商品规格
        					 var paramData = JSON.parse(_data.data.paramData);
        					
        					 var html = "<ul>";
        					 for(var i in paramData){
        						 var pd = paramData[i];
        						 html+="<li><table>";
        						 html+="<tr><td colspan=\"2\" class=\"group\">"+pd.group+"</td></tr>";
        						 
        						 for(var j in pd.params){
        							 var ps = pd.params[j];
        							 html+="<tr><td class=\"param\"><span>"+ps.k+"</span>: </td><td><input autocomplete=\"off\" type=\"text\" value='"+ps.v+"'/></td></tr>";
        						 }
        						 
        						 html+="</li></table>";
        					 }
        					 html+= "</ul>";
        					 $("#orderEditForm .params td").eq(1).html(html);
        				}
        			});
        			
        			TAOTAO.init({
        				"pics" : data.image,
        				"cid" : data.cid,
        				fun:function(node){
        					TAOTAO.changeItemParam(node, "orderEditForm");
        				}
        			});
        		}
        	}).window("open");
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中订单!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的订单吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("/rest/item/delete",params, function(data){
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