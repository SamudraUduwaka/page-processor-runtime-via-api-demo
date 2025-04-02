### via API get endpoint : 
https://d835f84d-fb72-430b-8a0b-06e529805888.mock.pstmn.io/portal-customization?version=v1.0&type=ORG&name=12345678

### Content from API
```
<!DOCTYPE html>
<html>
  <head>
    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;padding: 20px;
      }
      h1 {
        color: #333;
      }
      p {
        color: #555;
      }
    </style>
  </head>
  <body {{errorPage}}>
    <h1 {{heading}}>Welcome!!!</h1>
    <p>This is a simple HTML page for testing.</p>
    <p>Feel free to customize this page as needed.</p>
    <p>Current time: <span id='current-time'></span></p>
    <script>document.getElementById('current-time').innerText = new Date().toLocaleString();</script>
  </body>
</html>
```

### Parsed Content
```
<!DOCTYPE html>
<html>
  <head>
    <style>
      body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;padding: 20px;
      }
      h1 {
        color: #333;
      }
      p {
        color: #555;
      }
    </style>
  </head>
  <body style='background-color: red;'>
    <h1 style='color: blue;'>Welcome!!!</h1>
    <p>This is a simple HTML page for testing.</p>
    <p>Feel free to customize this page as needed.</p>
    <p>Current time: <span id='current-time'></span></p>
    <script>document.getElementById('current-time').innerText = new Date().toLocaleString();</script>
  </body>
</html>
```
