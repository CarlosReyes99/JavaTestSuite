# JavaTestSuite
# Proyecto de Demostración de Testing
Este proyecto sirve como ejemplo para mostrar testing básico en Java con JUnit y Mockito.

# Descripción
El proyecto consiste en:

<p>Tests unitarios con JUnit para probar y mejorar la lógica de programación.
Tests con mockito para probar clases que dependen de interfaces/clases externas.
Los test incluyen:</p> 
<ul>
    <li>Test para comprobacion de textos, verifica y espera ciertos textos</li>
    <li>Test para comprobación de password, verifica si tienen seguridad media, débil o fuerte</li>
    <li>Test de simulación de un dado, verifica el número mínimo o máximo para ganar usando Mockito</li>
    <li>Test de precios y descuentos, verifica si tiene precio, agrega precios y devuelve descuentos</li>
    <li>Test de verificación dado un número, verifica y devuelve cierto string dependiendo de su divisibilidad</li>
</ul>

<h2>Requisitos</h2>

<ul>
    <li>Java 8+</li>
    <li>Maven para build</li>
    <li>JUnit 5 para testing unitario</li>
    <li>Mockito para mocks</li>
    <li>Ejecución de test</li>
    <li>JUnit 5 para testing unitario</li>
</ul>

Los tests se pueden ejecutar desde Maven:


Guía de Uso
Clone el repositorio.
Compile con Maven.
Ejecute las pruebas con mvn test.
Revise y estudie los tests en /test/java como ejemplos.
Modifique y cree nuevos tests según sea necesario.

Los tests incluyen ejemplos de:
Test de métodos con @Test
Uso de Assert para validaciones
Mockito para crear objetos simulados
Verificación de comportamiento de mocks
