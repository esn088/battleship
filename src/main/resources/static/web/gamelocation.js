        var url=makeUrl();
        var gamePlayerID;
        console.log(gamePlayerID)
        var n=0;
        var tr,td,td1;
        var letras=["","A","B","C","D","E","F","G","H","I","J"];
        var letras2=["","PA","PB","PC","PD","PE","PF","PG","PH","PI","PJ"];
        var numeros=["1","2","3","4","5","6","7","8","9","10"];
        var t="table1",t1="table2";

        var h=0;
        var coordenadas="";

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
            creartablero(letras,numeros,t);
            creartablero(letras2,numeros,t1);
            crearbarcos();
            crearplayer();
            crearDisparos();

        }).catch(function (error) {
            // called when an error occurs anywhere in the chain
            console.log("Request failed: " + error.message);
            alert("ups sorry not coneting server");
        });


        function getParameterByName(name) {
            var match = RegExp('[?&]' + name + '=([^&]*)').exec(window.location.search);
            return match && decodeURIComponent(match[1].replace(/\+/g, ' '));
        }

        function makeUrl() {
            gamePlayerID = getParameterByName("gp");
            return '/api/Game_view/' + gamePlayerID;
        }

        function crearplayer() {
            var player1,player2,name;
            player1=data.game.gameplayer[0].Player.name;
            player2=data.game.gameplayer[1].Player.name;
            // console.log(player1);
            name=document.getElementById("players");
            name.textContent="  "+player1+" vs  "+player2;

        }

        function crearbarcos(){

            for(var i=0;i<data.ships.length;i++){
                for(var j=0;j<data.ships[i].locations.length;j++){
                    // console.log(data.ships[i].locations[j]);
                    barco=document.getElementById(data.ships[i].locations[j]);
                    barco.setAttribute("style", "background-color: blue");
                    barco.setAttribute("class", "ships");
                    //   console.log(barco);
                }
            }
        }

        function creartablero(letras,numeros,t) {
            var table=document.getElementById(t);
            var tbody = document.createElement("tbody");
            for(var i=0;i<=10;i++){
                tr=document.createElement("tr");
                td1 = document.createElement("td");
                td1.textContent=letras[i];
                tr.appendChild(td1);
                tbody.appendChild(tr);
                for(var j=0;j<10;j++){
                    td = document.createElement("td");
                    if(i==0){
                        td.textContent=numeros[j];
                    }else if(i!=0){
                        td.textContent="";
                        coordenadas=letras[i]+numeros[j];
                        // console.log(coordenadas);
                        td.setAttribute("id",coordenadas);
                    }
                    tr.appendChild(td);
                    tbody.appendChild(tr);
                }
            }

            table.appendChild(tbody);
        }

        function crearDisparos(){
    console.log("hola");
    var tiros,fusion="";
    var temp,Idtable,tempColor;
            for(var i=0;i<data.salvos.length;i++){

                console.log(data.salvos[i]);

                for(var j=0;j<data.salvos[i].salvoes.length;j++){
                    if(data.salvos[i].salvoes[j].GameplayerId==gamePlayerID){
                             console.log("soy en num 1")
                        for(var k=0;k<data.salvos[i].salvoes[j].locationsSalvos.length;k++){
                            fusion="P"+data.salvos[i].salvoes[j].locationsSalvos[k];
                            tiros=document.getElementById(fusion);
                            tiros.setAttribute("style", "background-color: #50f372");
                            temp=data.salvos[i].salvoes[j].turn;
                            tiros.textContent=temp;
                        }

                    }else if(data.salvos[i].salvoes[j].GameplayerId!=gamePlayerID){
                        Idtable=document.getElementById("table1");
                        console.log("soy en num 2")
                        for(var k=0;k<data.salvos[i].salvoes[j].locationsSalvos.length;k++){
                            fusion=data.salvos[i].salvoes[j].locationsSalvos[k];
                            tiros=document.getElementById(fusion);

                            temp=data.salvos[i].salvoes[j].turn;
                            tiros.textContent=temp;
                            tempColor=document.getElementById(fusion).getAttribute("class");
                            if(tempColor==null){
                                tiros.setAttribute("style", "background-color:  #50f372");

                            }else  if(tempColor=="ships"){
                                tiros.setAttribute("style", "background-color:  red");
                            }

                        }
                    }

                }
            }
        }
        // data.salvos[0].salvoes[i].locationsSalvos[j]