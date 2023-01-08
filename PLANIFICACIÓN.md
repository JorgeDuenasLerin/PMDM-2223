
## Programación de aula

- Enero
  - Semana 9-13 - Java
    - [MVVM](#MVVM)
  - Semana 16-20
    - API Retrofit
  - Semana 23-27
    - Retrofit y ListView
- Febrero
  - Semana 30-3
    - Autentificación
  - Semana 6-10
    - Kotlin
  - Semana 13-17
    - Kotlin
  - Semana 20-24
    - Kotlin

## MVVM

Separación de lógica de presentación y lógica de aplicación. No todo el código está en la Activity principal.

- UI: Eventos y mostrar datos
- ModelView: Enlaza la UI con el modelo.
- Model: Datos y transformaciones

![MVVM](resources/mvvm.png)

Hablar del ejercicio de número aleatorio

### Seguir ejemplo

NOTA: Ignorar Fragments
Ejemplo más complejo [MVVM](https://gerardfp.github.io/dam/m8/uf1/mvvm/)

### Ejercicio

Utilizando los ejemplos anteriores crea una aplicación que pida dos números y tenga un radio con 4 operaciones.

Tendrá un botón calcular que utilizará un ViewModel y un Model para realizar el cálculo.

Los cálculos tardan un tiempo aleatorio en realizarse, mientras se espera el cálculo se reportará un mensaje "Esperando al servicio de cálculo"


