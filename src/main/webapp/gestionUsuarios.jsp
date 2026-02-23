<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.progI.dao.UsuarioImpl" %>
<%@ page import="org.progI.entities.Usuario" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Prueba de Usuarios</title>
    <style>
        body { font-family: sans-serif; padding: 20px; }
        .container { display: flex; gap: 30px; }
        .form-box { background: #f4f4f4; padding: 20px; border-radius: 8px; width: 300px; }
        table { border-collapse: collapse; width: 100%; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #007BFF; color: white; }
        .btn-delete { background: #dc3545; color: white; border: none; padding: 5px 10px; cursor: pointer; }
        .btn-edit { background: #ffc107; border: none; padding: 5px 10px; cursor: pointer; }
        .alert { padding: 10px; background-color: #d4edda; color: #155724; border-radius: 5px; margin-bottom: 15px;}
    </style>
</head>
<body>

    <h1>Panel de Control: Usuarios</h1>

    <%
        String mensaje = (String) request.getAttribute("mensajeExito");
        if (mensaje != null) {
    %>
        <div class="alert"><%= mensaje %></div>
    <% } %>

    <div class="container">

        <div class="form-box">
            <h3>Nuevo Usuario</h3>
            <form action="usuarioServlet" method="post">
                <input type="hidden" name="operacion" value="nuevo">

                <label>Nombre:</label><br>
                <input type="text" name="nombre" required style="width: 95%"><br><br>

                <label>Apellido:</label><br>
                <input type="text" name="apellido" required style="width: 95%"><br><br>

                <label>Email:</label><br>
                <input type="email" name="email" required style="width: 95%"><br><br>

                <label>Teléfono:</label><br>
                <input type="text" name="telefono" style="width: 95%"><br><br>

                <label>Contraseña:</label><br>
                <input type="password" name="contrasenia" required style="width: 95%"><br><br>

                <button type="submit" style="width: 100%; padding: 10px;">Guardar Usuario</button>
            </form>
        </div>

        <div style="flex-grow: 1;">
            <h3>Lista de Usuarios Registrados</h3>

            <%
                // CÓDIGO JAVA INCRUSTADO:
                // Instanciamos el DAO y pedimos la lista para dibujarla
                UsuarioImpl dao = new UsuarioImpl();
                List<Usuario> lista = dao.getAll();
            %>

            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Email</th>
                        <th>Teléfono</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                    // Bucle para crear una fila por cada usuario
                    if(lista.isEmpty()) { %>
                        <tr><td colspan="5" style="text-align:center">No hay usuarios registrados</td></tr>
                    <% } else {
                        for (Usuario u : lista) {
                    %>
                    <tr>
                        <td><%= u.getIdUsuario() %></td>
                        <td><%= u.getNombre() %> <%= u.getApellido() %></td>
                        <td><%= u.getEmail() %></td>
                        <td><%= u.getTelefono() %></td>
                        <td>
                            <form action="usuarioServlet" method="post" style="display:inline;">
                                <input type="hidden" name="operacion" value="eliminar">
                                <input type="hidden" name="idUsuario" value="<%= u.getIdUsuario() %>">
                                <button type="submit" class="btn-delete" onclick="return confirm('¿Seguro que quieres borrar este usuario?');">Eliminar</button>
                            </form>
                        </td>
                    </tr>
                    <%
                        } // fin del for
                       } // fin del else
                    %>
                </tbody>
            </table>
        </div>
    </div>

</body>
</html>