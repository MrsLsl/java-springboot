package com.example.javaspringboot.springboot.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.javaspringboot.springboot.common.constant.ConfConstant;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.CompactWriter;
import com.thoughtworks.xstream.io.xml.QNameMap;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.json.XML;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.io.Writer;

/**
 * @author Andy Shen
 */
@Service
public class XStreamUtil {


    public static JSONObject XmlToJSON(String xml) {
        org.json.JSONObject xmlJSONObj = XML.toJSONObject(xml);
        System.out.println("=================>" + xmlJSONObj.toString());
        return JSONObject.parseObject(xmlJSONObj.toString());
    }

    public static  <T> T XStreamToBean(Class<T> clazz, String xml, ConfConstant.XMLConfigType type) {
        String xmlObject = null;
        QNameMap qmaps = new QNameMap();

        type.getNameSpaceMap().entrySet().forEach(item->{
            qmaps.setDefaultPrefix(item.getKey());
            qmaps.setDefaultNamespace(item.getValue());
        });

        XStream xstream = new XStream(new StaxDriver(qmaps));
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(new Class[]{clazz});
        xstream.processAnnotations(clazz);
        xstream.autodetectAnnotations(true);
        Object o = xstream.fromXML(xml);
        xmlObject = JSON.toJSON(o).toString();
        return JSONObject.parseObject(xmlObject,clazz);
    }


    public static String BeanToXML(Object bean){

        XStream xstream = new XStream();
        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(new Class[]{bean.getClass()});
        xstream.processAnnotations(bean.getClass());

        Writer writer = new StringWriter();
        xstream.marshal(bean, new CompactWriter(writer));

        return writer.toString();
    }
}
