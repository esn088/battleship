var url="/api/games";
var data,datagames,datascore;
fetch(url, {

    method: "GET",

}).then(function (response) {

    if (response.ok) {
        // add a new promise to the chain
        return response.json();
    }
    // signal a server error to the chain
    throw new Error(response.statusText);

}).then(function (json) {
    // equals to .success in JQuery Ajax call
     data= json;
    console.log(data);
    createlist(data);
    console.log("hola");
    tablescore(data);





}).catch(function (error) {
    // called when an error occurs anywhere in the chain
    console.log("Request failed: " + error.message);
    alert("ups sorry not coneting server");
});

function  createlist(data){
    var playerid=document.getElementById("list");
    console.log(data);
    console.log(data.game.length);
    var player1;
    var player2;
    // console.log(data[i].gameplayer[0].Player.username)
    // console.log(data[0].gameplayer[0].id);
    for(var i=0;i<data.game.length;i++){

        player1 = data.game[i].gameplayer[0].Player.username;
        // console.log(player1)
        if(data.game[i].gameplayer[1] != null){
            player2=data.game[i].gameplayer[1].Player.username;
        }else if(data.game[i].gameplayer[1] == null){
            player2="not have rival";
        }
        // console.log(player2)
        var li=document.createElement("li");
        li.textContent=player1+" vs "+player2;

        playerid.appendChild(li);
    }
}

function tablescore(data){

    var table = document.getElementById("tablescore");
    var tbody = document.createElement("tbody")
    var thead = document.createElement("thead");
    var title1 = document.createElement("th");
    thead.appendChild(title1);
    title1.textContent = "UserName";

    var title2 = document.createElement("th");
    thead.appendChild(title2);
    title2.textContent = "Wins";

    var title3 = document.createElement("th");
    thead.appendChild(title3);
    title3.textContent = "Tie";

    var title4 = document.createElement("th");
    thead.appendChild(title4);
    title4.textContent = "Lose";

    var title5 = document.createElement("th");
    thead.appendChild(title5);
    title5.textContent = "Total";

    table.appendChild(thead);

        for(var i=0;i<data.score.length;i++){
            if(data.score[i].win!=undefined){


          var  tr = document.createElement("tr");
           var td = document.createElement("td");
            td.textContent=data.score[i].username;
            tr.appendChild(td);
            var td2= document.createElement("td");
            td2.textContent=data.score[i].win;
            tr.appendChild(td2);
            var td3= document.createElement("td");
            td3.textContent=data.score[i].tie;
            tr.appendChild(td3);
            var td4= document.createElement("td");
            td4.textContent=data.score[i].lost;
            tr.appendChild(td4);
            var td5= document.createElement("td");
            td5.textContent=data.score[i].total;
            tr.appendChild(td5);
            tbody.appendChild(tr);
        }
        }
    table.appendChild(tbody);
}


