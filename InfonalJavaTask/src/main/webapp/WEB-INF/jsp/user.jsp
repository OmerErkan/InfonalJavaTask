
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<c:url value="/users/getAllUser" var="recordsUrl"/>
<c:url value="/users/add" var="addUrl"/>
<c:url value="/users/update" var="editUrl"/>
<c:url value="/users/delete" var="deleteUrl"/>

<html>
<head>
	<link rel='stylesheet' type='text/css' media='screen' href='<c:url value="/resources/resources/css/style.css"/>'/>
	<script type='text/javascript' src='<c:url value="/resources/resources/js/jquery-1.6.4.min.js"/>'></script>
	<script type='text/javascript' src='<c:url value="/resources/resources/js/custom.js"/>'></script>

	<title>User Records</title>
	
	<script type='text/javascript'>
	$(function() {
		// init
		urlHolder.records = '${recordsUrl}';
		urlHolder.add = '${addUrl}';
		urlHolder.edit = '${editUrl}';
		urlHolder.del = '${deleteUrl}';
		loadTable();
		
		$('#newBtn').click(function() { 
			toggleForms('new');
			toggleCrudButtons('hide');
		});
		
		$('#editBtn').click(function() { 
			if (hasSelected()) {
				toggleForms('edit');
				toggleCrudButtons('hide');
				fillEditForm();
			}
		});
		
		$('#listAlluserBtn').click(function() { 
			loadTable();
		});

		$('#deleteBtn').click(function() {
			if (hasSelected()) { 
				submitDeleteRecord();
			}
		});
		
		$('#newForm').submit(function() {
			event.preventDefault();
			submitNewRecord();
		});
		
		$('#editForm').submit(function() {
			event.preventDefault();
			submitUpdateRecord();
		});

		$('#closeNewForm').click(function() { 
			toggleForms('hide'); 
			toggleCrudButtons('show');
		});
		
		$('#closeEditForm').click(function() { 
			toggleForms('hide'); 
			toggleCrudButtons('show');
		});
	});
	</script>
</head>

<body>
	<h1 id='banner'>User Manager System</h1>
	<hr/>
	
	<table id='tableUsers'>
		<caption></caption>
		<thead>
			<tr>
				<th></th>
				<th>Name</th>
				<th>SurName</th>
				<th>Phone Number</th>
			</tr>
		</thead>
	</table>
	
	<div id='controlBar'>
		<input type='button' value='New' id='newBtn' />
		<input type='button' value='Delete' id='deleteBtn' />
		<input type='button' value='Edit' id='editBtn' />
		<input type='button' value='ListAlluser' id='listAlluserBtn' />
	</div>
	
	<div id='newForm'>
		<form>
  			<fieldset>
				<legend>Create New Record</legend>
				<label for='newName'> Name     </label><input type='text' id='newName'/><br/>
				<label for='newSurName'>  SurName       </label><input type='text' id='newSurName'/><br/>
				<label for='newPhoneNumber'>Phone Number </label><input type='text' id='newPhoneNumber'/><br/>
  			</fieldset>
			<input type='button' value='Close' id='closeNewForm' />
			<input type='submit' value='Submit'/>
		</form>
	</div>
</body>
</html>