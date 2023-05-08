// nav start
let navToggle = document.querySelector(".nav__toggle");
let navWrapper = document.querySelector(".nav__wrapper");

navToggle.addEventListener("click", function () {
  if (navWrapper.classList.contains("active")) {
    this.setAttribute("aria-expanded", "false");
    this.setAttribute("aria-label", "menu");
    navWrapper.classList.remove("active");
  } else {
    navWrapper.classList.add("active");
    this.setAttribute("aria-label", "close menu");
    this.setAttribute("aria-expanded", "true");
  }
});
// nav end



// Sound Part Start
var p=0;
var tom1 = new Audio("musics/LordKrishna.mp3");
document.getElementById("img-volume").onclick = function() {
    if(p==0){
        p=1; 
        myFunction();
    }
    else{
        p=0;
        stopaudio();
    }
};

function myFunction() { 
    tom1.play();
    document.getElementById("img-volume").src="./images/volume.png";
}
function stopaudio() {
    tom1.pause();
    document.getElementById("img-volume").src="./images/mute.png";
} 
// Sound Part Ends


// Typing Part
document.getElementById("askKrishna").onclick = function() {
    console.log("hi");
    let text = document.getElementById("lower-button").value;
    document.getElementById("text-area").innerHTML = text;

};


// Multiple Time Chat JS-Part



class Chatbox {
    constructor() {
        this.args = {
            chatBox: document.querySelector('.wrapper'),
            sendButton: document.querySelector('.send__button')
        }

        this.state = false;
        this.messages = [];
    }

    display() {
        const {openButton, chatBox, sendButton} = this.args;

        sendButton.addEventListener('click', () => this.onSendButton(chatBox))
        const node = chatBox.querySelector('input');
        node.addEventListener("keyup", ({key}) => {
            if (key === "Enter") {
                this.onSendButton(chatBox)
            }
        })

    }


    onSendButton(chatbox) {
        var textField = chatbox.querySelector('input');
        let text1 = textField.value;
        if (text1 === "") {
            return;
        }

        let msg1 = { name: "User", message: text1 }
        /*let ms2={name:'Sakha',message:"hare krishna"}*/
        this.messages.push(msg1);
/*    this.messages.push(ms2);
*/
        
        fetch('/message', {
            method: 'POST',
            body: JSON.stringify({ message: text1 }),
            mode: 'cors',
            headers: {
              'Content-Type': 'application/json'
            },
          })
          .then(r => r.json())
          .then(r => {
            let msg2 = { name: "Sakha", message: r.answer };
            this.messages.push(msg2);
            this.updateChatText(chatbox)
            textField.value = ''

        }).catch((error) => {
            console.error('Error:', error);
            this.updateChatText(chatbox)
            textField.value = ''
          });
          
    }

    updateChatText(chatbox) {
        var html = '';
        console.log(this.messages);
        this.messages.slice().forEach(function(item, index) {
            if (item.name === "Sakha")
            {
                html += '<div class="messages__item messages__item--visitor">' + '<div class="icon icon-left"> <img class="user" src="./images/krishna1.png" alt="">   </div>'+'<p style="font-size: 20px;">'+ item.message +'</p>' +'</div>'
            }
            else
            {
                html += '<div class="messages__item messages__item--operator">'  +'<p style="font-size: 20px;">'+ item.message +'</p>' + '<div class="icon icon-right"> <img class="user" src="./images/man1.png" alt="">   </div>'+'</div>'
            }
          });
        const chatmessage = chatbox.querySelector('.msg');
        chatmessage.innerHTML = html;
    }
}


const chatbox = new Chatbox();
chatbox.display();

// End of multiple Time


window.onload = function() {
	displayName();
}

function displayName() {
	fetch('/getCurrentUser')
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

