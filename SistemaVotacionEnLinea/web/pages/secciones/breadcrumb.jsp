<%-- 
    Document   : breadcrumb
    Created on : 16-sep-2016, 1:47:00
    Author     : Icchigo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<script type="text/javascript">
    try {
        ace.settings.check('breadcrumbs', 'fixed')
    } catch (e) {
    }
</script>

<ul class="breadcrumb">
    <li>
        <i class="ace-icon fa fa-home home-icon"></i>
        <a href="#">Inicio</a>
    </li>
    <li class="active">Menú</li>
</ul><!-- /.breadcrumb -->

<!-- #section:basics/content.searchbox -->
<div class="nav-search" id="nav-search">
    <form class="form-search">
        <span class="input-icon">
            <input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
            <i class="ace-icon fa fa-search nav-search-icon"></i>
        </span>
    </form>
</div><!-- /.nav-search -->