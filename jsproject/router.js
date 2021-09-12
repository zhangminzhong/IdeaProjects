/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-5-27
 * Time: 下午3:36
 * To change this template use File | Settings | File Templates.
 */
function route(pathname) {
    console.log("About to route a request for " + pathname);
    console.log(__filename);
    console.log(__dirname);
}
exports.route = route;