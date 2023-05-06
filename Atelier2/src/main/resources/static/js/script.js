function connect(){
    fetch('/login', {
        method: 'POST',
        headers: {  
            'Content-Type': 'application/json'

        },
        body: JSON.stringify({
            "surname": document.getElementsByClassName("surname").value,
            "password": document.getElementsByClassName("passwd").value
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

        let mdp1 = document.getElementById("passwd").value;
        let mdp2 = document.getElementById("passwd2").value;
        
        if (mdp1 == mdp2){
			console.log(mdp1,mdp1);
			
			fetch('/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    "name": document.getElementsByClassName("name"),
                    "surname": document.getElementsByClassName("surname"),
                    "password": document.getElementsByClassName("passwd"),
                    "money": 5999
                })
		    })
		    	.then(data => {
			        console.log(data);
			        localStorage.setItem("id", data);
		        	// window.location.href = "/home";
		       
    })
			
        }
        else{
			alert("Les 2 mots de passe ne sont pas identiques");
            return;
    	}
    }
