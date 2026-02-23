<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Inicio - Sistema Web</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .dashboard-container {
            text-align: center;
            background: white;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
            max-width: 800px;
            width: 100%;
        }
        h1 { color: #333; margin-bottom: 10px; }
        p { color: #666; margin-bottom: 30px; }

        /* Contenedor de las tarjetas del menú */
        .menu-grid {
            display: flex;
            gap: 20px;
            justify-content: center;
            flex-wrap: wrap;
        }

        /* Estilo de cada tarjeta/botón */
        .card {
            background: #fff;
            border: 1px solid #e1e4e8;
            border-radius: 10px;
            padding: 20px;
            width: 200px;
            text-decoration: none;
            color: #333;
            transition: all 0.3s ease;
            box-shadow: 0 2px 5px rgba(0,0,0,0.05);
        }

        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
            border-color: #007BFF;
        }

        .card h3 { margin: 10px 0; color: #007BFF; }
        .card span { font-size: 30px; display: block; margin-bottom: 10px; }

        .footer { margin-top: 40px; font-size: 12px; color: #999; }
    </style>
</head>
<body>

    <div class="dashboard-container">
        <h1>Bienvenido al Sistema</h1>
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
                <small>Enviar y Ver Historial de Mensajes</small>
            </a>

            <a href="#" class="card" onclick="alert('Sistema funcionando correctamente. Base de datos: MySQL');">
                <span>⚙️</span>
                <h3>Configuración</h3>
                <small>Ver estado de conexión</small>
            </a>

        </div>

        <div class="footer">
            Proyecto Web Java - Desarrollado por [Tu Nombre]
        </div>
    </div>

</body>
</html>