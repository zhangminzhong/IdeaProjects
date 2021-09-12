package org.bookManageSystem.business.reader.web;

import org.bookManageSystem.business.book.entity.Book;
import org.bookManageSystem.business.book.service.BookService;
import org.bookManageSystem.business.reader.entity.ReaderRecord;
import org.bookManageSystem.business.reader.service.ReaderRecordService;
import org.bookManageSystem.fundamental.security.UserContext;
import org.bookManageSystem.fundamental.util.json.JsonMapper;
import org.bookManageSystem.fundamental.util.json.JsonResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: cww
 * Date: 14-12-31
 * Time: 下午4:38
 * To change this template use File | Settings | File Templates.
 */
@Component
@Path("/readerRecord")
public class ReaderRecordServiceWeb {
    @Autowired
    private ReaderRecordService readerRecordService;

    @Autowired
    private BookService bookService;

    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Path("/add")
    @POST
    public String add(@FormParam("jsonString") String jsonString){
        long appId= UserContext.currentUserAppId();
        Map<String, String> map = JsonMapper.buildNonDefaultMapper().fromJson(jsonString, HashMap.class);

        if(map.get("readerId")==null||map.get("readerId").equals("")||map.get("optionTypeId")==null||map.get("optionTypeId").equals("")
                ||map.get("bookSet")==null||map.get("bookSet").equals("")
                ){
            return JsonResultUtils.getCodeAndMesByString(JsonResultUtils.Code.ERROR.getCode(), "参数不能为空!");
        }
        Date createTime = new Date();
        ReaderRecord readerRecord=new ReaderRecord();
        readerRecord.setAppId(appId);
        readerRecord.setBookSet(map.get("bookSet"));
        readerRecord.setReaderId(Long.parseLong(map.get("readerId")));
        readerRecord.setOptionTypeId(Long.parseLong(map.get("optionTypeId")));
        readerRecord.setCreateTime(createTime);
        String curBookSet;
        int curBookSetLength=0;
        try{
            curBookSet =readerRecordService.getCurBookSetByReaderId(readerRecord.getReaderId());
            curBookSetLength=curBookSet.length();
        }catch(Exception e){
            curBookSet="";
            curBookSetLength=0;
        }
        if(readerRecord.getOptionTypeId()==1){
            int length=curBookSetLength+readerRecord.getBookSet().length();
            if(length>10){
                 return JsonResultUtils.getCodeAndMesByString(JsonResultUtils.Code.ERROR.getCode(),"超出借书数量");
            }else
            {
                String[] bookIdList=readerRecord.getBookSet().split(";");
                int i;
                for (i=0;i<bookIdList.length;i++){
                    borrowBook(Long.parseLong(bookIdList[i]));
                }
                curBookSet=curBookSet+readerRecord.getBookSet();
                readerRecord.setCurBookSet(curBookSet);
            }
        }
        else if(readerRecord.getOptionTypeId()==2)
        {
            String[] curBookList=curBookSet.split(";");
            String[] bookIdList=readerRecord.getBookSet().split(";");
            int i,j;

            for(i=0;i<bookIdList.length;i++){
                for(j=0;j<curBookList.length;j++){
                    if(curBookList[j].equals(bookIdList[i])&&curBookList[j]!=""&&bookIdList[i]!=""){
                        returnBook(Long.parseLong(bookIdList[i]));
                        curBookList[j]="";
                        bookIdList[i]="";
                    }
                }
            }
            curBookSet="";
            for(i=0;i<curBookList.length;i++){
                if(curBookList[i]!=""){
                    curBookSet=curBookSet+curBookList[i]+";";
                }
            }
            readerRecord.setCurBookSet(curBookSet);
        }
        readerRecordService.add(readerRecord);
        return JsonResultUtils.getCodeAndMesByStringAsDefault(JsonResultUtils.Code.SUCCESS);
    }

    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Path("/update")
    @POST
    public String update(@FormParam("jsonString") String jsonString){
        ReaderRecord readerRecord= JsonMapper.buildNonDefaultMapper().fromJson(jsonString,ReaderRecord.class);
        if(readerRecord.getBookSet()==null||readerRecord.getBookSet().equals("")
                ){
            return JsonResultUtils.getCodeAndMesByString(JsonResultUtils.Code.ERROR.getCode(), "Book Needed!");
        }

        int result=readerRecordService.update(readerRecord);
        if(result>0){
            return JsonResultUtils.getCodeAndMesByStringAsDefault(JsonResultUtils.Code.SUCCESS) ;
        }
        else {
            return JsonResultUtils.getCodeAndMesByStringAsDefault(JsonResultUtils.Code.ERROR);
        }
    }

    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Path("/delete")
    @POST
//    public  String delete(@FormParam("jsonString") String jsonString)
    public  String delete(@FormParam("id") long id){
        long appId=UserContext.currentUserAppId();
        int result=readerRecordService.deleteById(id,appId);
        if(result>0){
            return JsonResultUtils.getCodeAndMesByStringAsDefault(JsonResultUtils.Code.SUCCESS);
        }
        else {
            return JsonResultUtils.getCodeAndMesByStringAsDefault(JsonResultUtils.Code.ERROR);
        }
    }

    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/list")
    @POST
    public String list(){
        long appId=UserContext.currentUserAppId();
        List<ReaderRecord> list=readerRecordService.getListByAppId(appId);
        return JsonResultUtils.getObjectResultByStringAsDefault(list,JsonResultUtils.Code.SUCCESS);
    }

    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/getReaderRecordById")
    @POST
    public String getReaderRecordById(@FormParam("id")long id){
        long appId=UserContext.currentUserAppId();
        ReaderRecord readerRecord=readerRecordService.getReaderRecordById(id, appId);
        return JsonResultUtils.getObjectResultByStringAsDefault(readerRecord,JsonResultUtils.Code.SUCCESS);
    }

    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/getBookSetById")
    @POST
    public String getBookSetById(@FormParam("id")long id){
        long appId=UserContext.currentUserAppId();
        String bookSet=readerRecordService.getBookSetById(id);
        return JsonResultUtils.getObjectResultByStringAsDefault(bookSet,JsonResultUtils.Code.SUCCESS);
    }
    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/getBookIdListById")
    @POST
    public String getBookIdListById(@FormParam("id")long id){
        String bookSet = readerRecordService.getBookSetById(id);
        String[] bookIdList=bookSet.split(";");
        return  JsonResultUtils.getObjectResultByStringAsDefault(bookIdList,JsonResultUtils.Code.SUCCESS);
    }

    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/borrowBook")
    @POST
    public Boolean borrowBook(long bookId){
        Book book= bookService.getBookById(bookId);
        if(book.getRentNumber()!=0){
            book.setRentNumber(book.getRentNumber()-1);
            book.setCount(book.getCount()+1);
            bookService.update(book);
            return true;
        }
        else return false;
    }

    @Produces(MediaType.APPLICATION_JSON+";charset=UTF-8")
    @Path("/returnBook")
    @POST
    public void returnBook(long bookId){
        Book book= bookService.getBookById(bookId);
        book.setRentNumber(book.getRentNumber()+1);
        bookService.update(book);
    }
}
