/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-5-5
 * Time: 下午12:58
 * To change this template use File | Settings | File Templates.
 */

/*
//阻塞
 var fs = require("fs");
 var data = fs.readFileSync("input.txt");
 console.log(data.toString());
 console.log("程序执行结束!");
 */
/*
//非阻塞
var fs = require("fs");
fs.readFile("input.txt",function(err,data){
    //doIt(err,data);
    setTimeout(function (){
        if (err) return console.error(err);
        console.log(data.toString());
    },5000);
});
console.log("程序执行结束!");
*/



/*
var events = require('events');
var eventEmitter = new events.EventEmitter();

// 监听器 #1
var listener1 = function listener1() {
    console.log('监听器 listener1 执行。');
}

// 监听器 #2
function listener2() {
    console.log('监听器 listener2 执行。');
}

// 绑定 connection 事件，处理函数为 listener1
eventEmitter.addListener('connection', listener1);

// 绑定 connection 事件，处理函数为 listener2
eventEmitter.on("connection123", listener2);

eventEmitter.emit("connection123");

console.log("程序执行完毕。");
 */
/*

var buf = new Buffer(256);
var length = buf.write("www.runoob.com");
console.log("写入字节数 : "+  length);

buf = new Buffer(26);
for(var i=0;i<26;i++){
    buf[i] = i + 97;
}
console.log( buf.toString('ascii'));       // 输出: abcdefghijklmnopqrstuvwxyz
console.log( buf.toString('ascii',0,5));   // 输出: abcde
console.log( buf.toString('utf8',0,5));    // 输出: abcde
console.log( buf.toString(undefined,0,5)); // 使用 'utf8' 编码, 并输出: abcde

buf = new Buffer("www.runoob.com");
var json = buf.toJSON(buf);
console.log(json);

var buffer1 = new Buffer('菜鸟教程 ');
var buffer2 = new Buffer('www.runoob.com');
var buffer3 = Buffer.concat([buffer1,buffer2]);
console.log("buffer3 内容: " + buffer3.toString());

var buffer1 = new Buffer('A');
var buffer2 = new Buffer('ABCD');
var result = buffer1.compare(buffer2);
if(result < 0) {
    console.log(buffer1 + " 在 " + buffer2 + "之前");
}else if(result == 0){
    console.log(buffer1 + " 与 " + buffer2 + "相同");
}else {
    console.log(buffer1 + " 在 " + buffer2 + "之后");
}
*/
/*

var fs = require("fs");
var data = '';
var readerStream = fs.createReadStream("input.txt");
readerStream.setEncoding("UTF8");
readerStream.on("data",function(chunk){
   // console.log(chunk);
    data += chunk;
});
readerStream.on("end",function(){
    console.log(data);
});
readerStream.on('error', function(err){
    console.log(err.stack);
});
console.log("程序执行完毕");
*/
/*

var fs = require("fs");
var data = '菜鸟教程官网地址：www.runoob.com';
// 创建一个可以写入的流，写入到文件 output.txt 中
var writerStream = fs.createWriteStream('output.txt');
// 使用 utf8 编码写入数据
writerStream.write(data,'UTF8');
// 标记文件末尾
writerStream.end();
// 处理流事件 --> data, end, and error
writerStream.on('finish', function() {
    console.log("写入完成。");
});
writerStream.on('error', function(err){
    console.log(err.stack);
});
console.log("程序执行完毕");
*/
/*
var fs = require("fs");
// 创建一个可读流
var readerStream = fs.createReadStream('input.txt');
// 创建一个可写流
var writerStream = fs.createWriteStream('output.txt');
// 管道读写操作
// 读取 input.txt 文件内容，并将内容写入到 output.txt 文件中
readerStream.pipe(writerStream);
console.log("程序执行完毕");
*/
/*

var fs = require("fs");
var zlib = require('zlib');
// 压缩 input.txt 文件为 input.txt.gz
fs.createReadStream('input.txt')
    .pipe(zlib.createGzip())
    .pipe(fs.createWriteStream('input.txt.gz'));
console.log("文件压缩完成。");
*/
/*
var Hello = require('./hello');
var hello = new Hello();
hello.setName("zhangsan");
hello.sayHello();
*/
/*
var http = require("http");
var url = require("url");
function onRequest(request, response) {
    var pathname = url.parse(request.url).pathname;
    console.log("Request for " + pathname + " received.");
    response.writeHead(200, {"Content-Type": "text/plain"});
    response.write("Hello World");
    console.log("onRequest()");
    response.end();
}
http.createServer(onRequest).listen(8888);
console.log("Server has started.");
*/
/*
function printHello(){
    console.log( "Hello, World!");
}
// 两秒后执行以上函数
setInterval(printHello, 2000);
*/
/*process.on('exit', function(code) {
    // 以下代码永远不会执行
    setTimeout(function() {
        console.log("该代码不会执行");
    }, 0);
    console.log('退出码为:', code);
});
console.log("程序执行结束");
*/

