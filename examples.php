<!DOCTYPE html>
<html>
<body>
<?php
$pups=array("tye", "people who name their shoes" => "dara", "people who want to go up if they're down and down if they're up" => array("ezra"));

class Car {
   function Car() {
	   global $pups;
	   static $model_number = 0;
	   $this->model = "$pups[0]-mobile-no. $model_number";
	   $model_number++;
   }
}
$herbie = new Car();
$sharpie = new Car();

echo "My first PHP script, $herbie->model!<br><br>draw me like your $sharpie->model, " . $pups["people who want to go up if they're down and down if they're up"][0] . ".<br><br>" . $_SERVER['SCRIPT_FILENAME'] . "<br><br>";

?>

<form method="post" action="<?php echo $_SERVER['PHP_SELF'];?>"> #sends data to 'PHP_SELF' (this file)
  Name: <input type="text" name="fname"> #fname is key in the _POST array
  <input type="submit">
</form>

<?php
if (strval($_SERVER["REQUEST_METHOD"]) == "POST") {
    // collect value of input field
    $name = $_REQUEST['fname'];
    if (empty($name)) {
        echo "Name is empty";
    } else {
        echo $name;
    }
}
?>


</body>
</html>

/*
$_SERVER['PHP_SELF'] 	Returns the filename of the currently executing script
$_SERVER['GATEWAY_INTERFACE'] 	Returns the version of the Common Gateway Interface (CGI) the server is using
$_SERVER['SERVER_ADDR'] 	Returns the IP address of the host server
$_SERVER['SERVER_NAME'] 	Returns the name of the host server (such as www.w3schools.com)
$_SERVER['SERVER_SOFTWARE'] 	Returns the server identification string (such as Apache/2.2.24)
$_SERVER['SERVER_PROTOCOL'] 	Returns the name and revision of the information protocol (such as HTTP/1.1)
$_SERVER['REQUEST_METHOD'] 	Returns the request method used to access the page (such as POST)
$_SERVER['REQUEST_TIME'] 	Returns the timestamp of the start of the request (such as 1377687496)
$_SERVER['QUERY_STRING'] 	Returns the query string if the page is accessed via a query string
$_SERVER['HTTP_ACCEPT'] 	Returns the Accept header from the current request
$_SERVER['HTTP_ACCEPT_CHARSET'] 	Returns the Accept_Charset header from the current request (such as utf-8,ISO-8859-1)
$_SERVER['HTTP_HOST'] 	Returns the Host header from the current request
$_SERVER['HTTP_REFERER'] 	Returns the complete URL of the current page (not reliable because not all user-agents support it)
$_SERVER['HTTPS'] 	Is the script queried through a secure HTTP protocol
$_SERVER['REMOTE_ADDR'] 	Returns the IP address from where the user is viewing the current page
$_SERVER['REMOTE_HOST'] 	Returns the Host name from where the user is viewing the current page
$_SERVER['REMOTE_PORT'] 	Returns the port being used on the user's machine to communicate with the web server
$_SERVER['SCRIPT_FILENAME'] 	Returns the absolute pathname of the currently executing script
$_SERVER['SERVER_ADMIN'] 	Returns the value given to the SERVER_ADMIN directive in the web server configuration file (if your script runs on a virtual host, it will be the value defined for that virtual host) (such as someone@w3schools.com)
$_SERVER['SERVER_PORT'] 	Returns the port on the server machine being used by the web server for communication (such as 80)
$_SERVER['SERVER_SIGNATURE'] 	Returns the server version and virtual host name which are added to server-generated pages
$_SERVER['PATH_TRANSLATED'] 	Returns the file system based path to the current script
$_SERVER['SCRIPT_NAME'] 	Returns the path of the current script
$_SERVER['SCRIPT_URI'] 	Returns the URI of the current page
*/

<a href="test_get.php?subject=PHP&web=W3schools.com">Test $GET</a>
#When a user clicks on the link "Test $GET", the parameters "subject" and "web" are sent to "test_get.php", and you can then access their values in "test_get.php" with $_GET.

#.htaccess file in index.html file can tell browser where to go


<?php phpinfo(); ?>
#ton of info

<?php
echo $_SERVER['HTTP_USER_AGENT'];

echo gettype ($_SERVER['PHP_SELF']);
#string
if ("test" == "index.php") {
	echo "true";
} else {
	echo "false";
}



unset($pages[$localpage]);
#removes key

$timedur = 0;
$timeexcess = 0;
for ($i = 1; $i <= 1000; $i++){
	$timeexcess += microtime(true);
	customheader("/");
	$timedur += microtime(true);
}
echo ($timedur-$timeexcess)/1000
#calcs function
?>
<?php
		function customheader($localpage){
			$pages = array("/" => "Schedule", "/account-settings.php" => "Account Settings", "/supervisor-overview.php" => "Supervisor Overview", "/help.php" => "Help");
			$title = $pages[$localpage];
			$navlinks="";
			foreach ($pages as $link => $page){
				if ($link == $localpage){
					$navlinks .=
					"<li class=\"nav-item active\">
						<a class=\"nav-link\" href=\"$link\">$page <span class=\"sr-only\">(current)</span></a>
					</li>";
				} else {
					$navlinks .=
					"<li class=\"nav-item\">
						<a class=\"nav-link\" href=\"$link\">$page</a>
					</li>";
				}
			}
			return
	"<title>$title</title>
	</head>
	<body>
		<nav class=\"navbar navbar-expand-lg navbar-dark bg-primary\">
			<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarColor01\" aria-controls=\"navbarColor01\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">
				<span class=\"navbar-toggler-icon\"></span>
			</button>

			<div class=\"collapse navbar-collapse\" id=\"navbarColor01\">
				<ul class=\"navbar-nav mr-auto\">
					$navlinks
				</ul>
			</div>
		</nav>";
		}

$conn = new mysqli("localhost","root", "","schedulesite");

if($conn == NULL){
    echo "failed to connect to local db";
    return;
}
$sql = "Select event_start from calendar_events where MONTH(event_start) = $month";
$result = $conn->query($sql);

$sql = "Select event_start from calendar_events where MONTH(event_start) = $month";
$result = $conn->query($sql);


$conn = new mysqli("localhost","root", "","schedulesite");
$IMDate = new DateTime("$yearNum-$monthNum-01 00:00:00");

#default parameters
function makecoffee($type = "cappuccino")
{
    return "Making a cup of $type.\n";
}
$conn = mysqli_connect($username=$dbUsername, $passwd=$dbPassword, $dbname=$dbName);
	?>

<?php echo "<p>Server Name: " . $_SERVER['SERVER_NAME'] . "</p>"

//isset — Determine if a variable is declared and is different than NULL

//session_start() creates a session or resumes the current one based on a session identifier passed via a GET or POST request, or passed via a cookie. Sessions are a simple way to store data for individual users against a unique session ID. This can be used to persist state information between page requests.
echo (False||True) ? "hi" : "you";
//"hi"
$hash= password_hash('testpass', PASSWORD_DEFAULT);
echo password_verify("testpass", $hash)? "yes":"no";
#"yes"
