var express = require('express');
var app = express();

app.use(express.static('dist'));

app.get('/', function (req, res) {  
  res.sendfile('index.html');
});

app.listen(9985, function(){
	console.log(' -> run server ' + new Date());
	console.log(" -> Dashboard run on port 8080")
});
