//window.onload = function(){
//	$('#register').on('click', addUser);
//	//$('#uname').on('blur', isUnique);
//	loadLoginView();
//}

window.onload = function(){
	console.log("Loaded app");
	loadLoginView();
	$('#register').on('click', addUser);
	
}

function addUser(){

	var fn = $('#fn').val();
	var ln = $('#ln').val();
	var un = $('#uname').val();
	var pw = $('#pass').val();

	var user = {
			//add first name and last name fields 
			firstName : fn, 
			lastName : ln,
			username : un, 
			password : pw
	}

	var json = JSON.stringify(user);
	console.log(user);
	console.log(json);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){
			console.log(xhr.status);
			console.log(xhr.responseText);
		}
	}

	xhr.open("POST", "users");

	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(json);
}





function loadLoginView(){
	//retrieve login.html partial and replace #view with it
	//then add event listeners for functionality 
	
	//send request using AJAX
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		//only place to deal with response
		if(xhr.readyState == 4){
			$('#view').html(xhr.responseText);
			//$('#createUser').on('click', loadRegisterView);
		}
	}
	xhr.open("GET", "login.view");
	xhr.send();
	
}

function loadRegisterView(){
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		//only place to deal with response
		if(xhr.readyState == 4){
			$('#view').html(xhr.responseText);
			$('#goToLogin').on('click', loadLoginView);
		}
	}
	xhr.open("GET", "register.view");
	xhr.send();
}