package com.giraffe.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class PermissionInterceptor implements Interceptor {
	public void destroy() {

	}

	public void init() {

	}
	/**
	 * 验证用户是否登录了
	 */
	public String intercept(ActionInvocation invocation) throws Exception {
		Object obj = ActionContext.getContext().getSession().get("admin");
		return obj==null ? "login" : invocation.invoke();
	}
}
