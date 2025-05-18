<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<html><head><title>First Page</title></head><body>
<f:view>
<h:form>
<h:outputText value="Type your name here: "/>
<h:inputText value=" #{aStringBean.str} " />
<h:commandButton action="goOn" value="Submit" />
</h:form>
</f:view>
</body></html>