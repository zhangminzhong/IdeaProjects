package org.apache.mina.cluster.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;

/**
 * 读取param.xml配置文件信息
 * Created by AdministratorZhang on 2018/2/27.
 */
public class XMLParse {
    private static final Logger LOGGER = LoggerFactory.getLogger(XMLParse.class);
    private static SAXReader reader = null;
    private static Document doc = null;
    private static Element root = null;
    private static String masterIp = null;
    private static int clientPort;
    private static int slavePort;

    private void setParams(){
        reader = new SAXReader();
        try {
            doc = reader.read(this.getClass().getResourceAsStream("/param.xml"));
        } catch (DocumentException e) {
            LOGGER.error("文件解析错误",e);
        }
        root = doc.getRootElement();

        Iterator<Element> iterator = root.elementIterator();
        while (iterator.hasNext()){
            Element master = iterator.next();
            Iterator<Element> it = master.elementIterator();
            while (it.hasNext()){
                Element child = it.next();
                String name = child.getName();
                if(name.equals("masterIp")){
                     masterIp = child.getStringValue();
                }
                if(name.equals("clientPort")){
                    clientPort = Integer.parseInt(child.getStringValue());
                }
                if(name.equals("slavePort")){
                    slavePort = Integer.parseInt(child.getStringValue());
                }
            }
        }
    }
    public  String getMasterIp(){
        setParams();
        return masterIp;
    }
    public  int getClientPort(){
        setParams();
        return clientPort;
    }
    public  int getSlavePort(){
        setParams();
        return slavePort;
    }
}
