document.getElementById("convert").onclick = function()
{
	var fromUnit = document.getElementById("unit1").value;
	var toUnit = document.getElementById("unit2").value;
	var inputValue = document.getElementById("original").value;
	
	var request = new XMLHttpRequest();
	
	request.open('GET', 'http://localhost:8080/unit-converter/web-app/length-unit-service/' + inputValue + "-" + fromUnit + "-" + toUnit, true);
	
	request.onload = function() {
		var data = JSON.parse(this.response);
	
		if (request.status == 200)
		{
			console.log(data);
			document.getElementById("converted").value = data["convertedQuantity"];
		}
		else
		{
			console.log('error');
		}
	}
	
	request.send();
}
