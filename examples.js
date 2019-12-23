jQuery(document).ready(function($) {}
//A page can't be manipulated safely until the document is "ready." jQuery detects this state of readiness for you. Code included inside $( document ).ready() will only run once the page Document Object Model (DOM) is ready for JavaScript code to execute.

//AJAX just uses a combination of:
	// A browser built-in XMLHttpRequest object (to request data from a web server)
	var xhttp = new XMLHttpRequest();
	// JavaScript and HTML DOM (to display or use the data)
//AJAX allows web pages to be updated asynchronously by exchanging data with a web server behind the scenes. This means that it is possible to update parts of a web page, without reloading the whole page.
//To send a request to a server, we use the open() and send() methods
xhttp.open("GET", "ajax_info.txt", true);
xhttp.send(); //send takes string arg when a post request
//GET is simpler and faster than POST, and can be used in most cases.
//If you want to send information with the GET method, add the information to the URL:
xhttp.open("GET", "demo_get2.asp?fname=Henry&lname=Ford", true);
//To POST data like an HTML form, add an HTTP header with setRequestHeader(). Specify the data you want to send in the send() method:
xhttp.open("POST", "ajax_test.asp", true);
xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
xhttp.send("fname=Henry&lname=Ford");
//With the XMLHttpRequest object you can define a function to be executed when the request receives an answer.
//The readyState property holds the status of the XMLHttpRequest.
	// 0: request not initialized
	// 1: server connection established
	// 2: request received
	// 3: processing request
	// 4: request finished and response is ready
//The onreadystatechange property defines a function to be executed when the readyState changes.
//The status property and the statusText property holds the status of the XMLHttpRequest object.
//A callback function is a function passed as a parameter to another function.
//If you have more than one AJAX task in a website, you should create one function for executing the XMLHttpRequest object, and one callback function for each AJAX task.
//responseText 	get the response data as a string
document.getElementById("demo").innerHTML = xhttp.responseText;
//responseXML 	get the response data as XML data
///JQuery
//Return the element with id="id01":
var myElement = $("#id01");
//Return all <p> elements:
var myElements = $("p");
//Return all elements with class="intro".
var myElements = $(".intro");
//Return a list of all <p> elements with class="intro".
var myElements = $("p.intro");
//Set the inner text of an HTML element:
myElement.text("Hello Sweden!");
//Get the inner text of an HTML element:
var myText = myElement.text();
//Set the HTML content of an element:
var myElement.html("<p>Hello World</p>");
//Get the HTML content of an element:
var content = myElement.html();
//The load() method loads data from a server and puts the returned data into the selected element.
$(selector).load(URL,data,callback);
$("#div1").load("demo_test.txt");
//loads demo_test.txt into a div element
//The following example loads the content of the element with id="p1", inside the file "demo_test.txt", into a specific <div> element:
$("#div1").load("demo_test.txt #p1");
//The optional callback parameter specifies a callback function to run when the load() method is completed.
$("button").click(function(){
 $("#div1").load("demo_test.txt", function(responseTxt, statusTxt, xhr){
   if(statusTxt == "success")
     alert("External content loaded successfully!");
   if(statusTxt == "error")
     alert("Error: " + xhr.status + ": " + xhr.statusText);
 });
});
//The $.get() method requests data from the server with an HTTP GET request.
$("button").click(function(){
  $.get("demo_test.asp", function(data, status){
    alert("Data: " + data + "\nStatus: " + status);
  });
});
//POST: The optional data parameter specifies some data to send along with the request.
//The optional callback parameter is the name of a function to be executed if the request succeeds.
$("button").click(function(){
 $.post("demo_test_post.asp",
 {
   name: "Donald Duck",
   city: "Duckburg"
 },
 function(data, status){
   alert("Data: " + data + "\nStatus: " + status);
 });
}); 
