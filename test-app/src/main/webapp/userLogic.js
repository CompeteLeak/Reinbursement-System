window.onload = function(){
	console.log("Loaded app");
	loadLoginView();
	$(document).on('click', '#register', addUser);
	$(document).on('click', '#login', homePageLog);
	$(document).on('click', '#saveButton', saveTickets);
	$(document).on('click', '#logout', LogOut);

}


var  counter = 4; 

function reply_click(clicked_id)
{

	var res = clicked_id.substring(4); 
	var accepted = "accepted";
	var ID = {
			i: res,
			stati: accepted
	}

	var gotit = document.getElementById ( res ).innerText;

	var user1 = {

			id : gotit, 
			stati: accepted

	}



	var json = JSON.stringify(user1); 
	console.log(json);


	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){

			console.log(xhr.status);
		}
	}

	xhr.open("POST", "id");

	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(json);
}



function reply_click1(clicked_id1)
{
	var res = clicked_id1.substring(4); 
	var gotit = document.getElementById ( res ).innerText;

	var denied = "denied";
	var user1 = {

			id : gotit, 
			stati: denied

	}



	var json = JSON.stringify(user1); 

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){

			console.log(xhr.status);

		}
	}

	xhr.open("POST", "id");

	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(json);
}
function LogOut () {


	window.location.href = "bursement.html";
};


function saveTickets()
{
	if(document.getElementById('createUser').value.length !== 0)
		addTravel();
	if(document.getElementById('houser').value.length !== 0)
		addHouse();
	if(document.getElementById('inconvy').value.length !== 0)
		addIncon();
}

function addTravel()
{
	var desig = uns;  
	var ammount = document.getElementById('createUser').value; 
	var ticket = "Travel Reinbursement"; 
	var status = "pending"; 
	var ticks = {

			username : desig,
			price : ammount, 
			tickets : ticket,
			stati : status
	}
	var json = JSON.stringify(ticks);
	console.log(ticks);
	console.log(json);
	console.log("Your ticket is above"); 
	$('#myTable tr:last').after('<tr><th scope="row">'+counter+'</th><td> $' + document.getElementById('createUser').value + '</td><td>Travel Reinbursement</td><td>Pending</td></tr>');
	counter++;

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){

			console.log(xhr.status);
		}
	}

	xhr.open("POST", "check");

	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(json);


}

function addHouse()
{
	var desig = uns;  
	var ammount = document.getElementById('houser').value; 
	var ticket = "Housing Reinbursement"; 
	var status = "pending"; 
	var ticks = {

			username : desig,
			price : ammount, 
			tickets : ticket,
			stati : status
	}
	var json = JSON.stringify(ticks);
	console.log(ticks);
	console.log(json);
	console.log("Your ticket is above"); 
	console.log("clicked"); 
	$('#myTable tr:last').after('<tr><th scope="row">'+counter+'</th><td> $' + document.getElementById('houser').value + '</td><td>Housing Reinbursement</td><td>Pending</td></tr>');
	counter++;

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){

			console.log(xhr.status);
		}
	}

	xhr.open("POST", "check");

	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(json);
}

function addIncon()
{
	var desig = uns;  
	var ammount = document.getElementById('inconvy').value; 
	var ticket = "Inconvenience Reinbursement"; 
	var status = "pending"; 
	var ticks = {

			username : desig,
			price : ammount, 
			tickets : ticket,
			stati : status
	}
	var json = JSON.stringify(ticks);
	console.log(ticks);
	console.log(json);
	console.log("Your ticket is above"); 
	console.log("clicked");
	console.log("clicked"); 
	$('#myTable tr:last').after('<tr><th scope="row">'+counter+'</th><td> $' + document.getElementById('inconvy').value + '</td><td>Inconvenience Reinbursement</td><td>Pending</td></tr>');
	counter++;

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4){

			console.log(xhr.status);

		}
	}

	xhr.open("POST", "check");

	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(json);

}


function addUser(){
	console.log("I am clicked");

	var un = $('#uname').val();
	var pw = $('#pass').val();

	var user = {

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



function populateTable(){

	var user1 = {

			username : uns

	}

	if (uns === "ADMIN"){

		console.log("Admin requests " + uns);

		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				$('#myTable tr:last').after(xhr.responseText);

			}
		}
		xhr.open("GET", "admin");

		xhr.send();



	}



	else{

		var json = JSON.stringify(user1);
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				$('#myTable tr:last').after(xhr.responseText);

			}
		}
		xhr.open("POST", "table");

		xhr.setRequestHeader("Content-type", "application/json");
		xhr.send(json);

	}

}
function homePageLog(){




	function getSW(){

		uns = un; 
		pans = pw; 
		console.log(uns); 
		$('#output').html(uns);


	}




	console.log("I am clicked");

	var un = $('#unamelog').val();
	var pw = $('#passlog').val();


	var user = {

			username : un, 
			password : pw
	}



	var json = JSON.stringify(user);
	console.log(user);
	console.log(json);

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.response != 418 ){
			$('#view').html(xhr.responseText);

			getSW(); 
			populateTable(); 


			console.log(xhr.status);
		}

		else if (xhr.readyState == 4 && xhr.response == 418)  {
			console.log("ANh Wrong");
			var alertName = $("#alertName").val();
			alert(alertName);// retrive using the ID of the input

		}
	}

	xhr.open("POST", "home");

	xhr.setRequestHeader("Content-type", "application/json");
	xhr.send(json);

} 	

function addTickets (){


	var li = document.createElement("LI");  
	var input = document.getElementById("add");
	li.innerHTML = input.value;
	input.value = "";

	document.getElementById("faves").appendChild(li);


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
			$('#createUser').on('click', loadRegisterView);
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
	xhr.open("GET", "register.views");
	xhr.send();
}




