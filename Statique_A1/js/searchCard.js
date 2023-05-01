function afficherCarte(card){
    let template = document.querySelector("#selectedCard");
    let clone = document.importNode(template.content, true);

    newContent= clone.firstElementChild.innerHTML
                .replace(/{{family_name}}/g, card.family)
                .replace(/{{img_src}}/g, card.imgUrl)
                .replace(/{{name}}/g, card.name)
                .replace(/{{description}}/g, card.description)
                .replace(/{{hp}}/g, card.hp)
                .replace(/{{energy}}/g, card.energy)
                .replace(/{{attack}}/g, card.attack)
                .replace(/{{defense}}/g, card.defense);
    clone.firstElementChild.innerHTML= newContent;

    let cardContainer= document.querySelector("#cardContainer");
    cardContainer.appendChild(clone);
    return true;
}





