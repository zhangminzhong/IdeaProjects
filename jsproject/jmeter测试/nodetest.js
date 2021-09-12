/**
 * Created by zhang_minzhong on 2017/1/11.
 */
// var url = require('url');
var http = require('http');
http.createServer(function (req, res) {
    // var pathname = url.parse(req.url).pathname;
    res.writeHead(200, {'Content-Type': 'text/plain'});
    res.end('Hello World');
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');