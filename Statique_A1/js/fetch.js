function addCard(){

    const requestOptions = {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: localStorage.getItem("JSONcard"),
      };
      
    
      fetch('http://vps.cpe-sn.fr:8083/card', requestOptions)
        .then(response => response.json())
        .then(data => console.log(data))
        .catch(error => console.error(error));
}



function getCard(){
    
    const num = document.getElementsByClassName("id");

    fetch(`http://vps.cpe-sn.fr:8083/card/${num[0].value}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
            },
        })

    .then(function(res) {
        if (res.ok){
            const data = res.json();
            console.log(data);
        }
        else{
            console.log(error);
        }
    
    })

    .catch(error => console.error(error));

}

function callback(response){
    document.getElementById("txtChuck").innerHTML = response.value;
}

function err_callback(error){
    console.log(error);
}

// ====================================================================================================
  

    