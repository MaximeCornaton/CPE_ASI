function connect(){
    console.log("test");
    fetch('/login', {
        method: 'POST',
        headers: {  
            'Content-Type': 'application/json'

        },
        body: JSON.stringify({
            "name": document.getElementsByClassName("name").value,
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
