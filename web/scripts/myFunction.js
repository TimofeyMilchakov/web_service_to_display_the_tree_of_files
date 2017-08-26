function colorFolder(nameFolder) {
    if (document.getElementById("moveButton").style.display == "none") {
        document.getElementById("moveButton").style.display = "";
        var id_ = getId()
        if (id_ == -1)
            return;

        if (id_ == nameFolder)
            return;
        moveFolder(id_, nameFolder);


    }
    if (document.getElementById(nameFolder + "-folder").className == "fa fa-folder") {
        document.getElementById(nameFolder + "-folder").className = "fa fa-folder-o"
        return;
    }
    if (document.getElementById(nameFolder + "-folder").className == "fa fa-folder-open") {
        document.getElementById(nameFolder + "-folder").className = "fa fa-folder-open-o"
        return;
    }
    var list = document.getElementsByClassName("fa fa-folder-open");
    for (var i = 0; i < list.length; i++) {
        list[i].className = "fa fa-folder-open-o"
    }
    var list = document.getElementsByClassName("fa fa-folder");
    for (var i = 0; i < list.length; i++) {
        list[i].className = "fa fa-folder-o"
    }
    if (document.getElementById(nameFolder + "-folder").className == "fa fa-folder-open-o") {
        document.getElementById(nameFolder + "-folder").className = "fa fa-folder-open"
    } else {
        document.getElementById(nameFolder + "-folder").className = "fa fa-folder"
    }
}

function getId() {
    for (var i = 0; i < 10000; i++) {
        if (document.getElementById(i + "-folder") == null)
            continue;
        if (document.getElementById(i + "-folder").className == "fa fa-folder") {
            var id_ = i;
            document.getElementById(id_ + "-folder").className = "fa fa-folder-o";

            return id_;
        }
        if (document.getElementById(i + "-folder").className == "fa fa-folder-open") {
            var id_ = i;
            document.getElementById(id_ + "-folder").className = "fa fa-folder-open-o";

            return id_;
        }
    }
    return -1;

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
    var id_ = getId();

    if (id_ == -1)
        return;
    $.post("delete", {
        id: id_
    }).done(function () {
        $("#" + id_ + "-li").remove();
    });


}

function renameFolder() {
    var name = document.getElementById("inputBox").value;
    document.getElementById("inputBox").value = "";
    if (name == "")
        return
    var id_ = getId();
    if (id_ == -1)
        return;
    var temp = document.getElementById(id_).className;
    $.get("set", {
        id: id_,
        name: name
    }).done();
    $("#" + id_ + "-folder").html(name);
    document.getElementById(id_).className = temp;
}

function addNewFolder() {
    var name = document.getElementById("inputBox").value;
    document.getElementById("inputBox").value = "";
    if (name == "")
        return
    var id_ = getId();
    if (id_ == -1)
        return;
    $.post("set", {
        parent_id: id_,
        name: name
    }).done(function (respons) {
        $(respons).appendTo("#" + id_ + "-list");
    });


}

function powerButton() {
    if ((document.getElementsByClassName("fa fa-folder-open").length + document.getElementsByClassName("fa fa-folder").length) == 1) {
        // noinspection JSAnnotator
        document.getElementById("moveButton").style.display = "none";
    }
}


function getSubfolders(idFolder) {


    if (document.getElementById(idFolder).className == 'fa fa-angle-down') {
        document.getElementById(idFolder).className = 'fa fa-angle-right';
        document.getElementById(idFolder + "-list").style.display = "none";
        openFolder(idFolder);
        return;
    }

    document.getElementById(idFolder).className = 'fa fa-angle-down';
    openFolder(idFolder);
    setTimeout(function () {
        document.getElementById(idFolder).style.display = "none";
        document.getElementById(idFolder + "-spinner").style.display = "";
    }, 0);
    $.post("folder", {
        id: idFolder
    }).done(function (response) {
        $("#" + idFolder + "-list").html(response)
        document.getElementById(idFolder).style.display = "";
        document.getElementById(idFolder + "-list").style.display = "";
        document.getElementById(idFolder + "-spinner").style.display = "none";
    });

}

function moveFolder(nameFolder, newFolder) {
    $.post("move", {
        name: nameFolder,
        part: newFolder
    }).done(function () {
        $("#" + nameFolder + "-li").appendTo("#" + newFolder + "-list");
    });


}

function getFiestFolder() {
    $.get("folder").done(function (resp) {
        $("#fF").html(resp)
    })

}