package com.example.javaspringboot;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Liusl
 * @Date: 2020/3/27 17:00
 */
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
@RunWith(SpringRunner.class)
@SpringBootTest
public class SwaggerStaticDocTest {
    private String snippetDir = "target/generated-snippets";
    private String outputDir  = "target/asciidoc";

    @Autowired
    private MockMvc mockMvc;

    @After
    public void Test() throws Exception {

        mockMvc.perform(get("/v2/api-docs").accept(MediaType.APPLICATION_JSON))
                .andDo(SwaggerResultHandler.outputDirectory(outputDir).build())
                .andExpect(status().isOk())
                .andReturn();

        Swagger2MarkupConverter.from(outputDir + "/swagger.json")
                .withPathsGroupedBy(GroupBy.TAGS)
                .withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withExamples(snippetDir)
                .build()
                .intoFolder(outputDir);
    }

    @Test
    public void sendSMS() throws Exception {

        SmsRequest  req = new SmsRequest();
        req.setPhoneNumber("must,eg:13810953933");
        req.setSignCode("must,eg:3546dfvfg");
        req.setTmplCode("must,eg:01");
        Map<String, String> obj = new HashMap<String, String>();
        //obj.put("param1", "param1");
        //obj.put("param2", "param2");
        req.setParams(obj);

        mockMvc.perform(post("/sms/sendSMS").contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(req))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andDo(MockMvcRestDocumentation.document("sendSMS", preprocessResponse(prettyPrint())));
    }

    @Test
    public void getVerifyCode() throws Exception {
    	 /*mockMvc.perform(get("/test/test").param("test", "test")
                 .accept(MediaType.APPLICATION_JSON))
                 .andExpect(status().isOk())
                 .andDo(MockMvcRestDocumentation.document("getUser", preprocessResponse(prettyPrint())));
    	*/
        SmsRequest  req = new SmsRequest();
        req.setPhoneNumber("must,eg:13810953933");
        req.setSignCode("must,eg:3546dfvfg");
        req.setTmplCode("must,eg:01/02/...");
        Map<String, String> obj = new HashMap<String, String>();
        req.setParams(obj);

       /* mockMvc.perform(post("/sms/sendSMS").contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(req))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andDo(MockMvcRestDocumentation.document("sendSMS", preprocessResponse(prettyPrint())));*/

        mockMvc.perform(post("/sms/sendVerifyCodeSMS").contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(req))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andDo(MockMvcRestDocumentation.document("sendVerifyCodeSMS", preprocessResponse(prettyPrint())));


        SmsRequest  req2 = new SmsRequest();
        //req2.setPhoneNumber("13810953933");
        //req2.setSignCode("3546dfvfg");
        //req2.setTmplCode("01");
        Map<String, String> obj2 = new HashMap<String, String>();
        obj2.put("code", "must,eg:123456");
        req2.setParams(obj2);

        mockMvc.perform(post("/sms/validate").contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(req2))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andDo(MockMvcRestDocumentation.document("validate", preprocessResponse(prettyPrint())));


        mockMvc.perform(post("/sms/invalid").contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(req2))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andDo(MockMvcRestDocumentation.document("invalid", preprocessResponse(prettyPrint())));

        req2.setPhoneNumber(null);
        req2.setParams(null);

        mockMvc.perform(post("/sms/getVerifyCode").contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSONString(req2))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andDo(MockMvcRestDocumentation.document("getVerifyCode", preprocessResponse(prettyPrint())));

    }
}
