document.getElementById("convert").onclick = function()
{
	var fromUnit = document.getElementById("unit1").value;
	var toUnit = document.getElementById("unit2").value;
	var inputValue = document.getElementById("original").value;
	console.log("convert " + inputValue + " mile to kilometer");
	
	var request = new XMLHttpRequest();
	
	if (fromUnit === "mile" && toUnit === "kilometer")
	{
		request.open('GET', 'http://localhost:8080/unit-converter/web-app/miletokilometerservice/' + inputValue, true);
	}
	else if (fromUnit === "kilometer" && toUnit === "mile")
	{
		request.open('GET', 'http://localhost:8080/unit-converter/web-app/kilometertomileservice/' + inputValue, true);
	}
	
	request.onload = function() {
	var data = JSON.parse(this.response);
	
		if (request.status == 200)
		{
			console.log(data);
			
			if (fromUnit === "mile" && toUnit === "kilometer")
			{
				document.getElementById("converted").value = data["kilometer"];
			}
			else if (fromUnit === "kilometer" && toUnit === "mile")
			{
				document.getElementById("converted").value = data["mile"];
			}
		}
		else
		{
			console.log('error');
		}
	}
	
	request.send();
}
