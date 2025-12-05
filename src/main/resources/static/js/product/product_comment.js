/**
 * 
 */
console.log("1111");

const list = document.getElementById("list");
let num = list.getAttribute("data-product-num")

fetch(`./commentList?productNum=${num}`)
	.then(r => r.json())
	.then(r => {
		r.forEach(dto => {
			console.log(dto.username);
			console.log(dto.boardContents);
			console.log(dto.boardDate);
			
			let tr = document.createElement("tr");
			let td = document.createElement("td");
			td.innerText=dto.username;
			tr.append(td);
			td = document.createElement("td");
			td.innerText=dto.boardContents;
			tr.append(td);
			td = document.createElement("td");
			td.innerText=dto.boardDate;
			tr.append(td);			
			list.append(tr);
		})
	})
	.catch(e => console.log(e))
