function loginCheck() {
    if(document.frm.userid.value.length == 0){
        alert("Please. Write ID.");
        frm.userid.focus();
        return false;
    }

    if(document.frm.pwd.value == ""){
        alert("Must enter the PW.");
        frm.pwd.focus();
        return false;
    }
    return true;
}