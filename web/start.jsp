<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Bienvenido a la App de Todo</title>
        <!-- Incluir Tailwind CSS -->
        <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
    </head>
    <body class="flex flex-col items-center justify-center min-h-screen bg-gray-100">
        <section class="flex flex-col items-center justify-center h-[100vh] bg-background">
            <div class="max-w-2xl px-4 py-12 space-y-6 text-center">
                <h1 class="text-4xl font-bold text-foreground">Bienvenido a la App de Todo</h1>
                <p class="text-lg text-muted-foreground">
                    Organízate y mantén el control de tus tareas con nuestra app de todo fácil de usar. Optimiza tu productividad y nunca olvides una tarea. Con nuestra interfaz intuitiva y potentes características, podrás gestionar tu lista de tareas con facilidad.
                </p>
                <p class="text-lg text-muted-foreground">
                    Ya seas un profesional ocupado, un estudiante con múltiples asignaciones, o un ama de casa controlando las tareas del hogar, nuestra App de Todo es la herramienta perfecta para ayudarte a estar al tanto de tus responsabilidades. Crea tareas, establece fechas de vencimiento y márcalas como completas con solo unos clics.
                </p>
                <a href="#" class="inline-flex items-center justify-center h-12 px-8 rounded-md bg-primary text-primary-foreground font-medium shadow transition-colors hover:bg-primary/90 focus-visible:outline-none focus-visible:ring-1 focus-visible:ring-ring disabled:pointer-events-none disabled:opacity-50">
                    Comenzar
                </a>
            </div>
        </section>
    </body>
</html>
