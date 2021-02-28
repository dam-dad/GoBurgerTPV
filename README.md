# GoBurgerTPV
Terminal de Punto de Venta (TPV) en JavaFX

**INTEGRANTES**

- TAMARA CAMACHO HÉRNANDEZ

- JOSÉ IGNACIO PÉREZ DELGADO

- MICHAEL JONAY TRUJILLO PADILLA

------

##### **PROYECTO**

El proyecto es el desarrollo de una aplicación que se use en los terminales de punto de venta, que tenga un control sobre los usuarios que tienen acceso a la aplicación mediante un inicio de sesión cuyos datos son guardados en una base de datos de hibérnate, donde también se almacenan los productos disponibles para seleccionar dentro de la aplicación.

------

##### **DISEÑO**

###### **LOGO**

![logo3](C:\Users\ignac\eclipse-workspace\GoBurgerTPV\src\main\resources\images\logo3.png)



###### VENTANA INICIO DE SESIÓN

Esta es la primera ventana de la aplicación, en ella se nos pide los datos de acceso del usuario, cuando se introducen los datos y se pulsa el botón de acceder se comprueba con la base de datos si el usuario es un usuario valido o no,  cuando el usuario sea valido se dará acceso a la aplicación.

![ventanaInicio](C:\Users\ignac\Desktop\imagenesCiclo\ventanaInicio.PNG)

###### VENTANA PRINCIPAL

En esta ventana se lleva a cabo toda la gestión de información sobre los pedidos realizados.



1. Total de la cuenta del tickect, por defecto esta vacío.
2. Exporta el ticket a pdf.
3. Permite ver los tickects anteriores.
4. Botón que permite subir la selección del producto en el ticket.
5. Botón que permite bajar la selección del producto en el ticket.
6. Botón que aumenta en 1 la cantidad en el producto seleccionado en el ticket.
7. Botón que decrece en  1 la cantidad en el producto seleccionado en el ticket.
8. Ticket.
9. Botón de modificar el producto seleccionado.
10. Botón de eliminar el producto seleccionado.
11. Botón que aplica un descuento predefinido en el ticket.
12. Botón "para llevar" que añade al ticket la bolsa y se le añade el coste de la misma.
13. Botón de cancelar el pedido que borra todos los datos.
14. Botón de pagar, para completar el pedido.
15. Botón Home, que permite reestablecer la ventana de productos.
16. Botón Configuración, que permite abrir la ventana de configuración.
17. Productos disponibles, al pulsar una opción se desplegaran los productos en la tabla inferior.
18. Tabla donde se mostraran los productos de la categoría seleccionada.

###### VENTANA DE CONFIGURACIÓN

En esta ventana tenemos la posibilidad de llevar a cabo un poco de configuración, cambiar de usuario, gestionar usuarios y gestionar productos (tanto la gestión de usuarios como productos todavía no esta disponible).

![ventanaConfiguracion](C:\Users\ignac\Desktop\imagenesCiclo\ventanaConfiguracion.PNG)

1. ToggleButton que permite cambiar el tamaño de la letra entre pequeña y normal.
2. ToggleButton que permite activar el modo nocturno, en el cual cuando se activa se pone el fondo oscuro y las letras de color blanco.
3. Botón que nos permite cambiar de usuario.
4. Botón que nos lleva a la ventana donde se controlan los productos (No funcional).
5. Botón que nos lleva a la ventana de control de usuarios (No funcional).
6. Botón que nos permite salir de la aplicación.

------

##### REQUISITOS DEL SISTEMA

- Sistema operativo Windows.