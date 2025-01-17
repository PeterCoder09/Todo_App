<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <!-- Incluir Tailwind CSS -->
        <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    </head>
    <body class="bg-gray-100 flex items-center justify-center h-screen">
        <div class="max-w-md w-full bg-white p-8 shadow-lg rounded-lg">
            <div class="flex justify-center mb-4">
                <!-- Logo del sistema (placeholder) -->
                <img src="./assets/icon/icon-iniciar-sesion.png" alt="Logo" class="w-20 h-20">
            </div>
            <h2 class="text-2xl font-bold mb-4 text-center">Inicio de sesión</h2>
            <form action="loginServlet" method="POST">
                <div class="mb-4">
                    <label for="username" class="block text-sm font-medium text-gray-700">Nombre de usuario</label>
                    <input type="text" id="username" name="username" class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm" required>
                </div>
                <div class="mb-6">
                    <label for="password" class="block text-sm font-medium text-gray-700">Contraseña</label>
                    <input type="password" id="password" name="password" class="mt-1 block w-full px-3 py-2 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm" required>
                </div>
                <button type="submit" class="w-full bg-indigo-500 text-white py-2 px-4 rounded-md hover:bg-indigo-600 focus:outline-none focus:bg-indigo-600">Iniciar sesión</button>
            </form>
            <div class="mt-4 text-center">
                <a href="sing_up.jsp" class="text-sm font-medium text-indigo-600 hover:text-indigo-500">Crear cuenta</a>
            </div>
            <div class="mt-4 text-center text-red-500">
                <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : ""%>
            </div>
        </div>
    </body>
</html>
