/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-4-22
 * Time: 下午3:13
 * To change this template use File | Settings | File Templates.
 */
function Person(){
    this.think = function(callback){
        setTimeout(function(){console.log('thinking~~~!');callback();},5000);
    }
    this.answer = function(){
        console.log('I am anwering other question!');
    }
}
var person = new Person();
person.think(function(){console.log('thinking 5 second,get the right answer!')});
person.answer();