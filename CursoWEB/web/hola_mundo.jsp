

<%@page import="com.curso.jpa.tablas.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.dyalogo.curso.web.DatosLogin" %>
<%@page import="com.curso.jpa.modelo.DAOUsuarios" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina JSP</title>
        <script type="text/javascript">
            function holaMundo() {
                alert('Hola wn');
            }

            function asignarValorEliminacion(id) {
                if (confirm("Esta seguro de eliminar el registro?") == true) {
                    document.getElementById('txtusuarioEliminar').value = id;
                    document.getElementById('frm').submit();
                }
            }
        </script>
    </head>
    <body>

        <%
            DAOUsuarios daoUsuarios = new DAOUsuarios();
        %>

        <form id="frm" method="POST" action="eliminarUsuario">
            <a href="editar.jsp">Agregar</a>

            <table >
                <tr>
                    <td>ID</td>
                    <td>Email</td>
                    <td>Contraseña</td>
                </tr>

                <% for (Usuarios usuario : daoUsuarios.lista()) {%>
                <tr>
                    <td><%=usuario.getId()%></td> 
                    <td><%=usuario.getEmail()%></td> 
                    <td><%=usuario.getContrasena()%></td> 
                    <td><a href="editar.jsp">Editar</a></td> 
                    <td><a href="#" onclick="asignarValorEliminacion(<%=usuario.getId()%>)">Eliminar</a></td> 

                </tr>
                <% }%> 

            </table>

            <input id="txtusuarioEliminar" type="hidden" name="idUsuario" value=""/>

        </form>
    </body>
</html>