/*
// 输出到终端
process.stdout.write("Hello World!" + "\n");
// 通过参数读取
process.argv.forEach(function(val, index, array) {
    console.log(index + ': ' + val);
});
// 获取执行路局
console.log(process.execPath);
// 平台信息
console.log(process.platform);
*/

/*
// 输出当前目录
console.log('当前目录: ' + process.cwd());
// 输出当前版本
console.log('当前版本: ' + process.version);
// 输出内存使用情况
console.log(process.memoryUsage());
*/
/*
var util = require('util');
function Base() {
    this.name = 'base';
    this.base = 1991;
    this.sayHello = function() {
        console.log('Hello ' + this.name);
    };
}
Base.prototype.showName = function() {
    console.log(this.name);
};
function Sub() {
    this.name = 'sub';
}
util.inherits(Sub, Base);
var objBase = new Base();
objBase.showName();
objBase.sayHello();
console.log(objBase);
var objSub = new Sub();
objSub.showName();
//objSub.sayHello();
console.log(objSub);
*/
/*
var util = require('util');
function Person() {
    this.name = 'byvoid';
    this.toString = function() {
        return this.name;
    };
}
var obj = new Person();
console.log(util.inspect(obj));
console.log(util.inspect(obj, true));
*/
/*
var fs = require("fs");

// 异步打开文件
console.log("准备打开文件！");
fs.open('input.txt', 'r+', function(err, fd) {
    if (err) {
        return console.error(err);
    }
    console.log(fd);
    console.log("文件打开成功！");
});
console.log("结束!");
*/
/*
var fs = require("fs");

console.log("准备打开文件！");
fs.stat('input.txt', function (err, stats) {
    if (err) {
        return console.error(err);
    }
    console.log(stats);
    console.log("读取文件信息成功！");

    // 检测文件类型
    console.log("是否为文件(isFile) ? " + stats.isFile());
    console.log("是否为目录(isDirectory) ? " + stats.isDirectory());
});
*/
/*
var fs = require("fs");
console.log("准备写入文件");
fs.writeFile('input.txt', '我是通过写入的文件内容！',  function(err) {
    if (err) {
        return console.error(err);
    }
    console.log("数据写入成功！");
    console.log("--------我是分割线-------------")
    console.log("读取写入的数据！");
    fs.readFile('input.txt', function (err, data) {
        if (err) {
            return console.error(err);
        }
        console.log("异步读取文件数据: " + data.toString());
    });
});
*/
/*var fs = require("fs");
var buf = new Buffer(1024);

console.log("准备打开已存在的文件！");
fs.open('input.txt', 'r+', function(err, fd) {
    if (err) {
        return console.error(err);
    }
    console.log("文件打开成功！");
    console.log("准备读取文件：");
    fs.read(fd, buf, 0, buf.length, 0, function(err, bytes){
        if (err){
            console.log(err);
        }
        console.log(bytes + "  字节被读取");

        // 仅输出读取的字节
        if(bytes > 0){
            console.log(buf.slice(0, bytes).toString());
        }
        // 关闭文件
        fs.close(fd,function(err){
            if (err){
                console.log(err);
            }
            console.log("文件关闭成功");
        });
    });
});
*/
/*
var fs = require("fs");
var buf = new Buffer(1024);
console.log("准备打开文件！");
fs.open('input.txt', 'r+', function(err, fd) {
    if (err) {
        return console.error(err);
    }
    console.log("文件打开成功！");
    console.log("截取10字节后的文件内容。");

    // 截取文件
    fs.ftruncate(fd, 10, function(err){
        if (err){
            console.log(err);
        }
        console.log("文件截取成功。");
        console.log("读取相同的文件");
        fs.read(fd, buf, 0, buf.length, 0, function(err, bytes){
            if (err){
                console.log(err);
            }

            // 仅输出读取的字节
            if(bytes > 0){
                console.log(buf.slice(0, bytes).toString());
            }

            // 关闭文件
            fs.close(fd, function(err){
                if (err){
                    console.log(err);
                }
                console.log("文件关闭成功！");
            });
        });
    });
});
*/
/*var fs = require("fs");

console.log("准备删除文件！");
fs.unlink('input.txt', function(err) {
    if (err) {
        return console.error(err);
    }
    console.log("文件删除成功！");
});
*/
/*
var fs = require("fs");
var buf = new Buffer(1024);
// 异步打开文件
console.log("准备打开文件！");
fs.open('input.txt', 'w+', function(err, fd) {
    if (err) {
        return console.error(err);
    }
    console.log("文件打开成功！");
    console.log("准备写入文件");
    fs.writeFile('input.txt', '我是通过写入的文件内容！',  function(err) {
        if (err) {
            return console.error(err);
        }
        console.log("数据写入成功！");
        console.log("--------我是分割线-------------")
        console.log("读取写入的数据！(readFIle方法)");
        fs.readFile('input.txt', function (err, data) {
            if (err) {
                return console.error(err);
            }
            console.log("异步读取文件数据:(readFIle方法) " + data.toString());
        });
        console.log("准备读取文件！(read方法)");
        fs.read(fd, buf, 0, buf.length, 0, function(err, bytes){
            if (err){
                console.log(err);
            }

            // 仅输出读取的字节
            if(bytes > 0){
                console.log("异步读取文件数据:(read方法)"+buf.slice(0, bytes).toString());
            }
        });

    });
});
*/
/*var fs = require("fs");
console.log("创建目录 ./test/");
fs.mkdir("./test/",function(err){
    if (err) {
        return console.error(err);
    }
    console.log("目录创建成功。");
});
*/
/*
var fs = require("fs");
console.log("查看 ../jsproject 目录");
fs.readdir("../jsproject",function(err, files){
    if (err) {
        return console.error(err);
    }
    files.forEach( function (file){
        console.log( file );
    });
});
*/
/*
var fs = require("fs");

console.log("准备删除目录 ./test");
fs.rmdir("./test",function(err){
    if (err) {
        return console.error(err);
    }
    console.log("删除成功。");
    console.log("读取../jsproject 目录");
    fs.readdir("../jsproject",function(err, files){
        if (err) {
            return console.error(err);
        }
        files.forEach( function (file){
            console.log( file );
        });
    });
});
*/
/*
var http = require('http');
var url = require('url');
var util = require('util');

http.createServer(function(req, res){
    res.writeHead(200, {'Content-Type': 'text/plain'});
    res.end(util.inspect(url.parse(req.url, true)));
}).listen(3000);
*/
/*
var fs = require("fs");
var http = require('http');
var url = require("url");
var querystring = require('querystring');
var util = require('util');

http.createServer(function(req, res){
    var pathname = url.parse(req.url).pathname;
    req.setEncoding("utf8");
    res.writeHead(200,{"Content-Type":"text/html"});
    if(pathname != "/parse"){
        var indexPage = fs.readFileSync("main.html");
        res.end(indexPage);
    }
    else{
        var post = '';     //定义了一个post变量，用于暂存请求体的信息
        req.on('data', function(chunk){    //通过req的data事件监听函数，每当接受到请求体的数据，就累加到post变量中
            console.log(chunk.toString());
            post += chunk;
        });

        req.on('end', function(){    //在end事件触发后，通过querystring.parse将post解析为真正的POST请求格式，然后向客户端返回。
            post = querystring.parse(post);
            console.log(post);
            res.end(util.inspect(post));
        });
    }

}).listen(3000);
*/
/*
var os = require("os");

// CPU 的字节序
console.log('endianness : ' + os.endianness());

// 操作系统名
console.log('type : ' + os.type());

// 操作系统名
console.log('platform : ' + os.platform());

// 系统内存总量
console.log('total memory : ' + os.totalmem() + " bytes.");

// 操作系统空闲内存量
console.log('free memory : ' + os.freemem() + " bytes.");

console.log(os.uptime());

//var Interfaces = os.networkInterfaces()
var cpus = 	os.cpus();
cpus.forEach(function(cpu){
    console.log(cpu);
});

console.log(os.networkInterfaces());
*/

