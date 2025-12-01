const btn = document.getElementById("fileBtn");
const files = document.getElementById("files");
let count = 1;

files.addEventListener("click", (e)=>{
	let d = e.target
	if(d.classList.contains("del")){
		d.parentElement.remove();
		count--;
	}
	
})


btn.addEventListener("click", ()=>{
	/*const fileList = document.getElementsByClassName("del");
	if(fileList.length >= 5){
		alert("더이상 추가 할 수 없습니다.");
		return;
	}*/
	
	if(count >= 6) {
		alert("최대 5개 까지만");
		return;
	}
	let div = document.createElement("div");
	
	let input = document.createElement("input");
	input.setAttribute("type","file");
	input.name="attach"
	
	let button = document.createElement("button");
	button.type="button";
	button.innerHTML="X";
	button.classList.add("del");
	
	div.append(input);
	div.append(button);
	
	files.append(div);
	count++;
})