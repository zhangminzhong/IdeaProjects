/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-4-22
 * Time: 下午12:47
 * To change this template use File | Settings | File Templates.
 */
/*
var http = require('http');
http.createServer(function(req,res){
    res.writeHead(200,{'Content-Type':'text/plain'});

    res.end(new Date().toLocaleDateString());
}).listen(1337,"127.0.0.1");
console.log('Server running at http://127.0.0.1:1337');
*/

/*
var dns = require("dns");
dns.resolve("www.qq.com",function(err,address){
    console.log(address);
});
*/


/*
var fs = require('fs');
function getFileData(callback){
    fs.readFile('index.conf',function(data){callback(data);});
}
function returnData(callback){
    getFileData(function(data){
        setTimeout(function(){callback(data)},1000);
    });
}*/
// 引入 events 模块
var events = require('events');
// 创建 eventEmitter 对象
var eventEmitter = new events.EventEmitter();

// 创建事件处理程序
var connectHandler = function connected() {
   console.log('连接成功。');
  
   // 触发 data_received 事件 
   eventEmitter.emit('data_received');
}


 
// 使用匿名函数绑定 data_received 事件
eventEmitter.on('data_received', function(){
   console.log('数据接收成功。');
});
// 绑定 connection 事件处理程序
eventEmitter.on('connection', connectHandler);
// 触发 connection 事件 
eventEmitter.emit('connection');

console.log("程序执行完毕。");
