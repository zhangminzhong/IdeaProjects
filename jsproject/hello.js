/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-5-27
 * Time: 下午2:37
 * To change this template use File | Settings | File Templates.
 */
    //hello.js
function Hello() {
    var name;
    this.setName = function(thyName) {
        name = thyName;
    };
    this.sayHello = function() {
        console.log('Hello ' + name);
    };
};
module.exports = Hello;