function connect(){
    console.log("login");
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
            console.log("err");
            
        })
        
    }

    function register(){

        mdp1 = document.getElementsByClassName("passwd").value;
        mdp2 = document.getElementsByClassName("passwd2").value;
        if (mdp1 != mdp2){
            alert("Les 2 mots de passe ne sont pas identiques");
            return;
        }

        console.log('register');
        fetch('/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
                },
                body: JSON.stringify({
                    "name": document.getElementsByClassName("name").value,
                    "surname": document.getElementsByClassName("surname").value,
                    "password": document.getElementsByClassName("passwd").value
                })
    }).then(data => data.json())
    .then(data => {
        console.log(data);
        localStorage.setItem("id", data);
        // window.location.href = "/home";
    })
    }
