function colorFolder(nameFolder) {
    if(document.getElementById("moveButton").nodeValue=="y"){
        document.getElementById("moveButton").nodeValue="n"
        var list = document.getElementsByClassName("fa fa-folder-open-o");
        for(var i = 0;i<list.length;i++){
            list[i].className="fa fa-folder-open"
            var id_ = list[i].id.substring(0,2);
            if(id_==id)
                return;
            moveFolder(id_,id);
            return;
        }
        var list = document.getElementsByClassName("fa fa-folder-o");
        for(var i = 0;i<list.length;i++){
            list[i].className="fa fa-folder"
            var id_ = list[i].id.substring(0,2);
            if(id_==id)
                return;
            moveFolder(id_,id);
            return;
        }
    }
    if (document.getElementById(nameFolder + "-folder").className == "fa fa-folder-o") {
        document.getElementById(nameFolder + "-folder").className = "fa fa-folder"
        return;
    }
    if (document.getElementById(nameFolder + "-folder").className == "fa fa-folder-open-o") {
        document.getElementById(nameFolder + "-folder").className = "fa fa-folder-open"
        return;
    }
    var list = document.getElementsByClassName("fa fa-folder-open-o");
    for(var i = 0;i<list.length;i++){
        list[i].className="fa fa-folder-open"
    }
    var list = document.getElementsByClassName("fa fa-folder-o");
    for(var i = 0;i<list.length;i++){
        list[i].className="fa fa-folder"
    }
    if(document.getElementById(nameFolder + "-folder").className == "fa fa-folder"){
        document.getElementById(nameFolder + "-folder").className = "fa fa-folder-o"
    }else{
        document.getElementById(nameFolder + "-folder").className = "fa fa-folder-open-o"
    }
}

function openFolder(nameFolder) {
    switch (document.getElementById(nameFolder + "-folder").className) {
        case "fa fa-folder-o":
            document.getElementById(nameFolder + "-folder").className = "fa fa-folder-open-o"
            break;
        case "fa fa-folder":
            document.getElementById(nameFolder + "-folder").className = "fa fa-folder-open"
            break;
        case "fa fa-folder-open-o":
            document.getElementById(nameFolder + "-folder").className = "fa fa-folder-o"
            break;
        case "fa fa-folder-open":
            document.getElementById(nameFolder + "-folder").className = "fa fa-folder"
            break;
    }
}

function deleteFolder() {
    var list = document.getElementsByClassName("fa fa-folder-open-o");
    var id;
    for(var i = 0;i<list.length;i++){
        list[i].className="fa fa-folder-open"
        id = list[i].id.substring(0,2);
        $.post("delete",{
            id:id
        }).done();
        $("#"+id+"-li").removeData();
    }
    var list = document.getElementsByClassName("fa fa-folder-o");
    for(var i = 0;i<list.length;i++){
        list[i].className="fa fa-folder"
        id = list[i].id.substring(0,2);
        $.post("delete",{
            id:id
        }).done();
        $("#"+id+"-li").removeData();
    }

}

function addNewFolder() {
    var name
    var list = document.getElementsByClassName("fa fa-folder-open-o");
    for(var i = 0;i<list.length;i++){
        list[i].className="fa fa-folder-open"
        var id_ = list[i].id.substring(0,2);
        $.post("set",{
            id:id_,
            name:name
        }).done();

        return;
    }
    var list = document.getElementsByClassName("fa fa-folder-o");
    for(var i = 0;i<list.length;i++){
        list[i].className="fa fa-folder"
        var id_ = list[i].id.substring(0,2);
        if(id_==id)
            return;
        moveFolder(id_,id);
        return;
    }
}

function powerButton() {
    if((document.getElementsByClassName("fa fa-folder-open-o").length+document.getElementsByClassName("fa fa-folder-o").length)==1){
        document.getElementById("moveButton").nodeValue="y";
    }
}



function getSubfolders(idFolder) {
    if (document.getElementById(idFolder + "-list").childElementCount != 0) {
        if (document.getElementById(idFolder).className == 'fa fa-angle-right') {
            document.getElementById(idFolder).className = 'fa fa-angle-down';
            document.getElementById(idFolder + "-list").style.display = "";
            openFolder(idFolder);
            return;
        } else {
            document.getElementById(idFolder).className = 'fa fa-angle-right';
            document.getElementById(idFolder + "-list").style.display = "none";
            openFolder(idFolder);
            return;
        }
    }
    document.getElementById(idFolder).className = 'fa fa-angle-down';
    openFolder(idFolder);
    $.post("folder", {
        id: idFolder
    }).done(function (response) {
        $("#" + idFolder + "-list").html(response)
    })

}

function moveFolder(nameFolder, newFolder) {
    $.post("move", {
        name: nameFolder,
        part: newFolder
    }).done();
    $("#" + nameFolder + "-li").appendTo("#" + newFolder + "-list");

}

function getFiestFolder() {
    $.get("folder").done(function (resp) {
        $("#fF").html(resp)
    })

}