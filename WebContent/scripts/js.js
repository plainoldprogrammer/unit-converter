document.getElementById("convert").onclick = function()
{
	var inputValue = document.getElementById("original").value;
	console.log("convert " + inputValue + " mile to kilometer");
	
	var request = new XMLHttpRequest();
	request.open('GET', 'http://localhost:8080/unit-converter/web-app/miletokilometerservice/' + inputValue, true);
	request.onload = function() {
	var data = JSON.parse(this.response);
	
	if (request.status == 200)
	{
		console.log(data);
		document.getElementById("converted").value = data["Kilometer Value"];
	}
	else
	{
		console.log('error');
	}
}

request.send();
}
