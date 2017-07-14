package com.beecho.easyuse.mvc;

import com.beecho.easyuse.mvc.wrapper.Request;
import com.beecho.easyuse.mvc.wrapper.Response;

import javax.servlet.ServletContext;

/**
 * 当前线程上下文
 * Created by Administrator on 2017/7/13.
 */
public class BeechoContext {

    private static final ThreadLocal<BeechoContext> CONTEXT = new ThreadLocal<BeechoContext>();

    private ServletContext context;
    private Request request;
    private Response response;

    private BeechoContext() {
    }

    public static BeechoContext me(){
        return CONTEXT.get();
    }

    public static void initContext(ServletContext context, Request request, Response response) {
        BeechoContext marioContext = new BeechoContext();
        marioContext.context = context;
        marioContext.request = request;
        marioContext.response = response;
        CONTEXT.set(marioContext);
    }

    public static void remove(){
        CONTEXT.remove();
    }

    public ServletContext getContext() {
        return context;
    }

    public void setContext(ServletContext context) {
        this.context = context;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

}
