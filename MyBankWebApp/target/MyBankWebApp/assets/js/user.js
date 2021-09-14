function setIdForDelete(id){
    const elem = document.getElementById("idForDelete");
    elem.value = id;
}
function bankRegister_takes(){
        if (document.form.customer_name.value == ""){
        alert ( "Please enter name..." );
        return false;
    }
        if (document.form.exchange.value == ""&& document.form.exchange.value != "AZN"){
        alert ( "Exchange must be AZN" );
        return false;
    }
        if (document.form.account_number.value == ""){
        alert ( "Please enter account number..." );
        return false;
    }
        if (document.form.balance.value == "" && document.form.balance.value!=300){
        alert ( "Balance must be 300" );
        return false;
    }
        if (document.form.status.value == "" && document.form.status.value != "Deactive"){
        alert ( "Status must be DEACTIVE" );
        return false;
    }
}
function login_takes(){
    if (document.form.email.value == ""){
        alert ( "Please enter email..." );
        return false;
    }
    if (document.form.password.value == ""){
        alert ( "Please enter password..." );
        return false;
    }
}
function register_takes(){
    if(document.form.name.value==""){
        alert("Please enter name...")
        return false;
    }
    if(document.form.surname.value==""){
        alert("Please enter surname...")
        return false;
    }
    if(document.form.email.value==""){
        alert("Please enter email...")
        return false;
    }
    if(document.form.password.value==""){
        alert("Please enter password...")
        return false;
    }
    if(document.form.rePassword.value==""){
        alert("Please re-enter password  ...")
        return false;
    }
}
function transfer_takes(){
    if(document.form.fAccount.value==""){
        alert("Please enter account number...")
        return false;
    }
    if(document.form.tAccount.value==""){
        alert("Please enter account number...")
        return false;
    }
    if(document.form.amount.value==""){
        alert("Please enter amount...")
        return false;
    }
}
function myTransaction_takes(){
    if(document.form.searchAccountNumber.value==""){
        alert("Please enter account number...");
        return false;
    }
}
