/*
chuong trinh xu ly su kien click tren button OK, Reset cua page 'd07_eval.html'
*/

document.getElementById("btOK").onclick = function(){
    let s = document.getElementById("ex").value;
    let result = eval(s);
    document.getElementById("result").value = result;
}

document.getElementById("btReset").onclick = function(){
    document.getElementById("ex").value='';
    document.getElementById("result").value = '';
}


/*
chuong trinh xu ly su kien submit tren trang d07_regex.html
*/ 
function checkID(){
    let uid = document.getElementById("uid").value;
    let r = /^SV\d{2}$/ ; //dinh dang cua id bat dau la SV, ke tiep la 2 so bat ky
    
    //kiem tra 
    if(r.test(uid)==false){
        alert("invalid ID ! plz try again !");
        return false;
    }

}


/*
chuong trinh xu ly su kien submit tren trang d07_regex2.html
*/ 
function checkLocation(){
    let loc = document.getElementById("location").value;
    let sRegex = "^(HN|SG|DN|HU|CT|HP)$";
    let r = new RegExp(sRegex,'i') ;
    
    //kiem tra 
    if(r.test(loc)==false){
        alert("invalid Location ! plz try again !");
        document.getElementById("location").value="";
        document.getElementById("location").focus();
        return false;
    }

}