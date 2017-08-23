function colorFolder(nameFolder) {
    switch (document.getElementById(nameFolder + "-folder").className) {
        case "fa fa-folder-o":
            document.getElementById(nameFolder + "-folder").className = "fa fa-folder"
            break;
        case "fa fa-folder":
            document.getElementById(nameFolder + "-folder").className = "fa fa-folder-o"
            break;
        case "fa fa-folder-open-o":
            document.getElementById(nameFolder + "-folder").className = "fa fa-folder-open"
            break;
        case "fa fa-folder-open":
            document.getElementById(nameFolder + "-folder").className = "fa fa-folder-open-o"
            break;
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

function getSubfolders(nameFolder, idFolder) {
    if (document.getElementById(idFolder + "-list").childElementCount != 0) {
        if (document.getElementById(idFolder).classList == 'fa fa-angle-right') {
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
        data: nameFolder
    }).done(function (response) {
        $("#" + idFolder + "-list").html(response)
    })

}

function moveFolder(nameFolder,newFolder) {
    $.post("move",{
        name:nameFolder,
        part:newFolder
    }).done();


}

function getFiestFolder() {
    $.get("folder").done(function (resp) {
        $("#fF").html(resp)
    })

}