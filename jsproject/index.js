/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-5-27
 * Time: 下午3:42
 * To change this template use File | Settings | File Templates.
 */
var server = require("./server");
var router = require("./router");
server.start(router.route);