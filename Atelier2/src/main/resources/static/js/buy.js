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
  let cardList = [];
  fetch("/cardsToBuy", {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => {
      return response.text();
    })
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
      .replace(/{{family_name}}/g, card.family)
      .replace(/{{img_src}}/g, card.img_src)
      .replace(/{{name}}/g, card.name)
      .replace(/{{description}}/g, card.description)
      .replace(/{{hp}}/g, card.hp)
      .replace(/{{energy}}/g, card.energy)
      .replace(/{{attack}}/g, card.attack)
      .replace(/{{defense}}/g, card.defence)
      .replace(/{{price}}/g, card.price);
    clone.firstElementChild.innerHTML = newContent;

    clone.firstElementChild.addEventListener("click", function () {
      showFullCard(card);
    });

    let cardContainer = document.querySelector("#tableContent");
    cardContainer.appendChild(clone);
  }
}

function showFullCard(card) {
  document.getElementById("cardNameId").innerHTML = card.name;
  document.getElementById("cardFamilyId").innerHTML = card.family;
  document.getElementById("cardDescriptionId").innerHTML = card.description;
  for (const element of $(".cardHPId")) {
    element.textContent = card.hp;
  }
  for (const element of $(".cardEnergyId")) {
    element.textContent = card.energy;
  }
  document.getElementById("cardAttackId").innerHTML = card.attack;
  $("#cardDefenceId")[0].textContent = card.defence;
  document.getElementById("cardPriceId").innerHTML = card.price;
  document.getElementById("cardImgId").src = card.imgUrl;
  document.getElementById("sellButtonID").onclick = function () {
    buy(card.id);
  };
  document.getElementById("card").style.display = "block";
}

function buy(idc) {
  fetch("/buy", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({
      idc: idc,
      idu: localStorage.getItem("id"),
    }),
  }).then(function (_) {
    document.getElementById(idc).parentNode.innerHTML = "";
    document.getElementById("card").style.display = "none";
    setUpDocument();
  });
}
