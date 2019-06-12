<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
 <br> <br>
  <hr/>
 	<c:if test="${empty sessionScope.cart.items}">
		<h2>对不起，你还没有买东西，请继续购买</h2>
	</c:if>
	  
   	<c:if test="${!empty sessionScope.cart.items}">
   		 <table border="1" width="438px" >
    	
	    	<tr>
	    		<th>选择</th>
	    		<th>图书名称</th>
	    		<th>图书单价</th>
	    		<th>图书数量</th>
	    		<th>图书小计</th>
	    		<th>操作</th>
	    	</tr>
	    	<c:forEach items="${sessionScope.cart.items}" var="me" varStatus="vs"  >
	    		<tr class="${vs.index%2 ==0?'odd':'even' }">
	    			<td>
						<input type="checkbox" value="${me.key}" >
					</td>
		    		<td>${me.value.book.name}</td>
		    		<td>${me.value.book.price}</td>
		    		<td>
						<input type="text" size="3" id="quantity" name="quantity" value="${me.value.quantity}" onchange="changeNum(this,'${me.key}',${me.value.quantity})" >
					</td>
		    		<td>${me.value.totalPrice}</td>
		    		<td>
						<a href="javascript:delOneItem('${me.key}')">删除</a>
					</td>
	    		</tr>
	    	</c:forEach>
	    	<tr>
	    		<td colspan="6">
	    		共${sessionScope.cart.totalQuantity}件商品，总金额：${sessionScope.cart.amount}元  <a href="#">去支付</a>
	    		</td>
	    	</tr>
	    </table>
   	</c:if>
  </body>
</html>
<script type="text/javascript">
	// inputObj 客户端输入的数字
	// bookId 图书的编号
	// oldNum   以前的数量（未修改时！）
	function changeNum(inputObj,bookId,oldNum){
		var num = inputObj.value;
		//只能输入正整数
		if(!/^[1-9][0-9]*$/.test(num)){
			alert("请输入一个正确的数量");
			return;
		}
		
		
		
		var sure = window.confirm("确定要修改数量吗？");
		// 是否确定要修改
		if(sure){
		//确定
			window.location.href="${basePath}servlet/ControlServlet?op=changeNum&bookId="+bookId+"&num="+num;
		}else{
		//不确定
			inputObj.value= oldNum;
		}
	}

		function delOneItem(bookId){
			var sure = window.confirm("你确定要删除该项吗？");
			if(sure){
			window.location.href="${basePath}servlet/ControlServlet?op=delOneItem&bookId="+bookId
			}
		}
	
	

</script>










