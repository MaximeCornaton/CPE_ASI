const input = document.getElementsByClassName("input-card");
const slider = document.getElementsByClassName("slide");
const dir = document.getElementsByClassName("direct");

const id = document.getElementsByClassName("id");



for (let i = 0; i < slider.length; i++) {
    slider[i].addEventListener("input", function() {
        dir[i].innerHTML = dir[i].dataset.name + " - " +slider[i].value;
    });
}

class cartes{
    constructor(name, desc, family, affinity, imgurl="", simgurl="", id = 300, energy, hp, defence, attack, price){
        this.name = name;
        this.description = desc;
        this.family = family;
        this.affinity = affinity;
        this.imgurl = imgurl;
        this.simgurl = simgurl;
        this.id = id;
        this.energy = energy;
        this.hp = hp;
        this.defence = defence;
        this.attack = attack;
        this.price = price;
    }
}



function getForm(){
    const desc = input[1].value;
    const nom = input[0].value;
    const affinity = input[3].value;
    const family = input[4].value;
    const imgurl = input[2].value;
    // const simgurl = input[1].value;
    const energy = input[8].value;
    const hp = input[5].value;
    const defence = input[6].value;
    const attack = input[7].value;
    const price = input[9].value;
    const id = input[10].value;

    card = new cartes(nom, desc, family, affinity,
            imgurl, "", id, energy, hp, defence, attack, price);
    localStorage.setItem("JSONcard",JSON.stringify(card));
    addCard();
    console.log(card);
}

