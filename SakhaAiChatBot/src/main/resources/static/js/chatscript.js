// Sound Part Start
var p = 0;
var tom1 = new Audio("../musics/LordKrishna.mp3");
document.getElementById("img-volume").onclick = function() {
	if (p == 0) {
		p = 1;
		myFunction();
	}
	else {
		p = 0;
		stopaudio();
	}
};

function myFunction() {
	tom1.play();
	document.getElementById("img-volume").src = "../images/volume.png";
}
function stopaudio() {
	tom1.pause();
	document.getElementById("img-volume").src = "../images/mute.png";
}
// Sound Part Ends


// Typing Part
document.getElementById("askKrishna").onclick = function() {
	console.log("hi");
	let text = document.getElementById("lower-button").value;
	document.getElementById("text-area").innerHTML = text;
	let message = document.getElementById('text-area').innerHTML;
	gettingResponse(message);
};

// FAQ Part 

document.getElementById("btncol1").onclick = function() {
	console.log("hi");
	document.getElementById("text-area").innerHTML = "What is the purpose of life ?";
	gettingResponse("What is the purpose of life ?");
};

document.getElementById("btncol2").onclick = function() {
	console.log("hi");
	document.getElementById("text-area").innerHTML = "What is relationship ?";
	gettingResponse("What is relationship ?");
};

document.getElementById("btncol3").onclick = function() {
	console.log("hi");
	document.getElementById("text-area").innerHTML = "What is life ?";
	gettingResponse("What is life ?");
};

document.getElementById("btncol4").onclick = function() {
	console.log("hi");
	document.getElementById("text-area").innerHTML = "What is soul ?";
	gettingResponse("What is soul ?");
};

document.getElementById("btncol5").onclick = function() {
	console.log("hi");
	document.getElementById("text-area").innerHTML = "What is happiness ?";
	gettingResponse("What is happiness ?");
};

// End of FAQ
function gettingResponse(msg) {
	fetch('http://localhost:8080/message', {
		method: 'POST',
		body: JSON.stringify({ message: msg }),
		mode: 'cors',
		headers: {
			'Content-Type': 'application/json'
		},
	}).then(r => r.json())
		.then(r => {
			/*            let msg2 = { name: "Sakha", message: r.answer };*/
			/*this.messages.push(msg2);*/
			/*this.updateChatText(chatbox)
			textField.value = ''*/
			let sakhaResponse = document.getElementById('sakhaResponse');
			sakhaResponse.innerHTML = r.answer;

		}).catch((error) => {
			console.error('Error:', error);
			/* this.updateChatText(chatbox)
			 textField.value = ''*/
		});
}
/*document.getElementById('askKrishna').onclick=function()
{
	let message=document.getElementById('text-area').innerHTML;
	gettingResponse(message);	
}*/



/*
{"userId":1,"username":"abc","userEmail":"abc","password":"abc","phoneNumber":"5892769842"}*/
window.onload = function() {
	displayName();
}

function displayName() {
	fetch('http://localhost:8080/getCurrentUser')
		.then(r => r.json())
		.then(r => {

			document.getElementById('username').innerHTML = r.username;

		}).catch((error) => {
			console.error('Error:', error);
			/* this.updateChatText(chatbox)
			 textField.value = ''*/
		});
	/*	document.getElementById('username').innerHTML="Arpita Mittal";*/
}