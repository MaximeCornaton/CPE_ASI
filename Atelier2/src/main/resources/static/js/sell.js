$(document).ready(function () {
  if (!localStorage.getItem("id")) {
    window.location.href = "/login-form.html";
  } else {
    setUpDocument();
    getCardList();
  }
});

function setUpDocument() {
  fetch("/" + "user/" + localStorage.getItem("id"), {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => {
      return response.json();
    })
    .then((data) => {
      document.getElementById("userNameId").innerHTML = data.name;
      document.getElementById("userMoney").innerHTML = data.money;
    });
}

function getCardList() {
  let cardList = []
  fetch( "/" + localStorage.getItem("id") + "/cards", {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => {
      return response.text();
    })
    .then(data => data.json())
    .then((data) => {
      cardList = cardList.concat(data ? JSON.parse(data) : []);
      showCard(cardList);
    })
    .catch((error) => {
      console.log(error);
    });
}
function showCard(array) {
  let template = document.querySelector("#row");

  for (const card of array) {
    let clone = document.importNode(template.content, true);

    newContent = clone.firstElementChild.innerHTML
      .replace(/{{id}}/g, card.id)
      .replace(/{{family_src}}/g, card.family_src)
      .replace(/{{family_name}}/g, card.family_name)
      .replace(/{{img_src}}/g, card.img_src)
      .replace(/{{name}}/g, card.name)
      .replace(/{{description}}/g, card.description)
      .replace(/{{hp}}/g, card.hp)
      .replace(/{{energy}}/g, card.energy)
      .replace(/{{attack}}/g, card.attack)
      .replace(/{{defense}}/g, card.defense)
      .replace(/{{price}}/g, card.price);
    clone.firstElementChild.innerHTML = newContent;

    let cardContainer = document.querySelector("#tableContent");
    cardContainer.appendChild(clone);
  }
}

function showFullCard(id){
  fetch("/cards/" + id, {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => {
      return response.text();
    }
    )
    .then((data) => {
      card = JSON.parse(data);
      document.getElementById("cardNameId").innerHTML = card.name;
      document.getElementById("cardFamilyId").innerHTML = card.family_name;
      document.getElementById("cardDescriptionId").innerHTML = card.description;
      document.getElementById("cardHPId").innerHTML = card.hp;
      document.getElementById("cardEnergyId").innerHTML = card.energy;
      document.getElementById("cardAttackId").innerHTML = card.attack;
      document.getElementById("cardDefenceId").innerHTML = card.defense;
      document.getElementById("cardPriceId").innerHTML = card.price;
      document.getElementById("cardImgId").src = card.img_src;
      document.getElementById("sellButtonID").onclick = function() {
        sell(card.id)
      };
      document.getElementById("card").style.display = "block";
    }
    )
}
