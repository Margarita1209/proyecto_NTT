function loginUser(){

    let user = document.getElementById('user').value;
    let pass = document.getElementById('pass').value;

    console.log(user,pass);

    if(user == 'constanza' && pass == '1234'){
        let data = {
            nombre: "Constanza"            
        }

        localStorage.setItem('isLoginUser','true');

        localStorage.setItem('currenUserData',JSON.stringify(data));

        window.location.assign("tabla.html");
    }else{
        alert("Usuario y contraseña incorrecto");
    }

}

function verifyIsLogin(pageIsLoginRedirect = 'false',currentPage='default'){
	
	let isLoginUser = localStorage.getItem('isLoginUser');
    console.log(pageIsLoginRedirect,isLoginUser,currentPage,isLoginUser == 'true');
	
	if(isLoginUser == 'true'){
        console.log(pageIsLoginRedirect,isLoginUser,currentPage);
		if(pageIsLoginRedirect == 'true'){
            window.location.assign("tabla.html"); 
        }
        
	}else{
        if(currentPage != 'login'){
            window.location.assign("login.html");
        }        
    }
	
}

function logoutUser(){
	
	let isLoginUser = localStorage.getItem('isLoginUser');
	
	if(isLoginUser){
		localStorage.removeItem('isLoginUser');
        localStorage.removeItem('currenUserData');
	}
    window.location.assign("INDEX1.html")   
	
}

function getDataUser(){
    let dataUser = JSON.parse(localStorage.getItem('currenUserData'));
    return dataUser;
}

function welcomeName(){
    let name = document.getElementById('welcomeUser');    
    name.innerText = getDataUser().nombre;
}