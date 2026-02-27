<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style.css">
    <title> Inicio - SeedNow</title>


</head>
<body class="body-index">

    <div class="dashboard-container">
        <h1>Bienvenido a SeedNow</h1>
        <p>Selecciona una opción para comenzar a trabajar</p>

        <div class="menu-grid">

            <a href="gestionUsuarios.jsp" class="card">
                <span>👥</span>
                <h3>Usuarios</h3>
                <small>Registrar, Listar y Eliminar Usuarios</small>
            </a>

            <a href="gestionMensajes.jsp" class="card">
                <span>💬</span>
                <h3>Mensajes</h3>
                <small>Enviar y Ver Historial de Mensajes <br> (En fotosíntesis) </small>
            </a>

            <a href="#" class="card" onclick="alert('Sistema funcionando correctamente. Base de datos: MySQL');">
                <span>⚙️</span>
                <h3>Configuración</h3>
                <small>Enviar y Ver Historial de Mensajes <br>(PROXIMAMENTE) </small>
                <small>Ver estado de conexión </small>
            </a>
        </div>

        <div class="footer">
            @copyright 2026 - SeedNow
        </div>
    </div>

</body>
</html>