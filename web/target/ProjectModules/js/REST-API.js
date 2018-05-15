var button = document.getElementById("getSite");
button.onclick = getSite;

var xhrObject = new XMLHttpRequest();

function getSite() {
    alert("click");
    xhrObject.open("GET", "Controller?action=APISiteHandler", true);
//    xhrObject.onreadystatechange = setSite;
    xhrObject.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhrObject.send(null);
}
/*
function setSite() {
    if (xhrObject.status == 200){
        if (xhrObject.readyState == 4) {
            document.getElementById("site").innerText = document
        }
    }

}*/