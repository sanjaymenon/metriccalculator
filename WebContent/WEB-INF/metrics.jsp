<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Metrics Calculator</title>
<script type="text/javascript" ></script>
<link rel="stylesheet" type="text/css" media="screen" href="/metriccalculator/WebContent/WEB-INF/css/ui.jqgrid.css" />
<script type="text/javascript" src="/metriccalculator/WebContent/WEB-INF/js/jquery-1.4.2.min.js"></script>
 <script type="text/javascript" src="/metriccalculator/WebContent/WEB-INF/js/jquery.jqGrid.min.js" ></script>
 </head>
<body>
<script type="text/javascript">
$(function() {
	  $("#grid").jqGrid({

	  url:'/spring-jqgrid-integration/krams/crud',
	   datatype: 'json',
	   mtype: 'GET',
	      colNames:['metric', 'displayname'],
	      colModel:[
	       {name:'metric',index:'name', width:55,editable:false,editoptions:{readonly:true,size:10},hidden:true},
	       {name:'displayname',index:'displayname', width:100,editable:true, editrules:{required:true}, editoptions:{size:10}},
	       
	      ],
	      postData: {
	   },
	   rowNum:20,
	      rowList:[20,40,60],
	      height: 200,
	      autowidth: true,
	   rownumbers: true,
	      pager: '#pager',
	      sortname: 'metric',
	      viewrecords: true,
	      sortorder: "asc",
	      caption:"Metrics",
	      emptyrecords: "Empty records",
	      loadonce: false,
	      loadComplete: function() {
	   },
	      jsonReader : {
	          root: "rows",
	          page: "page",
	          total: "total",
	          records: "records",
	          repeatitems: false,
	          cell: "cell",
	          id: "metric"
	      }
	  });
	  jq("#grid").jqGrid('navGrid','#pager',
	    {edit:false,add:false,del:false,search:true},
	    { },
	          { },
	          { },
	    {
	        sopt:['eq', 'ne', 'lt', 'gt', 'cn', 'bw', 'ew'],
	           closeOnEscape: true,
	            multipleSearch: true,
	             closeAfterSearch: true }
	  );
	 
	 
	   
	  jq("#grid").navButtonAdd('#pager',
	    {  caption:"Add",
	     buttonicon:"ui-icon-plus",
	     onClickButton: addRow,
	     position: "last",
	     title:"",
	     cursor: "pointer"
	    }
	  );
	  });

</script>

<script type="text/javascript">
function addRow() {
	 
	 // Get the currently selected row
	    jq("#grid").jqGrid('editGridRow','new',
	      {  url: "/spring-jqgrid-integration/krams/crud/add",
	     editData: {
	       },
	       recreateForm: true,
	       beforeShowForm: function(form) {
	       },
	    closeAfterAdd: true,
	    reloadAfterSubmit:false,
	    afterSubmit : function(response, postdata)
	    {
	           var result = eval('(' + response.responseText + ')');
	     var errors = "";
	      
	           if (result.success == false) {
	      for (var i = 0; i < result.message.length; i++) {
	       errors +=  result.message[i] + "";
	      }
	           }  else {
	            jq("#dialog").text('Entry has been added successfully');
	      jq("#dialog").dialog(
	        { title: 'Success',
	         modal: true,
	         buttons: {"Ok": function()  {
	          jq(this).dialog("close");}
	         }
	        });
	                 }
	        // only used for adding new records
	        var new_id = null;
	         
	     return [result.success, errors, new_id];
	    }
	      });
	 
	}
</script>

<p>Metric Calculator</p>
<div id="jqgrid">
 <table id="grid"></table>
 <div id="pager"></div>
</div>
 
<div id="dialog" title="Feature not supported" style="display:none">
 <p>That feature is not supported.</p>
</div>
 
<div id="dialogSelectRow" title="Warning" style="display:none">
 <p>Please select row</p>
</div>

</body>
</html>