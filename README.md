# PMDM-2223

Ver planificación en [planificación](./PLANIFICACIÓN.md)

## Mini proyectos

### Piedra papel o tijera
Crea un juego de de Piedra, Papel o Tijera. Busca los recursos que más te gusten en Internet.

### Información de viaje
En este ejercicio colaborarán dos actividades, una para recogida de información y otra para mostrarla.

Recogida:
- Crea una actividad para recoger los datos de un viaje en taxi.
- Ciudades: Madrid, Santander, Santiago.
  - Ver: [Spinner](https://developer.android.com/develop/ui/views/components/spinner)
- Se pedirá la fecha y la hora de salida
- Se pedirá si es "ida y vuelta" o "solo ida".
- En caso de ser "ida y vuelta", tendrá también fecha y hora de vuelta.
- Nombre de la persona que viaja.
- Dirección de recogida
- DNI de la persona que viaja

NOTA:
- El campo de la segunda fecha solo es visible si se ha seleccionado ida y vuelta, por defecto no.
- El DNI se debe validar antes de enviar la información
- La fecha de vuelta no puede ser anterior a la ida
- La ciudad origen y destino han de ser distintas

Una vez los datos están validados, la actividad una creará un Objeto Viaje (Debes crear la clase), este objeto se enviará a otra actvidad que mostrará un resumen con los datos.

#### Mejoras a la aplicación

Mejoras para la recogida de datos de la aplicación de viajes:

Doc oficial [https://developer.android.com/develop/ui/views/components/pickers](https://developer.android.com/develop/ui/views/components/pickers)
Cómo acceder a los datos. Manejadores. [https://programacionymas.com/blog/como-pedir-fecha-android-usando-date-picker](https://programacionymas.com/blog/como-pedir-fecha-android-usando-date-picker)

#### Lanzar para resultado

Ver ejemplo de lanzar actividad para resultado en el proyecto. Hacer mini actividad del aula virtual.

Haz que la aplicación que muestra la información pida confirmación de los datos con dos botones: Confirmar o Cancelar. Al volver a la actividad principal mostrará un Toas con la decisión: "Usuario confirma información" o "Usuario cancela". En el caso de cancelar se limpiarán todos los datos.

[https://developer.android.com/guide/topics/ui/notifiers/toasts?hl=es-419](https://developer.android.com/guide/topics/ui/notifiers/toasts?hl=es-419)

## Unidad de trabajo 1

Ejercicio de multicontador:
 - Versión todo en la actividad: ```UT01_001```
 - Versión POO: ```UT01_002```


## Acceso a API

3 ejercicios con APIs

### Rick and Morty
- El API de Rick and Morty para sacar un listado de personajes.
- Cuando pinches en uno vas al listado.
- Debajo del listview habrá un botón anterios y siguiente para hacer la paginación.

### Bares
Nuevo API Python

```
Es necesario instalar django-filter

pip install django-filter

pip3 install django-filter
```

Un listado con los controles para filtrar por número de estrellas.

```
Más de 1 estrella
http://127.0.0.1:8000/pmdm/api/bares/?estrellas__gt=1

Más o igual a 2
http://127.0.0.1:8000/pmdm/api/bares/?estrellas__gte=2

```

### Atracciones

Nuevo API de python

Una app con listado de atracciones, al pintar en detalle sacará el detalle con un listview y los comentarios.

```
Todo el listado
http://127.0.0.1:8000/pmdm/api/atracciones/

Listado de 1 y sus comentarios
http://127.0.0.1:8000/pmdm/api/atracciones/1/
```