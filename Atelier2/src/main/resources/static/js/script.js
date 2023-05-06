function connect(){

    fetch('/login', {
        method: 'POST',
        headers: {  
            'Content-Type': 'application/json'

        },
        body: JSON.stringify({
            "surname": document.getElementsByClassName("surname")[0].value,
            "passwd": document.getElementsByClassName("passwd")[0].value
        })
    })  .then(data => data.json())
        .then(data => {
            if (data == -1){
                alert("Mauvais identifiant ou mot de passe");
            }
            else{
            console.log(data);
            localStorage.setItem("id", data);
            // window.location.href = "/home";
        }
        })
        .catch((err) => {
            console.log(err);
            
        })
        
    }

function register(){

    let mdp1 = document.getElementsByClassName("passwd")[0].value;
    let mdp2 = document.getElementsByClassName("passwd2")[0].value;
    
    if (mdp1 == mdp2){
		console.log(mdp1,mdp1);
		
		fetch('/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                "name": document.getElementsByClassName("name")[0].value,
                "surname": document.getElementsByClassName("surname")[0].value,
                "password": document.getElementsByClassName("passwd")[0].value,
                "money": 5000
            })
	    })
	    	.then(data => {
		        console.log(data);
		        localStorage.setItem("id", data);
	        	window.location.href = "/login-form.html";
	       
})
		
    }
    else{
		alert("Les 2 mots de passe ne sont pas identiques");
        return;
	}
}

function sell($idc){
	fetch('/sell', {
        method: 'POST',
        headers: {  
            'Content-Type': 'application/json'

        },
        body: JSON.stringify({
            "idc": $idc,
            "icu": localStorage.getItem("idu")
        })
    })
}
