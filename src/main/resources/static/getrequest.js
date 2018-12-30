$(document).ready(
	function () {
		
		//GET REQUEST
		$("#getAllBooks").click(function(event) {
			// Prevent the form from submitting via the browser.
			event.preventDefault();
			ajaxGet();
		});

		//DO GET
		function ajaxGet() {		
			
			$.get("getBooks", function (objDados, status) {
				
				$("#getResultDiv ul").empty();
				var custList = "";
				
					
					for (i=0; i<objDados.length; i++) {
					
						var user = "Book Name " + objDados[i].bookName
								+ ", Author = " + objDados[i].author + "<br>";
						$('#getResultDiv .list-group').append(user)
						
					}
				
				
			});
	/*
			$.ajax({
				type: "GET",
				url: "getBooks",
				success: function(result) {
					alert(result);
					if (result.status == "success") {
						$("#getResultDiv ul").empty();
						var custList = "";
						$each(result.data, function(i, book) {
							var user = "Book Name " + book.bookName
									+ ", Author = " + book.author + "<br>";
							$('#getResultDiv .list-group').append(book)
						});	
						console.log("Success ", result);
					} else {
						//$("#getResultDiv").html("<strong>Error</strong>")
						//console.log("Fail: ", result);
						$("#getResultDiv ul").empty();
						var custList = "";
						$each(result.data, function(i, book) {
							var user = "Book Name " + book.bookName
									+ ", Author = " + book.author + "<br>";
							$('#getResultDiv .list-group').append(book)
						});	
						console.log("Success ", result);
					}
				},				
				error: function(e) {
					$("#getResultDiv").html("<strong>Error</strong>")
					console.log("ERROR: ", e);
				}
			});	
			*/
		}

	})
		