<%@ page import="escapayments.Transaction" %>
<%@ page import="escapayments.Account" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <title><g:message code="default.pay.label" default="Transfer sum" /></title>
</head>
<body>
<a href="#create-account" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
    </ul>
</div>
<div id="transfer-sum" class="content scaffold-create" role="main">
    <h1><g:message code="default.pay.label" default="Transfer sum" /></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${transactionInstance}">
        <ul class="errors" role="alert">
            <g:eachError bean="${transactionInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form controller="account" action="submitPay" >
        <fieldset class="form">

            <div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'from', 'error')} required">
                <label for="from">
                    <g:message code="account.from.label" default="From" />
                    <span class="required-indicator">*</span>
                </label>
                <g:select name="from" from="${Account.list()}" optionKey="id" optionValue="name" required="required" value="${transactionInstance?.from}"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'to', 'error')} required">
                <label for="to">
                    <g:message code="account.to.label" default="To" />
                    <span class="required-indicator">*</span>
                </label>
                <g:select name="to" from="${Account.list()}" optionKey="id" optionValue="name" required="required" value="${transactionInstance?.to}"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: transactionInstance, field: 'amount', 'error')} required">
                <label for="amount">
                    <g:message code="account.amount.label" default="Amount" />
                    <span class="required-indicator">*</span>
                </label>
                <g:textField name="amount" placeholder="GBP" required="required" value="${transactionInstance?.amount}"/>
            </div>

        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="submit" class="save" value="${message(code: 'default.button.submit.label', default: 'Submit')}" />
        </fieldset>
    </g:form>
</div>
</body>
</html>
