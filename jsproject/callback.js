/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-4-22
 * Time: 下午3:32
 * To change this template use File | Settings | File Templates.
 */
function waitFive(name,function_name){
    var pus = 0;
    var currentDate = new Date();
    while(pus<5000){
        var now = new Date();
        pus = now - currentDate;
    }
    function_name(name);
}
function echo(name){
    console.log(name);
}
waitFive("echo方法",echo);
console.log("over");