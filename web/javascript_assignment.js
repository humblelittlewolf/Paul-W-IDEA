//==========Part 1==========
function printHello(event){
	console.log("Hello");
}

var formButton1 = $('#button1');
formButton1.on("click", printHello);
//==========================

//=========Part 2===========
function addFields(event){

	var value1, value2, value3;

	value1 = parseInt($('#field1').val());
	value2 = parseInt($('#field2').val());
	value3 = value1 + value2;

	$('#field3').val(value3);
}

var formButton2 = $('#button2');
formButton2.on("click", addFields);
//==========================

//==========Part 3==========
function hideFunction(event) {
	if($("#paragraphToHide").is(":visible")){
    	$("#paragraphToHide").hide(500);
    }else{
    	$("#paragraphToHide").show(500);
    }
}

var formButton3 = $('#button3');
formButton3.on("click", hideFunction);
//==========================

//==========Part 4==========
function phoneValidate(event) {
    var phoneNumber = $('#phoneField').val();
    var reg = /^(\d){3}-(\d){3}-(\d){4}$/;
    
    if (reg.test(phoneNumber)) {
        console.log("Ok");
    } else {
        console.log("Bad");
    }
}

var formButton4 = $('#button4');
formButton4.on("click", phoneValidate);
//==========================

//=========Part 5===========
function jsonFunction(event) {
    var formObject = {};
    formObject.firstName = $('#firstName').val();
    formObject.lastName = $('#lastName').val();
    formObject.email = $('#email').val();
    var jsonString = JSON.stringify(formObject);

    console.log(jsonString);
}

var formButton5 = $('#button5');
formButton5.on("click", jsonFunction);
//==========================