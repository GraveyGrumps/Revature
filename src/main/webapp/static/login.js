function login()
{
	let username = document.getElementById("username").value;
	let password = document.getElementById("password").value;
	
	let user = {
			"username": username,
			"password": password
	}
	
	let xhttp = new XMLHttpRequest();
	
	//what to do if it succeeds
	xhttp.onload = (resp) =>{
		if(xhttp.status === 200)
			{
				//resp contains the response body
				window.location = "./home.html";
			}
		else
			{
			alert('invalid credentials');
			}
	}
	
	//what to do if it fails
	xhttp.onerror = () =>{
		
	}
	
	xhttp.open('POST','../users/login');

	
	xhttp.send(JSON.stringify(user));
}