/*
var path = require("path");

// 格式化路径
console.log('normalization : ' + path.normalize('/test/test1//2slashes/1slash/tab/..'));

// 连接路径
console.log('joint path : ' + path.join('/test', 'test1', '2slashes/1slash', 'tab', '..'));

// 转换为绝对路径
console.log('resolve : ' + path.resolve('main.js'));

// 路径中文件的后缀名
console.log('ext name : ' + path.extname('main.js'));
*/
/*
var net = require('net');
var server = net.createServer(function(connection) {
    console.log('client connected');
    connection.on('end', function() {
        console.log('客户端关闭连接');
    });
    connection.write('Hello World!\r\n');
    connection.pipe(connection);
});
server.listen(8080, function() {
    console.log('server is listening');
});
*/
/*
var dns = require('dns');

dns.lookup('www.github.com', function onLookup(err, address, family) {
    console.log('ip 地址:', address);
    dns.reverse(address, function (err, hostnames) {
        if (err) {
            console.log(err.stack);
        }

        console.log('反向解析 ' + address + ': ' + JSON.stringify(hostnames));
    });
});
*/

/*
var EventEmitter = require("events").EventEmitter;
var domain = require("domain");

var emitter1 = new EventEmitter();

// 创建域
var domain1 = domain.create();

domain1.on('error', function(err){
    console.log("domain1 处理这个错误 ("+err.message+")");
});

// 显式绑定
domain1.add(emitter1);

emitter1.on('error',function(err){
    console.log("监听器处理此错误 ("+err.message+")");
});

emitter1.emit('error',new Error('通过监听器来处理'));

emitter1.removeAllListeners('error');

emitter1.emit('error',new Error('通过 domain1 处理'));

var domain2 = domain.create();

domain2.on('error', function(err){
    console.log("domain2 处理这个错误 ("+err.message+")");
});

// 隐式绑定
domain2.run(function(){
    var emitter2 = new EventEmitter();
    emitter2.emit('error',new Error('通过 domain2 处理'));
});

domain1.remove(emitter1);
emitter1.emit('error', new Error('转换为异常，系统将崩溃!'))
*/
