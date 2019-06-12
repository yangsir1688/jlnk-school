<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


共${page.totalRecords}条数 &nbsp;  &nbsp;　
第${page.currentPageNum}页/共${page.totalPage}页   &nbsp;  &nbsp;　

 <a href="${basePath}${page.url}&pagenum=${page.prePageNum}">上一页</a> 
 <A href="${basePath}${page.url}&pagenum=${page.nextPageNum}">下一页</A>

  </body>
</html>
