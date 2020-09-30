const http = require('http');
http.get({
  agent: false
  , path: "/streaming"
  , hostname: "localhost"
  , port: 8080
}, (res) => {
  res.on('data', data => {

    console.log(data.toString().trim());
  })
});