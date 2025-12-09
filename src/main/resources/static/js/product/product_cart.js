
const cartAdd = document.getElementById("cartAdd");
let productNum = cartAdd.getAttribute("data-product-num");
let username = cartAdd.getAttribute("data-username");

cartAdd.addEventListener('click', ()=>{
	console.log("click")
	const param = new URLSearchParams();
	param.append('productNum', productNum);
	param.append('username', username);
	
	fetch("cartAdd",{
		method:"POST",
		body: param
	})
	.then(r=>r.json())
	.catch(e=>console.log(e))
})