# ConversorDeMonedas

El Conversor de Monedas es una aplicación de consola escrita en Java que permite convertir montos entre distintas monedas internacionales en tiempo real, utilizando la API de ExchangeRate-API para obtener tasas de cambio actualizadas. El programa está diseñado para ser fácil de usar, con un menú interactivo que permite al usuario seleccionar las monedas de origen y destino, y luego ingresar la cantidad a convertir.

Características clave:
Interfaz interactiva por consola:

El usuario navega a través de menús para seleccionar tanto la moneda de origen como la moneda de destino, y luego ingresa la cantidad a convertir.
El menú está formateado con líneas de asteriscos en la parte superior e inferior para hacerlo visualmente más organizado.
Monedas disponibles:

El conversor incluye varias monedas populares, como el Dólar estadounidense (USD), Euro (EUR), Bolívar venezolano (VES), Peso argentino (ARS), Yuan chino (CNY) y Peso dominicano (DOP).
Puedes fácilmente agregar más monedas según tus necesidades.
Consumo de API para obtener tasas de cambio:

El programa realiza llamadas a la API de ExchangeRate-API para obtener la tasa de cambio actual entre la moneda de origen y la de destino.
Utiliza la clave API proporcionada para acceder a los servicios y asegurar que las conversiones sean precisas y estén actualizadas.
Menús simples y claros:

El programa presenta un menú para la selección de la moneda de origen y otro para la selección de la moneda de destino, lo que facilita la navegación y elección de monedas.
Solo muestra las opciones disponibles para evitar errores en la entrada de datos.
Validación de entradas:

Si el usuario ingresa una opción no válida, se le notifica con un mensaje de error y se le da la oportunidad de intentarlo nuevamente.
Cálculo en tiempo real:

Una vez seleccionadas las monedas y la cantidad, el programa realiza la conversión de manera instantánea utilizando la tasa de cambio obtenida.
Muestra el resultado final con el formato adecuado para que el usuario vea claramente la cantidad convertida.
Flujo de uso:
El usuario inicia el programa y selecciona la moneda de origen del menú.
A continuación, selecciona la moneda de destino a la que desea convertir.
El usuario ingresa la cantidad que desea convertir.
El programa llama a la API para obtener la tasa de cambio actual y realiza el cálculo.
Finalmente, se muestra el resultado de la conversión en la consola.

Ejemplo de conversión:

***********************************
Menú de Opciones
1. USD - Dólar estadounidense
2. EUR - Euro
3. VES - Bolívar venezolano
4. ARS - Peso argentino
5. CNY - Yuan chino
6. DOP - Peso dominicano
7. Salir
***********************************
Seleccione una opción: 1

Ingrese la cantidad a convertir: 100

***********************************
Seleccione la moneda de destino
1. USD - Dólar estadounidense
2. EUR - Euro
3. VES - Bolívar venezolano
4. ARS - Peso argentino
5. CNY - Yuan chino
6. DOP - Peso dominicano
7. Salir
***********************************
Seleccione una opción: 2

100.00 USD son 85.50 EUR
