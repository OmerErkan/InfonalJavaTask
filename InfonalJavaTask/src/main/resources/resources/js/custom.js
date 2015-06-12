/**
 * Contains custom JavaScript code
 */
var urlHolder = new Object();

function loadTable() {
	$.get(urlHolder.records, function(response) {
		
 		$('#tableUsers').find('tbody').remove();
 		
 		for (var i=0; i<response.users.length; i++) {
			var row = '<tr>';
			row += '<td><input type="radio" name="index" id="index" value="'+i+'"></td>';
			row += '<td>' + response.users[i].name + '</td>';
			row += '<td>' + response.users[i].surName + '</td>';
			row += '<td>' + response.users[i].phoneNumber + '</td>';
			row += '</tr>';
	 		$('#tableUsers').append(row);
 		}
 		
 		$('#tableUsers').data('model', response.users);
		toggleForms('hide'); ;
 	});
}

function submitNewRecord() {
	$.post(urlHolder.add, {
			name: $('#newName').val(),
			surName: $('#newSurName').val(),
			phoneNumber: $('#newphoneName').val()
		}, 
		function(response) {
			if (response != null) {
				loadTable();
				toggleForms('hide'); ;
				toggleCrudButtons('show');
				alert('Success! Record has been added.');
			} else {
				alert('Failure! An error has occurred!');
			}
		}
	);	
}

function submitDeleteRecord() {
	var selected = $('input:radio[name=index]:checked').val();
	
	$.post(urlHolder.del, {
			name: $('#tableUsers').data('model')[selected].name
		}, 
		function(response) {
			if (response == true) {
				loadTable(urlHolder.records);
				alert('Success! Record has been deleted.');
			} else {
				alert('Failure! An error has occurred!');
			}
		}
	);
}

function submitUpdateRecord() {
	$.post(urlHolder.edit, {
			name: $('#editName').val(),
			surName: $('#editSurName').val(),
			phoneNumber: $('#editPhoneNumber').val()
		}, 
		function(response) {
			if (response != null) {
				loadTable();
				toggleForms('hide'); ;
				toggleCrudButtons('show');
				alert('Success! Record has been edited.');
			} else {
				alert('Failure! An error has occurred!');
			}
		}
	);
}


function hasSelected() {
	var selected = $('input:radio[name=index]:checked').val();
	if (selected == undefined) { 
		alert('Select a record first!');
		return false;
	}
	
	return true;
}

function fillEditForm() {
	var selected = $('input:radio[name=index]:checked').val();
	$('#editName').val( $('#tableUsers').data('model')[selected].name );
	$('#editSurName').val( $('#tableUsers').data('model')[selected].surName );
	$('#editPhoneNumber').val( $('#tableUsers').data('model')[selected].phoneNumber);
}

function resetNewForm() {
	$('#newNname').val('');
	$('#newSurName').val('');
	$('#newPhoneNumber').val('');

}

function resetEditForm() {
	$('#editName').val('');
	$('#editSurName').val('');
	$('#editPhoneNumber').val('');
}

function toggleForms(id) {
	if (id == 'hide') {
		$('#newForm').hide();
		$('#editForm').hide();
		
	} else if (id == 'new') {
 		resetNewForm();
 		$('#newForm').show();
 		$('#editForm').hide();
 		
	} else if (id == 'edit') {
 		resetEditForm();
 		$('#newForm').hide();
 		$('#editForm').show();
	}
}

function toggleCrudButtons(id) {
	if (id == 'show') {
		$('#newBtn').removeAttr('disabled');
		$('#editBtn').removeAttr('disabled');
		$('#deleteBtn').removeAttr('disabled');
		$('#listAlluserBtn').removeAttr('disabled');
		
	} else if (id == 'hide'){
		$('#newBtn').attr('disabled', 'disabled');
		$('#editBtn').attr('disabled', 'disabled');
		$('#deleteBtn').attr('disabled', 'disabled');
		$('#listAlluserBtn').attr('disabled', 'disabled');
	}
}
