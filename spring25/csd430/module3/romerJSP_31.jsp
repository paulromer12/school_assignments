<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Paul Romer Module 3 Assignment -->
<html>
<head>
    <meta charset="UTF-8">
    <title>Even or Odd Checker</title>
</head>
<body>
<%
    // Declare and initialize an int array
    int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    // Iterate over the array using a for loop
    for (int i = 0; i < numbers.length; i++) {
        int num = numbers[i];
%>
        <p>
            Number: <%= num %> - 
            <% 
                // Check if the number is even or odd
                if(num % 2 == 0) { 
            %>
                    Even
            <%  } else { %>
                    Odd
            <%  } %>
        </p>
<%
    }
%>
</body>
</html>