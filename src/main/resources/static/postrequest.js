$(document).ready(
	function () {
		
		//SUBMIT FORM
		$("#bookForm").submit(function(event) {
			// Prevent the form from submitting via the browser.
			event.preventDefault();
			ajaxPost();
		});

		function ajaxPost() {
			
			if ($("#bookId").val() == '') {
				window.alert('Favor preencher o campo Book Id');
				$("#bookId").focus();
				return;
			}
			
			if ($("#bookName").val() == '') {
				window.alert('Favor preencher o campo Book Name');
				$("#bookName").focus();
				return;
			}
			
			if ($("#author").val() == '') {
				window.alert('Favor preencher o campo Author');
				$("#author").focus();
				return;
			}
			
			//PREPARE FORM DATA			
			var formData = {
			bookId: $("#bookId").val(),
			bookName: $("#bookName").val(),
			author: $("#author").val()
		}
		
		//DO POST
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: "saveBook",
			data: JSON.stringify(formData),
			dataType: 'json',
			
			success: function(result) {
				$("#postResultDiv").html(
						"" + $("#bookId").val()
								+ "Post Successfully! <br>"
								+ "---> Congrats !!"
								+ "</p>");
				/*
				if (result.status == "success") {
					$("#postResultDiv").html(
							"" + result.data.bookName
									+ "Post Successfully! <br>"
									+ "---> Congrats !!"
									+ "</p>");
				} else {
					$("#postResultDiv").html("<strong>Error</strong>")
				}
				console.log(result);
				*/
			},				
			error: function(e) {
				alert('Error!' + e.statusText);
				console.log("ERROR: ", e);
			}
		});
		
	}

})
		