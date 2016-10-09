<%-- 
    Document   : user-info
    Created on : 25-sep-2016, 15:09:02
    Author     : JH
--%>
<%
    HttpSession sesion = request.getSession();
    String rol = (String) sesion.getAttribute("rol");
    String user = (String) sesion.getAttribute("user");
%>
<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button">
    <img src="../images/avatar.png" class="ico-user" alt="User"><%=user%>
</a>
<ul class="dropdown-menu">
    <li class="header">
        <%=user%><%=rol%>
    </li>
    <li class="body">
        <ul class="menu">
            <li>
                <a href="javascript:void(0);">
                    <div class="icon-circle bg-light-green">
                        <i class="material-icons">account_circle</i>
                    </div>
                    <div class="menu-info">
                        <h4>Perfil</h4>

                    </div>
                </a>
            </li>
            <li>
                <a href="">
                    <div class="icon-circle bg-light-green">
                        <i class="material-icons">exit_to_app</i>
                    </div>
                    <div class="menu-info">
                        <h4>Cerrar Sesi�n</h4>
                    </div>
                </a>
            </li>
        </ul>
    </li>
    <li class="footer">
        <a href="javascript:void(0);">View All Notifications</a>
    </li>
</ul>