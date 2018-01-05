<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>World Adventures Airlines</title>
<link rel="stylesheet" type="text/css" href="resources/css/theme.css" />
<link rel="stylesheet" type="text/css" href="resources/css/normalize.css" />
</head>
<body>

	<div class="container">
		<div class="title">Add a passenger</div>
		
			<form action="AddPassenger" method="post">
				<fieldset>
					<legend>Passenger details</legend>
					<div class="inputField">
						<label for="first-name" class="inputLabel">First name: </label>
						<input name="first-name" type="text"></input>  
					</div>
					<div class="inputField">
						<label for="last-name" class="inputLabel">Last name: </label>
						<input name="last-name" type="text"></input>  
					</div>
					<div class="inputField">
						<label for="birth-date" class="inputLabel">Date of birth: </label>
						<input name="birth-date" type="text"></input>  
					</div>
					<div class="inputField">
						<label for="first-name" class="inputLabel">Gender: </label>
						<select name="gender">
							<option value="male">Male</option>
							<option value="female">Female</option>
						</select>
					</div>
				</fieldset>
				
				<div class="inputField" id="submitField">
					<input id="submitBtn" type="submit" value="Add new passenger"></input>
				</div>
			</form>
		
	
	
	</div>
</body>
</html>