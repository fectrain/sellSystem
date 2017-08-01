<#-- 绝对根路径 -->
<#assign basePath=request.contextPath> 
<div class="n-head">
    <div class="g-doc f-cb">
        <div class="user">
         <#--<#if user??> ${user.usertype}</#if>-->
        <#if user??> 
            <#if user.usertype==1>卖家<#else>买家</#if>你好，<span class="name">${user.username}</span>！<a href="${basePath}/logout">[退出]</a>
        <#else>
            请<a href="${basePath}/login">[登录]</a>
        </#if>
        </div>
        <ul class="nav">
            <li><a href="${basePath}/">首页</a></li>
            <#if user?? && user.usertype==0>
            <li><a href="${basePath}/account">账务</a></li>
            <li><a href="${basePath}/settleAccount">购物车</a></li>
            </#if>
            <#if user?? && user.usertype==1>
            <li><a href="${basePath}/public">发布</a></li>
            </#if>
        </ul>
    </div>
</div>