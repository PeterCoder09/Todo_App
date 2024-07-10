<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Dashboard</title>
        <!-- Incluir Tailwind CSS -->
        <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    </head>
    <body class="bg-gray-100 flex">
        <!-- Sidebar -->
        <nav class="bg-gray-800 text-gray-100 w-64 flex-shrink-0">
            <div class="p-6">
                <!-- Logo del sistema (placeholder) -->
                <img src="./assets/icon/icon-todo.png" alt="Logo" class="w-20 h-20 mb-4 mx-auto">
                <div class="flex flex-col gap-2">
                    <a href="ControladorMenu?action=inicio" class="flex items-center gap-2 rounded-md px-3 py-2 text-sm font-medium transition-colors hover:bg-gray-700 focus:bg-gray-700 focus:outline-none" target="myFrame">
                        <svg class="h-5 w-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3 9 9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z" />
                        <polyline points="9 22 9 12 15 12 15 22" />
                        </svg>
                        Inicio
                    </a>
                    <a href="ControladorMenu?action=tareas" class="flex items-center gap-2 rounded-md px-3 py-2 text-sm font-medium transition-colors hover:bg-gray-700 focus:bg-gray-700 focus:outline-none" target="myFrame">
                        <svg class="h-5 w-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 12h14M12 5v14" />
                        </svg>
                        Tareas
                    </a>
                    <a href="ControladorMenu?action=perfil" class="flex items-center gap-2 rounded-md px-3 py-2 text-sm font-medium transition-colors hover:bg-gray-700 focus:bg-gray-700 focus:outline-none" target="myFrame">
                        <svg class="h-5 w-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 21v-2a4 4 0 0 0-4-4H9a4 4 0 0 0-4 4v2" />
                        <circle cx="12" cy="7" r="4" />
                        </svg>
                        Perfil
                    </a>
                    <a href="ControladorMenu?action=crearTareas" class="flex items-center gap-2 rounded-md px-3 py-2 text-sm font-medium transition-colors hover:bg-gray-700 focus:bg-gray-700 focus:outline-none" target="myFrame">
                        <svg class="h-5 w-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 14l9-5-9-5-9 5 9 5z" />
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 12h14" />
                        </svg>
                        Crear Tareas
                    </a>
                    <a href="ControladorMenu?action=configuracion" class="flex items-center gap-2 rounded-md px-3 py-2 text-sm font-medium transition-colors hover:bg-gray-700 focus:bg-gray-700 focus:outline-none" target="myFrame">
                        <svg class="h-5 w-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 2L2 7.5l10 5 10-5L12 2z" />
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M2 17.5l10 5 10-5m-10-5v9" />
                        </svg>
                        Configuración
                    </a>
                    <a href="ControladorMenu?action=cerrarSesion" class="flex items-center gap-2 rounded-md px-3 py-2 text-sm font-medium transition-colors hover:bg-gray-700 focus:bg-gray-700 focus:outline-none">
                        <svg class="h-5 w-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h4" />
                        <polyline points="16 17 21 12 16 7" />
                        <line x1="21" x2="9" y1="12" y2="12" />
                        </svg>
                        Cerrar Sesión
                    </a>
                </div>
            </div>
        </nav>
        <!-- Contenido principal con iframe -->
        <main class="flex-1 p-6">
            <iframe name="myFrame" class="w-full h-screen border-none"></iframe>
        </main>
    </body>
</html>
