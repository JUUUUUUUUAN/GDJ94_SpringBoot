/**
 * 
 */
console.log("1111");

const list = document.getElementById("list");
let num = list.getAttribute("data-product-num")


function commentList(page){
	fetch(`./commentList?productNum=${num}&page=${page}`)
		.then(r => r.text())
		.then(r => {
			list.innerHTML = r;
		})
		.catch(e => console.log(e))	
}

commentList(1);
	
const commentAdd = document.getElementById("commentAdd");
const contents = document.getElementById("contents");
const close = document.getElementById("close");
const pagelink = document.getElementsByClassName("page-link");

list.addEventListener("click", (e)=>{
	let t = e.target;
	if(t.classList.contains("page-link")){
		let p = t.getAttribute("data-pager-num");
		commentList(p);
	}
})

commentAdd.addEventListener('click', ()=>{
	const param = new URLSearchParams();
	param.append('productNum', num);
	param.append('boardContents', contents.value);
	
	fetch("commentAdd", {
		method:"POST",
		body: param
	})
	.then(r=>r.json())
	.then(r=>{
		if(r=='1'){
			commentList()
		}
	})
	.catch(e=>console.log(e))
	.finally(()=>{
		contents.value="";
		close.click();
	})
})
