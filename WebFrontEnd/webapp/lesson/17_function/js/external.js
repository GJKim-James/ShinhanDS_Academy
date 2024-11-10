/**
 * 
 */
function f3() {
	// DOM(Document Object Model)
	var arr = document.querySelectorAll("#myButtons > button");
	var output = "<ul>";
	
	for (var i = 0; i < arr.length; i++) {
		output += "<li>" + arr[i].innerHTML + "</li>";
	}
	
	document.querySelector("#here").innerHTML = output + "</ul>";
}